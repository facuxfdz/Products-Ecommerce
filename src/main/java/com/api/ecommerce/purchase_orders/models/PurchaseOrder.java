package com.api.ecommerce.purchase_orders.models;

import java.util.ArrayList;
import java.util.List;

import com.api.ecommerce.cart.models.CartProduct;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("purchase_orders")
@Data
public class PurchaseOrder {
    @Id
    private String id;
    private int totalPrice = 0;
    private String  status;
    private List<CartProduct> products = new ArrayList<>();
}
