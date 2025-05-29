package com.example.Bill_Generation_System.Service;

import com.example.Bill_Generation_System.DTO.ProductDTO;
import com.example.Bill_Generation_System.Mapper.ProductMapper;
import com.example.Bill_Generation_System.Model.Product;
import com.example.Bill_Generation_System.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    // Add a new product
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    // Get all products
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a product by ID
    public ProductDTO getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(ProductMapper::toDTO).orElse(null);
    }

    // Update product
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setProductName(productDTO.getProductName());
            existingProduct.setProductPrice(productDTO.getProductPrice());
            existingProduct.setProductGst(productDTO.getProductGst());
            existingProduct.setProductStock(productDTO.getProductStock());
            Product updatedProduct = productRepository.save(existingProduct);
            return ProductMapper.toDTO(updatedProduct);
        }
        return null;  // Product not found
    }

    // Delete a product
    public boolean deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;  // Product successfully deleted
        }
        return false;  // Product not found
    }

    public String addStock(String productName, int quantity)
    {
        Product product = productRepository.findByProductName(productName);
        if(product == null)
        {
            return "Product Not Found";
        }
        product.setProductStock(product.getProductStock() + quantity);
        productRepository.save(product);
        return quantity + " Products Have Been Added To Stock ---> " + productName;
    }
}