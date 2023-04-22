package com.example.adam.repository;

import com.example.adam.model.LTM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LTMRepository extends JpaRepository<LTM, String> {
}