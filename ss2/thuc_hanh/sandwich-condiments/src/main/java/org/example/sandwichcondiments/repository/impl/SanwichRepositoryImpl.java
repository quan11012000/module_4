package org.example.sandwichcondiments.repository.impl;

import org.example.sandwichcondiments.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SanwichRepositoryImpl implements ISandwichRepository {
    @Override
    public List<String> showCondiments() {
        // Dữ liệu giả lập, sau này có thể lấy từ DB
        return Arrays.asList("Lettuce", "Tomato", "Mustard", "Sprouts");
    }
}
