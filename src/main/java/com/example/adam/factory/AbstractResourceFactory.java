package com.example.adam.factory;


import com.example.adam.model.Resource;

public abstract class AbstractResourceFactory {
    public abstract Resource createResource(ResourceType type);
}