package com.example.adam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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