package com.example.adam.service;

import com.example.adam.model.Resource;
import com.example.adam.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource createResource(Resource resource) {
        resource.getAttributes().forEach(attribute -> attribute.setResource(resource));
        return resourceRepository.save(resource);
    }


    public List<Resource> getResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            return optionalResource.get();
        } else {
            throw new RuntimeException("Resource not found with id: " + id);
        }
    }

    public Resource updateResource(Long id, Resource updatedResource) {
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            Resource resource = optionalResource.get();
            resource.setType(updatedResource.getType());
            resource.setActiveRecord(updatedResource.getActiveRecord());

            // Update the attributes
            resource.getAttributes().clear();
            updatedResource.getAttributes().forEach(attribute -> {
                attribute.setResource(resource);
                resource.getAttributes().add(attribute);
            });

            return resourceRepository.save(resource);
        } else {
            throw new RuntimeException("Resource not found with id: " + id);
        }
    }


    public void deleteResource(Long id) {
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            resourceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Resource not found with id: " + id);
        }
    }
}
