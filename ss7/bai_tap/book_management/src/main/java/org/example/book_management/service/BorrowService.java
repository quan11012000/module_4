package org.example.book_management.service;

import org.example.book_management.entity.Book;
import org.example.book_management.entity.BorrowBook;
import org.example.book_management.repository.IBookRepository;
import org.example.book_management.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BorrowService implements IBorrowService{
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IBorrowRepository borrowRepository;

    private String generateCode() {
        return String.format("%05d", new Random().nextInt(100000));
    }

    @Override
    public String borrowBook(long id) {
        Book book=bookRepository.findById(id).orElse(null);
        if(book==null || book.getQuantity()<=0){
            return null;
        }
        book.setQuantity(book.getQuantity()-1);
        bookRepository.save(book);
        String code= generateCode();
        BorrowBook borrowBook=new BorrowBook();
        borrowBook.setCode(code);
        borrowBook.setBook(book);
        borrowRepository.save(borrowBook);
        return code;
    }


    @Override
    public boolean returnBook(String code) {
        Optional<BorrowBook> borrowOpt = borrowRepository.findByCode(code);
        if (borrowOpt.isEmpty()) return false;

        BorrowBook borrowBook = borrowOpt.get();
        Book book = borrowBook.getBook();

        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowRepository.delete(borrowBook);

        return true;
    }
}
