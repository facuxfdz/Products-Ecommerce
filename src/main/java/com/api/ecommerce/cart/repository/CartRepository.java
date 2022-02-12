package com.api.ecommerce.cart.repository;

import java.util.List;

import com.api.ecommerce.cart.models.CartProduct;
import com.mongodb.DBRef;

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

    public CartProduct findByProductId(String productId){
        Query query = new Query().addCriteria(Criteria.where("productId").is(productId));
        List<CartProduct> list = mongoTemplate.find(query, CartProduct.class);
        log.debug(list);

        return mongoTemplate.find(query, CartProduct.class).size() != 0 ? mongoTemplate.find(query, CartProduct.class).get(0) : null;
    }
    
}
