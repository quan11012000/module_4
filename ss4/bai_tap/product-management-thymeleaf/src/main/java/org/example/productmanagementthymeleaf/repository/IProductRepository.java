package org.example.productmanagementthymeleaf.repository;

import org.example.productmanagementthymeleaf.entity.Product;

import java.util.List;

public interface IProductRepository extends IRepository<Product>{
    List<Product> searchByName(String name);
}
