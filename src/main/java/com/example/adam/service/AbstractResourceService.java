package com.example.adam.service;




import com.example.adam.model.Resource;
import com.example.adam.repository.ResourceRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        Optional<Resource> resource = resourceRepository.findById(id);
        if (resource.isPresent()) {
            return resource.get();
        } else {
            throw new ResourceNotFoundException("Resource not found with ID: " + id);
        }
    }

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Long id, Resource updatedResource) {
        Optional<Resource> existingResource = resourceRepository.findById(id);
        if (existingResource.isPresent()) {
            updatedResource.setId(id);
            return resourceRepository.save(updatedResource);
        } else {
            throw new ResourceNotFoundException("Resource not found with ID: " + id);
        }
    }

    public void deleteResource(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Resource not found with ID: " + id);
        }
    }
}
