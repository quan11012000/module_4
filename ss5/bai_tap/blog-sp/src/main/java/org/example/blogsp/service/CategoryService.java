package org.example.blogsp.service;

import org.example.blogsp.entity.Category;
import org.example.blogsp.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean add(Category category) {
        if(category.getIdType()==null || findById(category.getIdType())== null){
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Integer id, Category category) {
        if(findById(id)!=null){
            category.setIdType(id);
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(findById(id)!=null){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
