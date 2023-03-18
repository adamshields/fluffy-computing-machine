package com.example.adam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "design_approvals")
public class DesignApproval {
    //public class Approval extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String approvalLevel;

    private String approver;

    private Date approvedDate;

}