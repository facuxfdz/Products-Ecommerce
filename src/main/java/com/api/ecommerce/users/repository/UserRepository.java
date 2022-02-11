package com.api.ecommerce.users.repository;



import java.util.List;

import com.api.ecommerce.users.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired MongoTemplate mongoTemplate;    

    public User findByEmail(String email){
        Query query = new Query().addCriteria(Criteria.where("email").is(email)).limit(1);
        return mongoTemplate.find(query, User.class).get(0);
    }

    public User create(User user){
        return mongoTemplate.save(user);
    }
}
