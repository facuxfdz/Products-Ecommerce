package com.api.ecommerce.purchase_orders.models;

import com.api.ecommerce.cart.models.CartProduct;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("purchase_orders")
@Data
public class PurchaseOrder {
    @Id
    private String id;
    private int totalPrice;
    private String  status;
    private CartProduct[] products;
}
