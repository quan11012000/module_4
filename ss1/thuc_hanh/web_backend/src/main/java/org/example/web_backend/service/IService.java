package org.example.web_backend.service;

import org.example.web_backend.entity.Customer;

import java.util.List;

public interface IService<T> {

    List<T> findAll();
    void add(T student);
    public Customer findById(int id);
}
