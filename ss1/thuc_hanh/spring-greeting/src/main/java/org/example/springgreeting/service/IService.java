package org.example.springgreeting.service;

import java.util.List;

public interface IService<T> {

    List<T> findAll();
    void add(T student);
}
