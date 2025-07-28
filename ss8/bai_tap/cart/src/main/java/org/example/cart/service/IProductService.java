package org.example.cart.service;

import org.example.cart.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product, Long> {
    List<Product> searchByName(String keyword);
}
