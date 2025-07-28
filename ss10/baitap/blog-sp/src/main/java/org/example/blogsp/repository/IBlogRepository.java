package org.example.blogsp.repository;

import org.example.blogsp.entity.Blog;
import org.example.blogsp.entity.Category;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
        @Query("SELECT b FROM Blog b WHERE b.title LIKE CONCAT('%', :title, '%')")
        Page<Blog> searchByTitle(@Param("title") String title, Pageable pageable);
    Page<Blog> findByTitleContainingAndCategory_IdType(String keyword, Integer idType, Pageable pageable);
    Page<Blog> findByCategory_IdType(Integer idType, Pageable pageable);
    @Query ("SELECT b FROM Blog b WHERE b.title LIKE CONCAT('%', :keyword, '%') and (b.category.idType = :categoryId or 0 = :categoryId)")
    Page<Blog> filter(@Param("keyword") String keyword,@Param("categoryId") Integer categoryId, Pageable pageable);
    List<Blog> findByCategory_IdType(Integer idType);
}
