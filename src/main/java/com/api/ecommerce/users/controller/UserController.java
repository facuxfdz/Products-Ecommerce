package com.api.ecommerce.users.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserController {
    
    @PostMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/sign-up")
    public String signUp(){
        return "Sign up";
    }
}
