package org.example.blogsp.service;

import org.example.blogsp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IService<Blog>{
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> searchByName(String name, Pageable pageable);
    Page<Blog> findByTitleContainingAndCategory_IdType(String keyword, Integer idType, Pageable pageable);
    Page<Blog> findByCategory_IdType(Integer idType, Pageable pageable);
    Page<Blog> filter( String keyword, Integer categoryId, Pageable pageable);
}
