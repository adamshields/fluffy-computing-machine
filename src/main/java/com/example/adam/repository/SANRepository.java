package com.example.adam.repository;


import com.example.adam.model.SAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SANRepository extends JpaRepository<SAN, String> {
}