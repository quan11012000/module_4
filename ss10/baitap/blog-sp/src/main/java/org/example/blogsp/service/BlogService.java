package org.example.blogsp.service;

import org.example.blogsp.entity.Blog;
import org.example.blogsp.entity.Category;
import org.example.blogsp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean add(Blog blog) {
        if(blog.getId()==null || findById(blog.getId())== null){
            blogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Integer id,Blog blog) {
        if(findById(id)!=null){
            blog.setId(id);
            blogRepository.save(blog);
            return true;
        }
        return false;
    }
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchByName(String name, Pageable pageable) {
        return blogRepository.searchByTitle(name, pageable);
    }

    @Override
    public Page<Blog> findByTitleContainingAndCategory_IdType(String keyword, Integer idType, Pageable pageable) {
        return blogRepository.findByTitleContainingAndCategory_IdType(keyword, idType, pageable);
    }

    @Override
    public Page<Blog> findByCategory_IdType(Integer idType, Pageable pageable) {
        return blogRepository.findByCategory_IdType(idType, pageable);
    }

    @Override
    public Page<Blog> filter(String keyword, Integer categoryId, Pageable pageable) {
        return blogRepository.filter(keyword, categoryId, pageable);
    }

    @Override
    public List<Blog> findByCategory_IdType(Integer idType) {
        return blogRepository.findByCategory_IdType(idType);
    }




    @Override
    public Boolean deleteById(Integer id) {
        if(findById(id)!=null){
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
