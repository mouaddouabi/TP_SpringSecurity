package com.banksystem.services;

import com.banksystem.models.Authorities;
import com.banksystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.banksystem.models.User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<String> authorities = new ArrayList<>();
        for (Authorities a :user.getAuthorities()){
            authorities.add(a.getAuthority());
        }
        UserDetails user2 = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(String.valueOf(authorities)).build();
        return user2;
    }
}
