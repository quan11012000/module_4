package org.example.dang_ky.service;

import org.example.dang_ky.dto.UserCreateDTO;
import org.example.dang_ky.entity.User;

import java.util.List;
import java.util.Optional;

public interface IService <T>{
    void save(T t);
    List<T> findAll();
}
