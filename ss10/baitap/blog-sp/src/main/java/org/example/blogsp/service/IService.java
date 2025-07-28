package org.example.blogsp.service;

import org.example.blogsp.entity.Blog;

import java.util.List;

public interface IService<T>{
    List<T> findAll();
    T findById(Integer id);
    Boolean add(T t);
    Boolean update(Integer id,T t);
    Boolean deleteById(Integer id);
}
