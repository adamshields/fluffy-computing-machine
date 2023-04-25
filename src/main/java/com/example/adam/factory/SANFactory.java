package com.example.adam.factory;

import com.example.adam.model.Resource;
import com.example.adam.model.SAN;
import org.springframework.stereotype.Component;

@Component
public class SANFactory implements ResourceFactory {
    public Resource createResource() {
        return new SAN();
    }
}