package com.example.adam.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomAPIResponse {

    public static ResponseEntity<Object> generate200Response(HttpStatus status, String message, int count, Object data) {

        LocalDateTime timeStamp = LocalDateTime.now();
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("timeStamp", timeStamp);
        response.put("status", status);
        response.put("statusCode", status.value());
        response.put("message", message);
        response.put("items", count);
        response.put("data", data);
        return new ResponseEntity(response, status);
    }

    public static ResponseEntity<Object> generate204Response(String message, String errorReason) {

        LocalDateTime timeStamp = LocalDateTime.now();
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("timeStamp", timeStamp);
        response.put("status", HttpStatus.NO_CONTENT);
        response.put("statusCode", HttpStatus.NO_CONTENT.value());
        response.put("message", message);
        response.put("errorReason", errorReason);
        response.put("items", 0);
        response.put("data", "[]");

        return new ResponseEntity(response, HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<Object> generate405Response(String message, String errorReason) {

        LocalDateTime timeStamp = LocalDateTime.now();
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("timeStamp", timeStamp);
        response.put("status", HttpStatus.METHOD_NOT_ALLOWED);
        response.put("statusCode", HttpStatus.METHOD_NOT_ALLOWED.value());
        response.put("message", message);
        response.put("errorReason", errorReason);

        return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
    }


    public static ResponseEntity<Object> generate500Response(String message, String errorReason) {

        LocalDateTime timestamp = LocalDateTime.now();
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("timeStamp", timestamp);
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("message", message);
        response.put("errorReason", errorReason);

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

