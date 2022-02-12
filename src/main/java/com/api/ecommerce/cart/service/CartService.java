package com.api.ecommerce.cart.service;

import com.api.ecommerce.cart.models.CartProduct;
import com.api.ecommerce.cart.models.CartProductReq;
import com.api.ecommerce.cart.repository.CartRepository;
import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductsRepository productsRepository;

    public CartProduct addProduct(CartProductReq product){
        Product existentProduct = productsRepository.findById(product.getId());
        if(existentProduct != null){
            CartProduct newProduct = new CartProduct(existentProduct.getPrice(),product.getAmount());
            return cartRepository.add(newProduct);
        }    

        return null;
    }
}
