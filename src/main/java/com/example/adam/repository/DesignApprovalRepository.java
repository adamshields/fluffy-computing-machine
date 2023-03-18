package com.example.adam.repository;

import com.example.adam.model.Approval;
import com.example.adam.model.DesignApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignApprovalRepository extends JpaRepository<DesignApproval, Integer> {
}
