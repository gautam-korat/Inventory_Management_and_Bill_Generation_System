package com.example.Bill_Generation_System.Mapper;

import com.example.Bill_Generation_System.DTO.OrderDTO;
import com.example.Bill_Generation_System.Model.Customer;
import com.example.Bill_Generation_System.Model.Order;
import com.example.Bill_Generation_System.Model.Product;

public class OrderMapper
{
    public static OrderDTO toDTO(Order order)
    {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomerId(order.getCustomer().getCustomerId());
        orderDTO.setProductId(order.getProduct().getProductId());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setQuantity(order.getQuantity());

        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO, Customer customer, Product product)
    {
        Order order = new Order();

        order.setOrderId(orderDTO.getOrderId());
        order.setCustomer(customer);
        order.setProduct(product);

        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setQuantity(orderDTO.getQuantity());

        return order;
    }
}
