package com.api.ecommerce.purchase_orders.controller;

import com.api.ecommerce.purchase_orders.models.PurchaseOrder;
import com.api.ecommerce.purchase_orders.service.PurchaseOrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseOrdersController {
    
    @Autowired
    PurchaseOrdersService purchaseOrdersService;

    @PostMapping
    public PurchaseOrder generateOrder(){
        return purchaseOrdersService.generate();
    }

}
