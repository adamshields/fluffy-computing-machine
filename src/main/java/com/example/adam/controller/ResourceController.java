package com.example.adam.controller;


import com.example.adam.model.Resource;
import com.example.adam.service.AbstractResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private AbstractResourceService resourceService;

    @GetMapping
    @Operation(summary = "Get all resources", description = "This API retrieves a list of all available resources.")
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific resource by ID", description = "This API retrieves a specific resource by its ID.")
    public Resource getResourceById(
            @Parameter(description = "ID of the resource you want to retrieve", required = true) @PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new resource", description = "This API creates a new resource and returns the created resource.")
    public Resource createResource(
            @Parameter(description = "Resource object you want to create", required = true) @RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing resource", description = "This API updates an existing resource by its ID and returns the updated resource.")
    public Resource updateResource(
            @Parameter(description = "ID of the resource you want to update", required = true) @PathVariable Long id,
            @Parameter(description = "Updated resource object", required = true) @RequestBody Resource resource) {
        return resourceService.updateResource(id, resource);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a resource by ID", description = "This API deletes a specific resource by its ID.")
    public void deleteResource(
            @Parameter(description = "ID of the resource you want to delete", required = true) @PathVariable Long id) {
        resourceService.deleteResource(id);
    }
}
