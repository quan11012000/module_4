package org.example.productmanagementthymeleaf.globalExceptionHandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "errors/500";
//    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404() {
        return "errors/404";
    }
}
