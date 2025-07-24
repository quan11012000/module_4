package org.example.book_management.service;

import org.example.book_management.entity.Book;
import org.example.book_management.entity.BorrowBook;
import org.example.book_management.repository.IBookRepository;
import org.example.book_management.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IBorrowRepository borrowRepository;
    private String generateCode() {
        return String.format("%05d", new Random().nextInt(100000));
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book finById(long id) {
        return bookRepository.findById(id).orElse(null);
    }



}
