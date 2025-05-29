package com.example.Bill_Generation_System.Service;

import com.example.Bill_Generation_System.DTO.OrderDTO;
import com.example.Bill_Generation_System.Model.Customer;
import com.example.Bill_Generation_System.Model.Order;
import com.example.Bill_Generation_System.Model.Product;
import com.example.Bill_Generation_System.Repository.CustomerRepository;
import com.example.Bill_Generation_System.Repository.OrderRepository;
import com.example.Bill_Generation_System.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerBillService customerBillService;

    @Autowired
    private StockReportService stockReportService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private WhatsAppService whatsappService;

    @Autowired
    private SMSService smsService;

    @Value("${twilio.whatsapp_to}")
    private String adminWhatsappNumber;

    @Value("${twilio.sms_to}")
    private String adminSmsNumber;

    public String createOrder(OrderDTO orderDTO) {
        // 1. Customer Validation
        Customer customer = customerRepository.findByCustomerName(orderDTO.getCustomerName());
        if (customer == null) {
            return "Customer is not registered.";
        }

        // 2. Product Validation
        Product product = productRepository.findByProductName(orderDTO.getProductName());
        if (product == null) {
            return "Product not found.";
        }

        // 3. Check product stock
        if (product.getProductStock() < orderDTO.getQuantity()) {
            return "Product is out of stock.";
        }

        // 4. Calculate Total Amount
        double totalAmount = product.getProductPrice() * orderDTO.getQuantity();
        double gstAmount = totalAmount * (product.getProductGst() / 100);
        totalAmount += gstAmount;

        // 5. Payment
        boolean paymentStatus = payment(totalAmount);
        if (!paymentStatus) {
            whatsappService.sendWhatsAppMessage(customer.getCustomerMobileNumber(),
                    "Payment failed! Your order could not be completed.");
            return "Payment Failed";
        }

        // 6. Create Order
        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setTotalAmount(totalAmount);
        order.setQuantity(orderDTO.getQuantity());

        orderRepository.save(order);

        // 7. Update Product Stock
        product.setProductStock(product.getProductStock() - orderDTO.getQuantity());
        productRepository.save(product);

        // 8. Create Bill
        customerBillService.generateCustomerBill(order.getOrderId());

        // 9. Notification Admin if Stock Below Threshold
        if (product.getProductStock() < 10) {
            String message = "Stock Alert: " + product.getProductName() + " available stock: " + product.getProductStock();
            whatsappService.sendWhatsAppMessage(adminWhatsappNumber, message);
            smsService.sendSms(adminSmsNumber, message);
        }

        // 10. Send stock report to admin
        stockReportService.sendStockReportMessageTOWhatsApp(customer.getCustomerMobileNumber());

        // 11. Send WhatsApp Message to Customer
        whatsappService.sendWhatsAppMessage(customer.getCustomerMobileNumber(),
                "Payment successful! Your order has been completed.");

        // 12. Send Email Attached stock report CSV file
        String emailSubject = "Stock Report";
        String emailBody = "Dear Admin,\n\nPlease check the attached stock report CSV file.\n\nThank you.";
        String CSVFilePath = stockReportService.sendStockReportMessageTOWhatsApp(adminWhatsappNumber);
        emailService.sendEmailTOAdminStockReportWithCSVFile("gautamkorat7172@gmail.com", emailSubject, emailBody, CSVFilePath);

        return "Payment successful! Your order has been completed.";

        // 13. SEND Text Message
//        smsService.sendSms(customer.getCustomerMobileNumber(), "Payment successful! Your order has been successfully created.");
//       return "Payment successful! Your order has been successfully created.";


        // -----------------------
//        smsService.sendSms(customer.getCustomerMobileNumber(),
//                "Payment successful! Your order has been successfully created.");
//
//        WhatsAppService.sendWhatsAppMessage(customer.getCustomerMobileNumber(),
//                "Payment successful! Your order has been successfully created.");
//
//        return "Payment successful! Your order has been successfully created.";
    }

    private boolean payment(double amount)
    {
        return Math.random() > 0.5;
    }
}