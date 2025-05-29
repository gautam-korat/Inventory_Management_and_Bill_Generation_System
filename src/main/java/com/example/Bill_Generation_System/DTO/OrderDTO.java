package com.example.Bill_Generation_System.DTO;

public class OrderDTO {
    private Long orderId;
    private Long customerId;
    private Long productId;
    private Double totalAmount;
    private Integer quantity;
    private String productName;
    private String customerName;

    // Constructors
    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Long customerId, Long productId, Double totalAmount, Integer quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
