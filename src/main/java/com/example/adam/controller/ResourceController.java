package com.example.adam.controller;

import com.example.adam.factory.ResourceFactoryRegistry;
import com.example.adam.model.Resource;
import com.example.adam.model.SAN;
import com.example.adam.model.Server;
import com.example.adam.repository.SANRepository;
import com.example.adam.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/resource")
public class ResourceController {

    @Autowired
    private ResourceFactoryRegistry resourceFactoryRegistry;

    @Autowired
    private SANRepository sanRepository;

    @Autowired
    private ServerRepository serverRepository;

    @PostMapping("/san")
    public ResponseEntity<SAN> createSAN(@RequestBody SAN san) {
        Resource resource = resourceFactoryRegistry.getFactory("SANFactory").createResource();
        SAN newSAN = (SAN) resource;
        newSAN.setActiveRecord(san.isActiveRecord());
        newSAN.setFriendlyName(san.getFriendlyName());
        newSAN.setDiskSpeed(san.getDiskSpeed());
        newSAN.setFqdn(san.getFqdn());
        sanRepository.save(newSAN);
        return new ResponseEntity<>(newSAN, HttpStatus.CREATED);
    }

    @PostMapping("/server")
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Resource resource = resourceFactoryRegistry.getFactory("ServerFactory").createResource();
        Server newServer = (Server) resource;
        newServer.setActiveRecord(server.isActiveRecord());
        newServer.setHostname(server.getHostname());
        newServer.setIpAddress(server.getIpAddress());
        newServer.setFqdn(server.getFqdn());
        serverRepository.save(newServer);
        return new ResponseEntity<>(newServer, HttpStatus.CREATED);
    }
}
