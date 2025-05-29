package com.example.Bill_Generation_System.DTO;

public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String customerMobileNumber;
    private String customerEmail;

    // Constructors
    public CustomerDTO() {
    }

    public CustomerDTO(Long customerId, String customerName, String customerMobileNumber, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobileNumber = customerMobileNumber;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;

    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
