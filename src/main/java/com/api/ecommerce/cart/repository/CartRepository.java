package com.api.ecommerce.cart.repository;


import java.util.List;

import com.api.ecommerce.cart.models.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class CartRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public CartProduct add(CartProduct product) {
        return mongoTemplate.save(product);
    }

    public CartProduct findByProductIdAndUserEmail(String productId, String userEmail){
        Query query = new Query().addCriteria(Criteria.where("productId").is(productId).and("userEmail").is(userEmail));
        
        return mongoTemplate.find(query, CartProduct.class).size() != 0 ? mongoTemplate.find(query, CartProduct.class).get(0) : null;
    }

    public List<CartProduct> findByUserEmail(String userEmail) {
        Query query = new Query().addCriteria(Criteria.where("userEmail").is(userEmail));

        return mongoTemplate.find(query, CartProduct.class);
    }

    public boolean emptyCart(String userEmail){
        Query query = new Query().addCriteria(Criteria.where("userEmail").is(userEmail));
        try{
            mongoTemplate.findAllAndRemove(query, CartProduct.class);
            return true;
        }catch(Exception e){
            log.error("An error has ocurred: {}",e.getMessage());
            return false;
        }

    }
}
