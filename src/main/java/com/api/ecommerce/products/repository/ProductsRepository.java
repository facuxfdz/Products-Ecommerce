package com.api.ecommerce.products.repository;

import java.util.List;

import com.api.ecommerce.products.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public String deleteById(String id) {
        Query removeQuery = new Query().addCriteria(Criteria.where("id").is(id));
        Product removedProduct = mongoTemplate.findAndRemove(removeQuery, Product.class);
        return "Product with id " + removedProduct.getId() + " deleted successfully";
    }

    public Product findById(String id) {
        return mongoTemplate.findById(id, Product.class);
    }
}
