package org.example.form_dang_ky.repository;

import org.example.form_dang_ky.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username LIKE CONCAT('%', :username, '%')")
    Page<User> searchByName(@Param("username") String username, Pageable pageable);
}
