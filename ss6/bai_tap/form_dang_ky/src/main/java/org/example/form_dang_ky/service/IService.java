package org.example.form_dang_ky.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface IService<T>{
    List<T> findAll();
    T findById(Integer id);
    Boolean add(T t);
    Boolean update(Integer id,T t);
    Boolean deleteById(Integer id);

}
