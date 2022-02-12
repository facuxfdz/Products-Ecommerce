package com.api.ecommerce.cart.models;

import com.api.ecommerce.products.models.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct extends Product{
     private int price;
     private int amount;
}
