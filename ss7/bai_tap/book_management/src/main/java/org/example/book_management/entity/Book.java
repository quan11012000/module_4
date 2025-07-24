package org.example.book_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @Table(name = "books")
    public class Book extends Parent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String author;
        private int quantity;
    }

