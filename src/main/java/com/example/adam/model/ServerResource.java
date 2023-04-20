package com.example.adam.model;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class ServerResource extends Resource {
    private String cpu;
    private String memory;
    private String domain;

    // Getters and setters
}
