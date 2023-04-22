package com.example.adam.service;

import com.example.adam.model.*;
import com.example.adam.model.factory.*;
import com.example.adam.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private SANRepository sanRepository;

    @Autowired
    private LTMRepository ltmRepository;

    @Autowired
    private GTMRepository gtmRepository;

    private AbstractResourceFactory getResourceFactory(ResourceType resourceType, String hostname, String ip) {
        AbstractResourceFactory factory;

        switch (resourceType) {
            case SERVER:
                factory = new ServerFactory(hostname, ip);
                break;
            case SAN:
                factory = new SANFactory();
                break;
            case LTM:
                factory = new LTMFactory();
                break;
            case GTM:
                factory = new GTMFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }

        return factory;
    }

    public Resource createResource(ResourceType resourceType, String id, String hostname, String ip) {
        Resource resource = getResourceFactory(resourceType, hostname, ip).createResource(id);

        switch (resourceType) {
            case SERVER:
                serverRepository.save((Server) resource);
                break;
            case SAN:
                sanRepository.save((SAN) resource);
                break;
            case LTM:
                ltmRepository.save((LTM) resource);
                break;
            case GTM:
                gtmRepository.save((GTM) resource);
                break;
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }

        return resource;
    }

    public Resource getResourceById(ResourceType resourceType, String id) {
        Optional<? extends Resource> optionalResource;

        switch (resourceType) {
            case SERVER:
                optionalResource = serverRepository.findById(id);
                break;
            case SAN:
                optionalResource = sanRepository.findById(id);
                break;
            case LTM:
                optionalResource = ltmRepository.findById(id);
                break;
            case GTM:
                optionalResource = gtmRepository.findById(id);
                break;
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }

        return optionalResource.map(resource -> (Resource) resource).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }


    public List<Resource> getAllResources(ResourceType resourceType) {
        switch (resourceType) {
            case SERVER:
                return (List<Resource>) (List<?>) serverRepository.findAll();
            case SAN:
                return (List<Resource>) (List<?>) sanRepository.findAll();
            case LTM:
                return (List<Resource>) (List<?>) ltmRepository.findAll();
            case GTM:
                return (List<Resource>) (List<?>) gtmRepository.findAll();
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }
    }

    public Resource updateResource(ResourceType resourceType, String id, Resource updatedResource) {
        Resource existingResource = getResourceById(resourceType, id);
        BeanUtils.copyProperties(updatedResource, existingResource, "id");

        switch (resourceType) {
            case SERVER:
                return serverRepository.save((Server) existingResource);
            case SAN:
                return sanRepository.save((SAN) existingResource);
            case LTM:
                return ltmRepository.save((LTM) existingResource);
            case GTM:
                return gtmRepository.save((GTM) existingResource);
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }
    }

    public void deleteResource(ResourceType resourceType, String id) {
        Resource resource = getResourceById(resourceType, id);

        switch (resourceType) {
            case SERVER:
                serverRepository.delete((Server) resource);
                break;
            case SAN:
                sanRepository.delete((SAN) resource);
                break;
            case LTM:
                ltmRepository.delete((LTM) resource);
                break;
            case GTM:
                gtmRepository.delete((GTM) resource);
                break;
            default:
                throw new IllegalArgumentException("Invalid resource type");
        }
    }

}