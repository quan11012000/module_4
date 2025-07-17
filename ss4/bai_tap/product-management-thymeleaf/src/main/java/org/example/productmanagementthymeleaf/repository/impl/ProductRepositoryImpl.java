package org.example.productmanagementthymeleaf.repository.impl;

import org.example.productmanagementthymeleaf.entity.Product;
import org.example.productmanagementthymeleaf.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 15", "Apple smartphone", 999.99));
        products.put(2, new Product(2, "Samsung Galaxy S23", "Samsung flagship phone", 899.99));
        products.put(3, new Product(3, "Dell XPS 13", "Powerful ultrabook", 1299.00));
        products.put(4, new Product(4, "Sony WH-1000XM5", "Noise cancelling headphones", 399.99));
        products.put(5, new Product(5, "Logitech MX Master 3", "Advanced wireless mouse", 99.99));
        products.put(6, new Product(6, "Amazon Kindle", "E-book reader", 139.99));
        products.put(7, new Product(7, "iPad Pro", "Apple tablet with M2 chip", 1099.00));
        products.put(8, new Product(8, "MacBook Air M2", "Lightweight Apple laptop", 1199.00));
        products.put(9, new Product(9, "Google Pixel 8", "Google's flagship phone", 799.99));
        products.put(10, new Product(10, "OnePlus 11", "High-performance Android phone", 699.99));
    }
    @Override
    public List<Product> finAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(product);
            }
        }
        return productList;
    }
}
