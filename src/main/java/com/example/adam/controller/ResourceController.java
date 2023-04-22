package com.example.adam.controller;


import com.example.adam.model.Resource;
import com.example.adam.model.ResourceType;

import com.example.adam.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/{resourceType}")
    public Resource createResource(@PathVariable ResourceType resourceType, @RequestBody Map<String, String> requestBody) {
        String id = requestBody.get("id");
        String hostname = requestBody.get("hostname");
        String ip = requestBody.get("ip");
        return resourceService.createResource(resourceType, id, hostname, ip);
    }

    @GetMapping("/{resourceType}/{id}")
    public Resource getResourceById(@PathVariable ResourceType resourceType, @PathVariable String id) {
        return resourceService.getResourceById(resourceType, id);
    }

    @GetMapping("/{resourceType}")
    public List<Resource> getAllResources(@PathVariable ResourceType resourceType) {
        return resourceService.getAllResources(resourceType);
    }

    @PutMapping("/{resourceType}/{id}")
    public Resource updateResource(@PathVariable ResourceType resourceType, @PathVariable String id, @RequestBody Resource updatedResource) {
        return resourceService.updateResource(resourceType, id, updatedResource);
    }

    @DeleteMapping("/{resourceType}/{id}")
    public void deleteResource(@PathVariable ResourceType resourceType, @PathVariable String id) {
        resourceService.deleteResource(resourceType, id);
    }
}
