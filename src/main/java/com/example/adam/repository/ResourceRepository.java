package com.example.adam.repository;

import com.example.adam.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository<T extends Resource> extends JpaRepository<T, Long> {
}