package com.anz.account.controller;

import com.anz.account.dao.UserRepository;
import com.anz.account.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired UserRepository userRepository;

    @GetMapping("/users/{userId}")
    public User get(@PathVariable Long userId) {
        return userRepository.findById(userId).get();
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return userRepository.findAll();
    }

}
