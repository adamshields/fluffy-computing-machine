package com.example.adam.model.factory;
import com.example.adam.model.SAN;
import com.example.adam.model.Resource;

public class SANFactory extends AbstractResourceFactory {
    @Override
    public Resource createResource(String id) {
        return new SAN(id);
    }
}