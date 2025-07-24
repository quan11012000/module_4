package org.example.book_management.service;

public interface IBorrowService {
    String borrowBook(long id);
    boolean returnBook(String code);
}
