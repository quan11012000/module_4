package org.example.restaurant_pos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.restaurant_pos.entity.Order;
import org.example.restaurant_pos.enums.OrderStatus;
import org.example.restaurant_pos.repository.IOrderRepository;
import org.example.restaurant_pos.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
