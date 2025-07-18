package org.example.productmanagementthymeleaf.service.impl;

import org.example.productmanagementthymeleaf.entity.Product;
import org.example.productmanagementthymeleaf.repository.IProductRepository;
import org.example.productmanagementthymeleaf.repository.impl.ProductRepositoryImpl;
import org.example.productmanagementthymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired IProductRepository productRepository;
    @Override
    public List<Product> finAll() {
        return productRepository.finAll();
    }

    @Override
    public void save(Product product) {
        List<Product> products = productRepository.finAll();
        int currentId =  products.get(products.size() - 1).getId();
        product.setId(currentId+1);
        productRepository.save(product);

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.save(product);
    }

    @Override
    public boolean remove(int id) {
        return productRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
