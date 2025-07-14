package org.example.englishtovietnam.service.impl;

import org.example.englishtovietnam.repo.IRepository;
import org.example.englishtovietnam.repo.impl.TranslateRepo;
import org.example.englishtovietnam.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements IService {
    @Autowired
    private IRepository repository ;
    @Override
    public String find(String word) {
        return repository.find(word);
    }
}
