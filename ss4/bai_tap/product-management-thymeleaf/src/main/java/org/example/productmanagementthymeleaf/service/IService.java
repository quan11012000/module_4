package org.example.productmanagementthymeleaf.service;

import java.util.List;

public interface IService<T> {
    List<T> finAll();
    void save(T t);

    T findById(int id);

    void update(int id, T t);

    void remove(int id);
}
