package com.example.adam.factory;

import com.example.adam.model.Resource;
import com.example.adam.model.Server;
import org.springframework.stereotype.Component;

@Component
public class ServerFactory implements ResourceFactory {
    public Resource createResource() {
        return new Server();
    }
}
