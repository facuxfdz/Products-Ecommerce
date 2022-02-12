package com.api.ecommerce.cart.service;

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
            CartProduct existenCartProduct = cartRepository.findByProductId(existentProduct.getId());
            
            if(existenCartProduct == null){
                // = new CartProduct(user.getEmail(),existentProduct.getId(),existentProduct.getPrice(),product.getAmount())
                CartProduct newProduct = new CartProduct();
                newProduct.setUserEmail(user.getEmail());
                newProduct.setProductId(existentProduct.getId());
                newProduct.setPrice(existentProduct.getPrice());
                newProduct.setAmount(product.getAmount());
                return cartRepository.add(newProduct);
            }else{
                existenCartProduct.setAmount(existenCartProduct.getAmount() + product.getAmount());
                return this.updateCartProduct(existenCartProduct, existenCartProduct.getId());
            }
        }    

        return null;
    }

    public CartProduct updateCartProduct(CartProduct cartProduct, String id){
        cartProduct.setId(id);
        return cartRepository.add(cartProduct);
    }
}
