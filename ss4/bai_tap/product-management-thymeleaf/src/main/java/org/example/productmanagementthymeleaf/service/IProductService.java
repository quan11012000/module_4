package org.example.productmanagementthymeleaf.service;

import org.example.productmanagementthymeleaf.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> searchByName(String name);
}
