package com.example.adam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LTM extends Resource {

    public LTM() {
    }

    public LTM(String id) {
        setId(id);
    }

    @Override
    public void activeRecord() {
        // Implement the logic for activating the LTM
    }
}