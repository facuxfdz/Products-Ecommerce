package com.api.ecommerce.products.controller;

import java.util.List;

import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(params = "id")
    public Product getById(@RequestParam String id){
        return productsService.getProductById(id);
    }


    @PostMapping
    public Product create(@RequestBody Product product){
        return productsService.create(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return productsService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product){
        return productsService.updateWithId(id,product);
    }

}
