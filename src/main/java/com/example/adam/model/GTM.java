package com.example.adam.model;


import javax.persistence.Entity;
import javax.persistence.Id;

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