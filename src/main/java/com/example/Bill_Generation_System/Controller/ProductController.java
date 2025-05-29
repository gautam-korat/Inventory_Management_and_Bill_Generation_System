package com.example.Bill_Generation_System.Controller;

import com.example.Bill_Generation_System.DTO.ProductDTO;
import com.example.Bill_Generation_System.DTO.StockDTO;
import com.example.Bill_Generation_System.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping("/add-product") // http://localhost:8080/Product/add-product
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO)
    {
        ProductDTO AddedProduct = productService.addProduct(productDTO);
        return new ResponseEntity<>(AddedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all-product") // http://localhost:8080/Product/all-product
    public ResponseEntity<List<ProductDTO>> getAllProduct()
    {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get-product-by-id/{productId}") // http://localhost:8080/Product/get-product-by-id
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId)
    {
        ProductDTO product = productService.getProductById(productId);
        if (product != null)
        {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-product/{productId}") // http://localhost:8080/Product/update-product
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO)
    {
        ProductDTO updatedProduct = productService.updateProduct(productId, productDTO);
        if (updatedProduct != null)
        {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-product/{productId}") // http://localhost:8080/Product/delete-product
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId)
    {
        boolean isDeleted = productService.deleteProduct(productId);
        if (isDeleted)
        {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add-Stock") // http://localhost:8080/Product/add-Stock

    // Stock Add Using StockDTO
    public ResponseEntity<String> addStock(@RequestBody StockDTO stockDTO)
    {
        String stockAdd = productService.addStock(stockDTO.getProductName(), stockDTO.getQuantity());
        return ResponseEntity.ok(stockAdd);
    }

    // Stock Add Using Url :- http://localhost:8080/Product/add-Stock?productName=dellLaptop&quantity=500
//    public ResponseEntity<String> addStock (@RequestBody String productName, int quantity)
//    {
//        String stockAdd = productService.addStock(productName,quantity);
//        return ResponseEntity.ok(stockAdd);
//    }

    // Stock Add Without Using StockDTO
//    public ResponseEntity<String> addStock(@RequestBody Map<String, Object> requestBody)
//    {
//        String productName = (String) requestBody.get("productName");
//        Integer quantity = (Integer) requestBody.get("quantity");
//
//        String stockAdd = productService.addStock(productName, quantity);
//        return ResponseEntity.ok(stockAdd);
//    }

}