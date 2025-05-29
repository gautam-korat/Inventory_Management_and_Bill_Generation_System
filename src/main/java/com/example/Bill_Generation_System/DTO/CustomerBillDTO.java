package com.example.Bill_Generation_System.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerBillDTO {

    private Long billId;
    private Long customerId;
    private Long productId;
    private String customerName;
    private String customerEmail;
    private String customerMobileNumber;
    private String productName;
    private Double productPrice;
    private Double productGst;
    private Double totalPayment;
    private LocalDate billDate;
    private LocalTime billTime;

    // Getters and Setters

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductGst() {
        return productGst;
    }

    public void setProductGst(Double productGst) {
        this.productGst = productGst;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public LocalTime getBillTime() {
        return billTime;
    }

    public void setBillTime(LocalTime billTime) {
        this.billTime = billTime;
    }
}
