package org.example.cart.service;

import org.example.cart.entity.CartItem;
import org.example.cart.entity.Order;
import org.example.cart.entity.OrderItem;

import java.util.List;

public interface IOrderService extends IService<Order, Long>{
    Order placeOrder(Order order, List<CartItem> cartItemList);
}
