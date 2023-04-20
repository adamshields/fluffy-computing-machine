package com.example.adam.service;

import com.example.adam.model.SANResource;
import com.example.adam.model.ServerResource;
import com.example.adam.repository.SANResourceRepository;
import com.example.adam.repository.ServerResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    private final ServerResourceRepository serverResourceRepository;
    private final SANResourceRepository sanResourceRepository;

    @Autowired
    public ResourceService(ServerResourceRepository serverResourceRepository,
                           SANResourceRepository sanResourceRepository) {
        this.serverResourceRepository = serverResourceRepository;
        this.sanResourceRepository = sanResourceRepository;
    }

    public ServerResource saveServerResource(ServerResource serverResource) {
        return serverResourceRepository.save(serverResource);
    }

    public SANResource saveSANResource(SANResource sanResource) {
        return sanResourceRepository.save(sanResource);
    }
}
