package com.example.Bill_Generation_System.Service;

import com.example.Bill_Generation_System.Model.Customer;
import com.example.Bill_Generation_System.Model.CustomerBill;
import com.example.Bill_Generation_System.Model.Order;
import com.example.Bill_Generation_System.Model.Product;
import com.example.Bill_Generation_System.Repository.CustomerBillRepository;
import com.example.Bill_Generation_System.Repository.CustomerRepository;
import com.example.Bill_Generation_System.Repository.OrderRepository;
import com.example.Bill_Generation_System.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class CustomerBillService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerBillRepository customerBillRepository;

    public String generateCustomerBill(Long orderId) {
        // 1. Fetch the order
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found.";
        }

        // 2. Get customer and product
        Customer customer = order.getCustomer();
        Product product = order.getProduct();

        // 3. Calculate the total payment (Price + GST)
        double totalAmount = product.getProductPrice() * order.getQuantity();
        double gstAmount = totalAmount * (product.getProductGst() / 100);
        totalAmount += gstAmount;

        // 4. Create the Customer Bill
        CustomerBill customerBill = new CustomerBill();
        customerBill.setCustomer(customer);
        customerBill.setProduct(product);
        customerBill.setCustomerName(customer.getCustomerName());
        customerBill.setCustomerEmail(customer.getCustomerEmail());
        customerBill.setCustomerMobileNumber(customer.getCustomerMobileNumber());
        customerBill.setProductName(product.getProductName());
        customerBill.setProductPrice(product.getProductPrice());
        customerBill.setProductGst(product.getProductGst());
        customerBill.setTotalPayment(totalAmount);
        customerBill.setBillDate(LocalDate.now());
        customerBill.setBillTime(LocalTime.now());

        // 5. Save the Customer Bill
        customerBillRepository.save(customerBill);

        return "Bill generated successfully.";
    }
}