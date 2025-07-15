package org.example.sandwichcondiments.service.impl;

import org.example.sandwichcondiments.repository.ISandwichRepository;
import org.example.sandwichcondiments.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichServiceImpl implements ISandwichService {
    @Autowired
    private ISandwichRepository sandwichRepository;

    @Override
    public List<String> getAvailableCondiments() {
        return sandwichRepository.showCondiments();
    }
}
