package org.example.blogsp.service;

import org.example.blogsp.dto.UserInfoUserDetail;
import org.example.blogsp.entity.AppUser;
import org.example.blogsp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
        if(appUser == null) {
            throw new UsernameNotFoundException("User not found!");
        }
//        Lấy tất cả role của AppUser
        UserInfoUserDetail infoUserDetails = new UserInfoUserDetail(appUser);
        return infoUserDetails;
    }
}