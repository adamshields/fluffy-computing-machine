package com.example.adam.repository;


import com.example.adam.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<Server, String> {
}