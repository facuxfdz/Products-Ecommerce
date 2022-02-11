package com.api.ecommerce.products.repository;

import java.util.List;

import com.api.ecommerce.products.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> findAll(){
        return mongoTemplate.findAll(Product.class);
    }

    public Product create(Product product) {
        return mongoTemplate.save(product);
    }
}
