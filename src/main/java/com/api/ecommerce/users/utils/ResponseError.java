package com.api.ecommerce.users.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ResponseError {

    private static final String APPLICATION_JSON_VALUE = "application/json";

    private static void handleError(HttpServletResponse response, String errormsg, String exceptionDetail, HttpStatus status){
        response.setHeader("error", exceptionDetail);
        response.setStatus(status.value());
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("error_message", exceptionDetail);
        response.setContentType(APPLICATION_JSON_VALUE);
        try{
            new ObjectMapper().writeValue(response.getOutputStream(), errorMap);       
        }catch(Exception e){
            log.error("Exception writting value in output stream: {}", e.getMessage());
        }        
    } 

    public static void setResponseError(HttpServletResponse response, String errormsg, Exception exception, HttpStatus status){
        handleError(response, errormsg, exception.getMessage(), status);
    }

    public static void setResponseError(HttpServletResponse response, String errormsg, HttpStatus status){
        handleError(response, errormsg, errormsg, status);
    }
}
