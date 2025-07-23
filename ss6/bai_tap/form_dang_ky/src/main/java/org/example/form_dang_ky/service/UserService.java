package org.example.form_dang_ky.service;

import org.example.form_dang_ky.entity.User;
import org.example.form_dang_ky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<User> searchByName(String name, Pageable pageable) {
        return userRepository.searchByName(name,pageable);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean add(User user) {
        if(user.getId()==null || findById(user.getId())== null){
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(Integer id, User user) {
        if(findById(id)!=null){
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(findById(id)!=null){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
