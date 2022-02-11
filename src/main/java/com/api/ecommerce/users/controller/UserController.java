package com.api.ecommerce.users.controller;


import com.api.ecommerce.users.models.User;
import com.api.ecommerce.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{email}")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
}
