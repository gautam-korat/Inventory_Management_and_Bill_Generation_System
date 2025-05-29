package com.example.Bill_Generation_System.Mapper;

import com.example.Bill_Generation_System.DTO.ProductDTO;
import com.example.Bill_Generation_System.Model.Product;

public class ProductMapper
{
    public static ProductDTO toDTO(Product product)
    {
        if (product == null)
        {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductGst(product.getProductGst());
        productDTO.setProductStock(product.getProductStock());

        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO)
    {
        if (productDTO == null)
        {
            return null;
        }

        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductGst(productDTO.getProductGst());
        product.setProductStock(productDTO.getProductStock());

        return product;
    }
}