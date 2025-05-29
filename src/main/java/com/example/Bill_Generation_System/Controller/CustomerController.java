package com.example.Bill_Generation_System.Controller;

import com.example.Bill_Generation_System.DTO.CustomerDTO;
import com.example.Bill_Generation_System.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("/Add-Customer") // post :- http://localhost:8080/Customer/Save-Customer
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO savedCustomer = customerService.addCustomer(customerDTO);
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping("/All-Customer") // get :- http://localhost:8080/Customer/All-Customer
    public ResponseEntity<List<CustomerDTO>> getAllCustomer()
    {
        List<CustomerDTO> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/Get-Customer-By-Id/{customerId}") // get :- http://localhost:8080/Customer/Get-Customer-By-Id
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId)
    {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/Update-Customer-Details/{customerId}") // Put :- http://localhost:8080/Customer/Update-Customer-Details
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerId, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/Delete-Customer/{customerId}") // delete :- http://localhost:8080/Customer/Delete-Customer
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId)
    {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully.");
    }
}