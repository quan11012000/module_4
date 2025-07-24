package org.example.book_management.service;

import org.example.book_management.entity.Book;

import java.util.List;

public interface IBookService extends IService<Book> {
    List<Book> findAll();
    Book finById(long id);
}
