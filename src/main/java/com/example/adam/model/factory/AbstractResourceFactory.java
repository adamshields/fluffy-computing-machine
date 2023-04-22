package com.example.adam.model.factory;

import com.example.adam.model.Resource;

public abstract class AbstractResourceFactory {
    public abstract Resource createResource(String id);
}