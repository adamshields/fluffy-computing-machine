package com.example.adam.service;

import java.time.LocalDateTime;

public class AuditService {
    public void audit(String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate) {
        System.out.println("Created by: " + createdBy);
        System.out.println("Created date: " + createdDate);
        System.out.println("Last modified by: " + lastModifiedBy);
        System.out.println("Last modified date: " + lastModifiedDate);
    }
}
