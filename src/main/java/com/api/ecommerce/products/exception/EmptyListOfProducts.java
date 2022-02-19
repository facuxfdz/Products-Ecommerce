package com.api.ecommerce.products.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class EmptyListOfProducts extends RuntimeException {
    
    public EmptyListOfProducts(){
        super(emptyListMsg());
        log.warn(emptyListMsg());
    }


    private static String emptyListMsg(){
        return "No products were uploaded yet";
    }
}
