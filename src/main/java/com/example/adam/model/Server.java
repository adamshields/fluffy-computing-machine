package com.example.adam.model;

public class Server implements Resource {
    @Override
    public void activeRecord() {
        System.out.println("Server active record");
    }
}