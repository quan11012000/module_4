package org.example.song_management.service;

import java.util.List;

public interface IService <T>{
    List<T> findAll();
    void save(T t);
    T findById(Long id);
}
