package com.example.adam.tbd;

import com.example.adam.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignApprovalRepository extends JpaRepository<Approval, Integer> {
}
