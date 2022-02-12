package com.api.ecommerce.cart.models;

import lombok.Data;

@Data
public class CartProductReq {
    private String id;
    private int amount;    
}
