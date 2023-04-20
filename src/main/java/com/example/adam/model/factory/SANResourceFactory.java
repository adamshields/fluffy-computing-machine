package com.example.adam.model.factory;


import com.example.adam.model.Resource;
import com.example.adam.model.SANResource;

public class SANResourceFactory implements ResourceFactory {
    @Override
    public Resource createResource() {
        return new SANResource();
    }
}