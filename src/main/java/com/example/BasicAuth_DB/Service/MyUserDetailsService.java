package com.example.BasicAuth_DB.Service;

import com.example.BasicAuth_DB.Entity.AppUser;
import com.example.BasicAuth_DB.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService {

    @Autowired
    private AppUserRepository repo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}