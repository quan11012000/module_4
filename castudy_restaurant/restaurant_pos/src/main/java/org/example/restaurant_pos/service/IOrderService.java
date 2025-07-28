package org.example.restaurant_pos.service;

import org.example.restaurant_pos.entity.Order;
import org.example.restaurant_pos.enums.OrderStatus;

import java.util.List;

public interface IOrderService {
    List<Order> findByStatus(OrderStatus status);
    Order findById(Integer id);
}
