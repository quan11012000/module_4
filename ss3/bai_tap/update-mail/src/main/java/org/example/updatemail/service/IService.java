package org.example.updatemail.service;

import java.util.List;

public interface IService<T>{
    T getSettings();
    void update(T t);
    List<String> getLanguages();
    List<Integer> getPageSizes();
}
