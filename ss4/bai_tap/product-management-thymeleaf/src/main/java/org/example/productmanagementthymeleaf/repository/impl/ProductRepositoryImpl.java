package org.example.productmanagementthymeleaf.repository.impl;

import org.example.productmanagementthymeleaf.entity.Product;
import org.example.productmanagementthymeleaf.repository.BaseRepository;
import org.example.productmanagementthymeleaf.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements IProductRepository {


    @Override
    public List<Product> finAll() {
        return BaseRepository.entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void update(int id, Product product) {
        product.setId(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public boolean remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = BaseRepository.entityManager.find(Product.class, id);
            if (product != null) {
                BaseRepository.entityManager.remove(product);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        return BaseRepository.entityManager
                .createQuery("SELECT p FROM Product p WHERE p.name LIKE :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
