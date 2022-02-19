package com.api.ecommerce.products.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFound ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("error_message", "Product with given id was not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyListOfProducts.class)
    public ResponseEntity<Object> handleEmptyListOfProductsException(EmptyListOfProducts ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("error_message", "No products were uploaded yet");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
