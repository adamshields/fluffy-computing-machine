package com.example.adam.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Column;


@Entity
public class Server extends Resource {

    @Column(nullable = false)
    private String hostname;

    @Column(nullable = false)
    private String ip;

    public Server() {
    }

    public Server(String id, String hostname, String ip) {
        setId(id);
        this.hostname = hostname;
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public void activeRecord() {
        // Implement the logic for activating the server
        System.out.println("Activating server with hostname: " + hostname + " and IP: " + ip);
    }
}
