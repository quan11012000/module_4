package org.example.book_management.aspect;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitCounterAspect {

    private int visitCount;

    @PostConstruct
    public void init() {
        visitCount = 0;
    }

    @Before("execution(* org.example.book_management.controller..*(..))")
    public void countVisit() {
        visitCount++;
        System.out.println("[VISIT] Số lượt truy cập hệ thống hiện tại: " + visitCount);
    }
}