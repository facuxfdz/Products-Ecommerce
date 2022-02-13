package com.api.ecommerce.purchase_orders.repository;

import com.api.ecommerce.purchase_orders.models.PurchaseOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrdersRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public PurchaseOrder create(PurchaseOrder order) {
        return mongoTemplate.save(order);
    }
    
}
