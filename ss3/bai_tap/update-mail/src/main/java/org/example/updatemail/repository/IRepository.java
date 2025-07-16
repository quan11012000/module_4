package org.example.updatemail.repository;

public interface IRepository<T>{
    T getDefaultSettings();
    void updateSettings(T t);
}
