package com.api.ecommerce.products.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductNotFound extends RuntimeException {
 
    public ProductNotFound(String id){
        super(notFoundMsg(id));
        log.warn(notFoundMsg(id));
    }

    private static String notFoundMsg(String id){
        return String.format("Product with id %s not found", id);
    }
}
