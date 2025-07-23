package org.example.form_dang_ky.service;

import org.example.form_dang_ky.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IService<User>{
    Page<User> searchByName(String name, Pageable pageable);
}
