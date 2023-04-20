package com.example.adam.model.factory;

import com.example.adam.model.Resource;
import com.example.adam.model.ServerResource;

public class ServerResourceFactory implements ResourceFactory {
    @Override
    public Resource createResource() {
        return new ServerResource();
    }
}