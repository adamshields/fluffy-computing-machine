package com.example.adam.repository;
import com.example.adam.model.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface DesignRepository extends JpaRepository<Design, Integer> {


}