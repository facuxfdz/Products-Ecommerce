package com.api.ecommerce.products.service;

import java.util.List;

import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    
    @Autowired
    ProductsRepository productsRepository;

    public List<Product> getAllProducts(){
        return productsRepository.findAll();
    }

    public Product create(Product product) {
        return productsRepository.create(product);
    }
}
