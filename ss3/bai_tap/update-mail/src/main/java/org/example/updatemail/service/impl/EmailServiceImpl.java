package org.example.updatemail.service.impl;

import org.example.updatemail.entity.Email;
import org.example.updatemail.repository.impl.EmailRepositoryImpl;
import org.example.updatemail.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailServiceImpl implements IService<Email> {
    @Autowired
    private EmailRepositoryImpl emailRepository;

    private final List<String> languages = List.of("English", "Vietnamese", "Japanese", "Chinese");
    private final List<Integer> pageSizes = List.of(5, 10, 15, 25, 50, 100);

    @Override
    public Email getSettings() {
        return emailRepository.getDefaultSettings();
    }

    @Override
    public void update(Email emailSettings) {
        emailRepository.updateSettings(emailSettings);
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getPageSizes() {
        return pageSizes;
    }
}
