package com.api.ecommerce.products.service;

import java.util.List;

import com.api.ecommerce.products.exception.EmptyListOfProducts;
import com.api.ecommerce.products.exception.ProductNotFound;
import com.api.ecommerce.products.models.Product;
import com.api.ecommerce.products.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    
    @Autowired
    ProductsRepository productsRepository;

    public List<Product> getAllProducts(){
        List<Product> products = productsRepository.findAll();
        if(products == null || products.size() == 0){
            throw new EmptyListOfProducts();
        }
        return products;
    }

    public Product create(Product product) {
        return productsRepository.create(product);
    }

    public String deleteById(String id) {
        return productsRepository.deleteById(id);
    }

    public Product updateWithId(String id, Product product) {
        product.setId(id);
        return this.create(product);
    }

    public Product getProductById(String id) {
        Product productFound = productsRepository.findById(id);
        if(productFound == null){
            throw new ProductNotFound(id);
        }
        return productFound;
    }
}
