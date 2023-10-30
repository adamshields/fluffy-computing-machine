package com.example.adam.service;

import com.example.adam.dto.ServerDTO;
import com.example.adam.entity.Server;
import com.example.adam.repository.ServerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional  // Make sure to import the appropriate Transactional annotation

public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Create
    public ServerDTO create(ServerDTO serverDTO) {
        Server server = modelMapper.map(serverDTO, Server.class);

        // Set the server field in each Service entity
        if (server.getServices() != null) {
            for (com.example.adam.entity.Service service : server.getServices()) {
                service.setServer(server);
            }
        }

        server = serverRepository.save(server);
        return modelMapper.map(server, ServerDTO.class);
    }

    // Read (All)
    public List<ServerDTO> findAll() {
        List<Server> servers = serverRepository.findAll();
        return servers.stream()
                .map(server -> modelMapper.map(server, ServerDTO.class))
                .collect(Collectors.toList());
    }

    // Read (One)
    public ServerDTO findById(Long id) {
        Optional<Server> optionalServer = serverRepository.findById(id);
        if (optionalServer.isPresent()) {
            return modelMapper.map(optionalServer.get(), ServerDTO.class);
        }
        return null;
    }

    // Update
    public ServerDTO update(Long id, ServerDTO serverDTO) {
        Optional<Server> optionalServer = serverRepository.findById(id);
        if (optionalServer.isPresent()) {
            Server existingServer = optionalServer.get();
            modelMapper.map(serverDTO, existingServer);
            existingServer = serverRepository.save(existingServer);
            return modelMapper.map(existingServer, ServerDTO.class);
        }
        return null;
    }

    // Delete
    public void delete(Long id) {
        serverRepository.deleteById(id);
    }
}
