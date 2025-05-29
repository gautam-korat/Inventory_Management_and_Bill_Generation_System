package com.example.Bill_Generation_System.Service;

import com.example.Bill_Generation_System.DTO.CustomerDTO;
import com.example.Bill_Generation_System.Mapper.CustomerMapper;
import com.example.Bill_Generation_System.Model.Customer;
import com.example.Bill_Generation_System.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    // Add Customer
    public CustomerDTO addCustomer(CustomerDTO customerDTO)
    {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(savedCustomer);
    }

    // Update Customer
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO)
    {
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        existingCustomer.setCustomerName(customerDTO.getCustomerName());
        existingCustomer.setCustomerMobileNumber(customerDTO.getCustomerMobileNumber());
        existingCustomer.setCustomerEmail(customerDTO.getCustomerEmail());

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    // Delete Customer
    public void deleteCustomer(Long customerId)
    {
        if (!customerRepository.existsById(customerId))
        {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
        customerRepository.deleteById(customerId);
    }

    // Get All Customers
    public List<CustomerDTO> getAllCustomer()
    {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Customer By ID
    public CustomerDTO getCustomerById(Long customerId)
    {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        return CustomerMapper.toDTO(customer);
    }
}
