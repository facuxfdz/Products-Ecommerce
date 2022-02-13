package com.api.ecommerce.cart.controller;

import java.util.List;

import com.api.ecommerce.cart.models.CartProduct;
import com.api.ecommerce.cart.models.CartProductReq;
import com.api.ecommerce.cart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    CartService cartService;


    @PostMapping
    public CartProduct addToCart(@RequestBody CartProductReq product){
        return cartService.addProduct(product);
    }

    @GetMapping
    public List<CartProduct> getProducts(){
        return cartService.getCartProducts();
    }


}
