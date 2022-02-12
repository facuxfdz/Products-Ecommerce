package com.api.ecommerce.cart.models;

import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.users.models.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("cart_products")
public class CartProduct {
     
     @Id
     private String id;
     private String userEmail;
     private String productId;

     private int price;
     private int amount;
}
