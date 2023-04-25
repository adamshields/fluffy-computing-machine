package com.example.adam.factory;

import com.example.adam.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResourceFactoryConfigurer {
    private final Map<String, ResourceFactory> factoryMap = new HashMap<>();

    @Autowired
    public ResourceFactoryConfigurer(List<ResourceFactory> factories) {
        for (ResourceFactory factory : factories) {
            factoryMap.put(factory.getClass().getSimpleName().toUpperCase(), factory);
        }
    }

    public ResourceFactory getFactory(String resourceType) {
        return factoryMap.get(resourceType.toUpperCase());
    }
}
