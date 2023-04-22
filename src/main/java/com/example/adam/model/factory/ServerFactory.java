package com.example.adam.model.factory;

import com.example.adam.model.Resource;
import com.example.adam.model.Server;

public class ServerFactory extends AbstractResourceFactory {

    private String hostname;
    private String ip;

    public ServerFactory(String hostname, String ip) {
        this.hostname = hostname;
        this.ip = ip;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public Resource createResource(String id) {
        return new Server(id, hostname, ip);
    }
}