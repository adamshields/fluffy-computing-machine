package com.example.adam.factory;

import com.example.adam.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ResourceFactoryRegistry is a utility class that is responsible for managing
 * and providing instances of ResourceFactory implementations in the Spring Boot application.
 * It uses Spring's dependency injection to automatically discover and register all available
 * ResourceFactory implementations.
 */

@Component
public class ResourceFactoryRegistry {
    // A map for storing instances of ResourceFactory implementations keyed by their class names.
    private final Map<String, ResourceFactory> factoryMap = new HashMap<>();


    @Autowired
    public ResourceFactoryRegistry(List<ResourceFactory> factories) {
        for (ResourceFactory factory : factories) {
            factoryMap.put(factory.getClass().getSimpleName().toUpperCase(), factory);
        }
    }


    public ResourceFactory getFactory(String resourceType) {
        return factoryMap.get(resourceType.toUpperCase());
    }
}
