package org.example.blogsp.service;

import org.example.blogsp.entity.Blog;
import org.example.blogsp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;
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
    public Boolean deleteById(Integer id) {
        if(findById(id)!=null){
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
