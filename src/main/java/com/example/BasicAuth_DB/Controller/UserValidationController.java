package com.example.BasicAuth_DB.Controller;

import com.example.BasicAuth_DB.Entity.AppUser;
import com.example.BasicAuth_DB.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserValidationController {

    @Autowired
    private AppUserRepository repo;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return repo.save(user);
    }
}