package com.example.adam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SAN extends Resource {

    public SAN() {
    }

    public SAN(String id) {
        setId(id);
    }

    @Override
    public void activeRecord() {
        // Implement the logic for activating the SAN
    }
}