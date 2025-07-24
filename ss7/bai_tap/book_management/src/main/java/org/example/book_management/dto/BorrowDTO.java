package org.example.book_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BorrowDTO {
    private String code;
    private Long bookId;
    private String bookTitle;
    private LocalDateTime borrowDate;
    private boolean returned;
}
