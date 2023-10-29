package com.example.adam.service;

import com.example.adam.entity.Server;
import com.example.adam.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    // Create
    public Server create(Server server) {
        return serverRepository.save(server);
    }

    // Read (All)
    public List<Server> findAll() {
        return serverRepository.findAll();
    }

    // Read (One)
    public Server findById(Long id) {
        Optional<Server> optionalServer = serverRepository.findById(id);
        return optionalServer.orElse(null);
    }

    // Update
    public Server update(Long id, Server server) {
        Optional<Server> optionalServer = serverRepository.findById(id);
        if (optionalServer.isPresent()) {
            Server existingServer = optionalServer.get();
            existingServer.setHostname(server.getHostname());
            existingServer.setIpAddress(server.getIpAddress());
            existingServer.setFqdn(server.getFqdn());
            return serverRepository.save(existingServer);
        }
        return null;
    }

    // Delete
    public void delete(Long id) {
        serverRepository.deleteById(id);
    }
}
