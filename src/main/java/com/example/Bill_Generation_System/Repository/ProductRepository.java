package com.example.Bill_Generation_System.Repository;

import com.example.Bill_Generation_System.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{
    Product findByProductName(String productName);
}