package org.example.book_management.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(value = "execution(* org.example.book_management.service.BookService.borrowBook(..))", returning = "code")
    public void logBorrowAction(Object code) {
        if (code != null) {
            logger.info("Người dùng đã mượn sách. Mã mượn: {}", code);
        } else {
            logger.warn("Người dùng cố mượn sách nhưng không thành công (hết sách hoặc sai ID).");
        }
    }

    @AfterReturning(value = "execution(* org.example.book_management.service.BookService.returnBook(..))", returning = "result")
    public void logReturnAction(boolean result) {
        if (result) {
            logger.info("Trả sách thành công.");
        } else {
            logger.warn("Trả sách thất bại (sai mã mượn).");
        }
    }
}
