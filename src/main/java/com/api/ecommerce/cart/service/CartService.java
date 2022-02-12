package com.api.ecommerce.cart.service;

import javax.naming.NameNotFoundException;

import com.api.ecommerce.cart.models.CartProduct;
import com.api.ecommerce.cart.models.CartProductReq;
import com.api.ecommerce.cart.repository.CartRepository;
import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.repository.ProductsRepository;
import com.api.ecommerce.users.models.User;
import com.api.ecommerce.users.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    public CartProduct addProduct(CartProductReq product) {
        Product existentProduct = productsRepository.findById(product.getId());
        User user = userRepository.findByEmail("facu@facu.com");

        if(existentProduct != null){
            CartProduct newProduct = new CartProduct(user,existentProduct,existentProduct.getPrice(),product.getAmount());
            return cartRepository.add(newProduct);
        }    

        return null;
    }
}
