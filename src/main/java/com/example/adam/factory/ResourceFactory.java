package com.example.adam.factory;

import com.example.adam.model.*;

public class ResourceFactory extends AbstractResourceFactory {
    @Override
    public Resource createResource(ResourceType type) {
        switch (type) {
            case SERVER:
                return new Server();
            case SAN:
                return new SAN();
            case LTM:
                return new LTM();
            case GTM:
                return new GTM();
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }
    }
}