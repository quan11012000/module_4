package org.example.updatemail.repository.impl;

import org.example.updatemail.entity.Email;
import org.example.updatemail.repository.IRepository;
import org.example.updatemail.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryImpl implements IRepository<Email> {
    private Email email;
    public EmailRepositoryImpl() {
        // Khởi tạo giá trị mặc định
        email = new Email();
        email.setLanguage("English");
        email.setPageSize(25);
        email.setSpamsFilter(true);
        email.setSignature("Thor\nKing, Asgard");
    }
    @Override
    public Email getDefaultSettings() {
        return email;
    }

    @Override
    public void updateSettings(Email email) {
        this.email = email;
    }
}
