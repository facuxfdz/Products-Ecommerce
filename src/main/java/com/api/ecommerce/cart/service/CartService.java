package com.api.ecommerce.cart.service;

import com.api.ecommerce.cart.models.CartProduct;
import com.api.ecommerce.cart.models.CartProductReq;
import com.api.ecommerce.cart.repository.CartRepository;
import com.api.ecommerce.jwt.JwtTokenUtil;
import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.repository.ProductsRepository;
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

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    
    public CartProduct addProduct(CartProductReq product) {
        Product existentProduct = productsRepository.findById(product.getId());
        if(existentProduct != null){
            String userEmail = jwtTokenUtil.getEmailFromToken();
            CartProduct existenCartProduct = cartRepository.findByProductId(existentProduct.getId(),userEmail);
            
            if(existenCartProduct == null ){
                CartProduct newProduct = new CartProduct();
                newProduct.setUserEmail(userEmail);
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
