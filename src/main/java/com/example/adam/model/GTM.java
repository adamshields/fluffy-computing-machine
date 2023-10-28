package com.example.adam.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GTM extends Resource {

    public GTM() {
    }

    public GTM(String id) {
        setId(id);
    }

    @Override
    public void activeRecord() {
        // Implement the logic for activating the GTM
    }
}