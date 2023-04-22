package com.example.adam.repository;


import com.example.adam.model.GTM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GTMRepository extends JpaRepository<GTM, String> {
}
