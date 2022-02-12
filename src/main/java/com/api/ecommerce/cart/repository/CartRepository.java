package com.api.ecommerce.cart.repository;

import com.api.ecommerce.cart.models.CartProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public CartProduct add(CartProduct product) {
        return mongoTemplate.save(product);
    }
    
}
