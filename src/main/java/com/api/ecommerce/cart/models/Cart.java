package com.api.ecommerce.cart.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("cart_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String id;
    private CartProduct[] products;
}
