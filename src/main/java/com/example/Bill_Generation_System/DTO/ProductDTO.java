package com.example.Bill_Generation_System.DTO;

public class ProductDTO {
    private Long productId;
    private String productName;
    private Double productPrice;
    private Double productGst;
    private Integer productStock;

    // Constructors
    public ProductDTO() {
    }

    public ProductDTO(Long productId, String productName, Double productPrice, Double productGst, Integer productStock) {
        this.productId = productId;
        this.productName = productName;

        this.productPrice = productPrice;
        this.productGst = productGst;
        this.productStock = productStock;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }
}
