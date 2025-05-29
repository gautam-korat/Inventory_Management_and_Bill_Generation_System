package com.example.Bill_Generation_System.DTO;

public class StockDTO {

    private String productName;
    private int quantity;

    // Constructors
    public StockDTO() {}

    public StockDTO(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

