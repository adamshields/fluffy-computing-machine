package com.example.adam.repository;
import com.example.adam.entity.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface DesignRepository extends JpaRepository<Design, Long> {

    List<Design> findByApprovalModelId(Long approvalModelId);

}