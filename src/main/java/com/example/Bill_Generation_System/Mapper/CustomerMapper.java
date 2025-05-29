package com.example.Bill_Generation_System.Mapper;

import com.example.Bill_Generation_System.DTO.CustomerDTO;
import com.example.Bill_Generation_System.Model.Customer;


public class CustomerMapper
{
    public static CustomerDTO toDTO(Customer customer)
    {
        if (customer == null)
        {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setCustomerMobileNumber(customer.getCustomerMobileNumber());
        customerDTO.setCustomerEmail(customer.getCustomerEmail());
        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO)
    {
        if (customerDTO == null)
        {
            return null;
        }
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerMobileNumber(customerDTO.getCustomerMobileNumber());
        customer.setCustomerEmail(customerDTO.getCustomerEmail());
        return customer;
    }

//    // Convert List<Customer> to List<CustomerDTO>
//    public List<CustomerDTO> toDTOList(List<Customer> customers) {
//        if (customers == null) {
//            return null;
//        }
//        return customers.stream()
//                .map(this::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    // Convert List<CustomerDTO> to List<Customer>
//    public List<Customer> toEntityList(List<CustomerDTO> customerDTOs) {
//        if (customerDTOs == null) {
//            return null;
//        }
//        return customerDTOs.stream()
//                .map(this::toEntity)
//                .collect(Collectors.toList());
//    }
}
