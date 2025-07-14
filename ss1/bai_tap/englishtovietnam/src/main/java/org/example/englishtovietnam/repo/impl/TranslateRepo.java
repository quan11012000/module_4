package org.example.englishtovietnam.repo.impl;

import org.example.englishtovietnam.repo.IRepository;
import org.example.englishtovietnam.service.IService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class TranslateRepo implements IRepository {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("teacher", "giáo viên");
        dictionary.put("student", "học sinh");
        dictionary.put("school", "trường học");
        dictionary.put("pen", "bút");
    }
    public String find(String word){
        return dictionary.get(word.toLowerCase());
    }
}
