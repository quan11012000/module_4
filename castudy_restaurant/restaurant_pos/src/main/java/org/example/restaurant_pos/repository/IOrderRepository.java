package org.example.restaurant_pos.repository;

import org.example.restaurant_pos.entity.Order;
import org.example.restaurant_pos.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByStatus(OrderStatus status);
}
