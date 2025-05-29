package com.example.Bill_Generation_System.Mapper;

import com.example.Bill_Generation_System.DTO.CustomerBillDTO;
import com.example.Bill_Generation_System.Model.Customer;
import com.example.Bill_Generation_System.Model.CustomerBill;
import com.example.Bill_Generation_System.Model.Product;

public class CustomerBillMapper
{
    public static CustomerBillDTO toDTO(CustomerBill customerBill)
    {
        CustomerBillDTO dto = new CustomerBillDTO();

        dto.setBillId(customerBill.getBillId());

        dto.setCustomerId(customerBill.getCustomer().getCustomerId());
        dto.setProductId(customerBill.getProduct().getProductId());

        dto.setCustomerName(customerBill.getCustomerName());
        dto.setCustomerEmail(customerBill.getCustomerEmail());
        dto.setCustomerMobileNumber(customerBill.getCustomerMobileNumber());
        dto.setProductName(customerBill.getProductName());
        dto.setProductPrice(customerBill.getProductPrice());
        dto.setProductGst(customerBill.getProductGst());
        dto.setTotalPayment(customerBill.getTotalPayment());
        dto.setBillDate(customerBill.getBillDate());
        dto.setBillTime(customerBill.getBillTime());

        return dto;
    }

    public static CustomerBill toEntity(CustomerBillDTO customerBillDTO)
    {
        CustomerBill customerBill = new CustomerBill();

        Customer customer = new Customer();
        customer.setCustomerId(customerBillDTO.getCustomerId());

        Product product = new Product();
        product.setProductId(customerBillDTO.getProductId());

        customerBill.setCustomer(customer);
        customerBill.setProduct(product);

        customerBill.setBillId(customerBillDTO.getBillId());
        customerBill.setCustomerName(customerBillDTO.getCustomerName());
        customerBill.setCustomerEmail(customerBillDTO.getCustomerEmail());
        customerBill.setCustomerMobileNumber(customerBillDTO.getCustomerMobileNumber());
        customerBill.setProductName(customerBillDTO.getProductName());
        customerBill.setProductPrice(customerBillDTO.getProductPrice());
        customerBill.setProductGst(customerBillDTO.getProductGst());
        customerBill.setTotalPayment(customerBillDTO.getTotalPayment());
        customerBill.setBillDate(customerBillDTO.getBillDate());
        customerBill.setBillTime(customerBillDTO.getBillTime());

        return customerBill;
    }
}
