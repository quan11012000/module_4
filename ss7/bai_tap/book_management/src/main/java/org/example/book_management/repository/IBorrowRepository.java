package org.example.book_management.repository;

import org.example.book_management.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowRepository extends JpaRepository<BorrowBook,Long> {
    Optional<BorrowBook> findByCode(String code);
}
