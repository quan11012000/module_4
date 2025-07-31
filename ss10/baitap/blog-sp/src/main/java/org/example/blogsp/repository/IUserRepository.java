package org.example.blogsp.repository;

import org.example.blogsp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}