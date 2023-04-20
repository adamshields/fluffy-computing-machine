package com.example.adam.model;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class SANResource extends Resource {
    private String storageCapacity;
    private String iops;

    // Getters and setters
}