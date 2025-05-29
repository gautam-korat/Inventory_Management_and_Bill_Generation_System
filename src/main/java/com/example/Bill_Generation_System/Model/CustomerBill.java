package com.example.Bill_Generation_System.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer_bill")
public class CustomerBill
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_mobile_number", nullable = false)
    private String customerMobileNumber;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @Column(name = "product_gst", nullable = false)
    private Double productGst;

    @Column(name = "total_payment", nullable = false)
    private Double totalPayment;

    @Column(name = "bill_date", nullable = false)
    private LocalDate billDate;

    @Column(name = "bill_time", nullable = false)
    private LocalTime billTime;

    // Default constructor
    public CustomerBill() {}

    // Parameterized constructor
    public CustomerBill(Long billId, Customer customer, String customerName, String customerEmail,
                        String customerMobileNumber, Product product, String productName,
                        Double productPrice, Double productGst, Double totalPayment,
                        LocalDate billDate, LocalTime billTime) {
        this.billId = billId;
        this.customer = customer;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMobileNumber = customerMobileNumber;
        this.product = product;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productGst = productGst;
        this.totalPayment = totalPayment;
        this.billDate = billDate;
        this.billTime = billTime;
    }

    // Getter Setter

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null) {
            this.customerName = customer.getCustomerName();
            this.customerEmail = customer.getCustomerEmail();
            this.customerMobileNumber = customer.getCustomerMobileNumber();
        }
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        if (product != null) {
            this.productName = product.getProductName();
            this.productPrice = product.getProductPrice();
            this.productGst = product.getProductGst();
        }
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