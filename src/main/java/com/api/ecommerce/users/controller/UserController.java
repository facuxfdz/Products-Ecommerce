package com.api.ecommerce.users.controller;


import com.api.ecommerce.users.models.User;
import com.api.ecommerce.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/sign-up")
    public User login(@RequestBody User user){
        return userService.create(user);
    }
    

}
