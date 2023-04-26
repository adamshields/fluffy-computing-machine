package com.example.adam.controller;

import com.example.adam.dto.ResourceRequest;

import com.example.adam.factory.ResourceFactoryRegistry;
import com.example.adam.model.Resource;
import com.example.adam.model.SAN;
import com.example.adam.model.Server;
import com.example.adam.repository.SANRepository;
import com.example.adam.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Schema(hidden = true)
//class ResourceWithoutType extends Resource {}

@RestController
@RequestMapping("v1/api/resource")
public class ResourceController {

    @Autowired
    private ResourceFactoryRegistry resourceFactoryRegistry;

    @Autowired
    private SANRepository sanRepository;

    @Autowired
    private ServerRepository serverRepository;

    @PostMapping("/{resourceType}")
    public ResponseEntity<?> createResource(@PathVariable String resourceType, @RequestBody ResourceRequest resource) {
        switch (resourceType.toLowerCase()) {
            case "san":
                SAN san = new SAN();
                san.setFriendlyName(resource.getFriendlyName());
                san.setDiskSpeed(resource.getDiskSpeed());
                san.setFqdn(resource.getFqdn());
                san.setActiveRecord(resource.isActiveRecord());
                return createSAN(san);
            case "server":
                Server server = new Server();
                server.setHostname(resource.getHostname());
                server.setIpAddress(resource.getIpAddress());
                server.setFqdn(resource.getFqdn());
                server.setActiveRecord(resource.isActiveRecord());
                return createServer(server);
            default:
                return ResponseEntity.badRequest().body("Invalid resource type");
        }
    }

    private ResponseEntity<com.example.adam.model.SAN> createSAN(SAN san) {
        Resource resource = resourceFactoryRegistry.getFactory("SANFactory").createResource();
        com.example.adam.model.SAN newSAN = (com.example.adam.model.SAN) resource;
        newSAN.setActiveRecord(san.isActiveRecord());
        newSAN.setFriendlyName(san.getFriendlyName());
        newSAN.setDiskSpeed(san.getDiskSpeed());
        newSAN.setFqdn(san.getFqdn());
        sanRepository.save(newSAN);
        return new ResponseEntity<>(newSAN, HttpStatus.CREATED);
    }

    private ResponseEntity<com.example.adam.model.Server> createServer(Server server) {
        Resource resource = resourceFactoryRegistry.getFactory("ServerFactory").createResource();
        com.example.adam.model.Server newServer = (com.example.adam.model.Server) resource;
        newServer.setActiveRecord(server.isActiveRecord());
        newServer.setHostname(server.getHostname());
        newServer.setIpAddress(server.getIpAddress());
        newServer.setFqdn(server.getFqdn());
        serverRepository.save(newServer);
        return new ResponseEntity<>(newServer, HttpStatus.CREATED);
    }



    //private ResponseEntity<SAN> createSAN(SAN san) {
    //    Resource resource = resourceFactoryRegistry.getFactory("SANFactory").createResource();
    //    SAN newSAN = (SAN) resource;
    //    newSAN.setActiveRecord(san.isActiveRecord());
    //    newSAN.setFriendlyName(san.getFriendlyName());
    //    newSAN.setDiskSpeed(san.getDiskSpeed());
    //    newSAN.setFqdn(san.getFqdn());
    //    sanRepository.save(newSAN);
    //    return new ResponseEntity<>(newSAN, HttpStatus.CREATED);
    //}
    //
    //private ResponseEntity<Server> createServer(Server server) {
    //    Resource resource = resourceFactoryRegistry.getFactory("ServerFactory").createResource();
    //    Server newServer = (Server) resource;
    //    newServer.setActiveRecord(server.isActiveRecord());
    //    newServer.setHostname(server.getHostname());
    //    newServer.setIpAddress(server.getIpAddress());
    //    newServer.setFqdn(server.getFqdn());
    //    serverRepository.save(newServer);
    //    return new ResponseEntity<>(newServer, HttpStatus.CREATED);
    //}
    //
    //@PostMapping("/{resourceType}")
    //public ResponseEntity<?> createResource(@PathVariable String resourceType, @RequestBody Resource resource) {
    //    switch (resourceType.toLowerCase()) {
    //        case "san":
    //            return createSAN((SAN) resource);
    //        case "server":
    //            return createServer((Server) resource);
    //        default:
    //            return ResponseEntity.badRequest().body("Invalid resource type");
    //    }
    //}
    //@PostMapping("/san")
    //public ResponseEntity<SAN> createSAN(@RequestBody SAN san) {
    //    Resource resource = resourceFactoryRegistry.getFactory("SANFactory").createResource();
    //    SAN newSAN = (SAN) resource;
    //    newSAN.setActiveRecord(san.isActiveRecord());
    //    newSAN.setFriendlyName(san.getFriendlyName());
    //    newSAN.setDiskSpeed(san.getDiskSpeed());
    //    newSAN.setFqdn(san.getFqdn());
    //    sanRepository.save(newSAN);
    //    return new ResponseEntity<>(newSAN, HttpStatus.CREATED);
    //}
    //
    //@PostMapping("/server")
    //public ResponseEntity<Server> createServer(@RequestBody Server server) {
    //    Resource resource = resourceFactoryRegistry.getFactory("ServerFactory").createResource();
    //    Server newServer = (Server) resource;
    //    newServer.setActiveRecord(server.isActiveRecord());
    //    newServer.setHostname(server.getHostname());
    //    newServer.setIpAddress(server.getIpAddress());
    //    newServer.setFqdn(server.getFqdn());
    //    serverRepository.save(newServer);
    //    return new ResponseEntity<>(newServer, HttpStatus.CREATED);
    //}

    @GetMapping("/{resourceType}")
    public ResponseEntity<?> getAll(@PathVariable String resourceType) {
        switch (resourceType.toLowerCase()) {
            case "san":
                return ResponseEntity.ok(sanRepository.findAll());
            case "server":
                return ResponseEntity.ok(serverRepository.findAll());
            default:
                return ResponseEntity.badRequest().body("Invalid resource type");
        }
    }


    @GetMapping("/{resourceType}/{id}")
    public ResponseEntity<?> getById(@PathVariable String resourceType, @PathVariable Long id) {
        Optional<?> resource;
        switch (resourceType.toLowerCase()) {
            case "san":
                resource = sanRepository.findById(id);
                break;
            case "server":
                resource = serverRepository.findById(id);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid resource type");
        }

        return resource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{resourceType}/{id}")
    public ResponseEntity<?> delete(@PathVariable String resourceType, @PathVariable Long id) {
        switch (resourceType.toLowerCase()) {
            case "san":
                sanRepository.deleteById(id);
                break;
            case "server":
                serverRepository.deleteById(id);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid resource type");
        }
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{resourceType}/{id}")
    public ResponseEntity<?> update(@PathVariable String resourceType, @PathVariable Long id, @RequestBody Resource updatedResource) {
        switch (resourceType.toLowerCase()) {
            case "san":
                return updateSAN(id, (com.example.adam.model.SAN) updatedResource);
            case "server":
                return updateServer(id, (com.example.adam.model.Server) updatedResource);
            //case "ltm":
            //    return updateLTM(id, (LTM) updatedResource);
            default:
                return ResponseEntity.badRequest().body("Invalid resource type");
        }
    }

    private ResponseEntity<com.example.adam.model.SAN> updateSAN(Long id, com.example.adam.model.SAN updatedSAN) {
        Optional<com.example.adam.model.SAN> existingSAN = sanRepository.findById(id);
        if (existingSAN.isPresent()) {
            com.example.adam.model.SAN san = existingSAN.get();
            // Update properties
            san.setFriendlyName(updatedSAN.getFriendlyName());
            san.setDiskSpeed(updatedSAN.getDiskSpeed());
            san.setFqdn(updatedSAN.getFqdn());
            san.setActiveRecord(updatedSAN.isActiveRecord());

            com.example.adam.model.SAN savedSAN = sanRepository.save(san);
            return ResponseEntity.ok(savedSAN);
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<com.example.adam.model.Server> updateServer(Long id, com.example.adam.model.Server updatedServer) {
        Optional<com.example.adam.model.Server> existingServer = serverRepository.findById(id);
        if (existingServer.isPresent()) {
            com.example.adam.model.Server server = existingServer.get();
            // Update properties
            server.setHostname(updatedServer.getHostname());
            server.setIpAddress(updatedServer.getIpAddress());
            server.setFqdn(updatedServer.getFqdn());
            server.setActiveRecord(updatedServer.isActiveRecord());

            com.example.adam.model.Server savedServer = serverRepository.save(server);
            return ResponseEntity.ok(savedServer);
        }
        return ResponseEntity.notFound().build();
    }

    //private ResponseEntity<LTM> updateLTM(Long id, LTM updatedLTM) {
    //    Optional<LTM> existingLTM = ltmRepository.findById(id);
    //    if (existingLTM.isPresent()) {
    //        LTM ltm = existingLTM.get();
    //        // Update properties
    //        // Assuming you have LTM-specific properties
    //        // ltm.setProperty(updatedLTM.getProperty());
    //        ltm.setActiveRecord(updatedLTM.isActiveRecord());
    //
    //        LTM savedLTM = ltmRepository.save(ltm);
    //        return ResponseEntity.ok(savedLTM);
    //    }
    //    return ResponseEntity.notFound().build();
    //}

}