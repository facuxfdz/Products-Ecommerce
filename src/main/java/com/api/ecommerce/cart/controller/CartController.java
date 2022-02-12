package com.api.ecommerce.cart.controller;

import com.api.ecommerce.cart.models.CartProduct;
import com.api.ecommerce.cart.models.CartProductReq;
import com.api.ecommerce.cart.service.CartService;
import com.api.ecommerce.jwt.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/cart")
@Log4j2
public class CartController {
    
    @Autowired
    CartService cartService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public CartProduct addToCart(@RequestBody CartProductReq product, @RequestHeader("Authorization") String auth){
        String token = auth.substring(7);
        log.info("AUTH HEADER: {}", token); 
        String userEmail = jwtTokenUtil.getEmailFromToken(token);

        return cartService.addProduct(product,userEmail);
    }
}
