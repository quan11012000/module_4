package org.example.productmanagementthymeleaf.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> finAll();
    void save(T t);

    T findById(int id);

    void update(int id, T t);

    void remove(int id);
}
