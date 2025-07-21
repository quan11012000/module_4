package org.example.blogsp.globalExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404() {
        return "errors/404";
    }
//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "errors/500";
//    }


}
