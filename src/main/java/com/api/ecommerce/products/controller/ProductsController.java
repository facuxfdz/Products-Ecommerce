package com.api.ecommerce.products.controller;

import java.util.List;

import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    ProductsService productsService;

    @GetMapping
    public List<Product> getAll(){
        return productsService.getAllProducts();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productsService.create(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return productsService.deleteById(id);
    }

}
