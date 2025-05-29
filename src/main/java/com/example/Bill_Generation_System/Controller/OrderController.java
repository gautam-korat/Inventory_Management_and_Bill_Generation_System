package com.example.Bill_Generation_System.Controller;

import com.example.Bill_Generation_System.DTO.OrderDTO;
import com.example.Bill_Generation_System.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/create") // http://localhost:8080/Order/create
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO)
    {
        String response = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
