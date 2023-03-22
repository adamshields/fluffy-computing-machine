package com.example.adam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
//import org.springframework.security.core.context.SecurityContextHolder;

@Data
@Entity
@Table(name = "design_approvals")
public class DesignApproval extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String approvalLevel;

    @Column(name = "approver")
    private String approver;

    @Column(name = "approved_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime approvedDate;

    // Constructor, getters, and setters

//    @PrePersist
//    public void prePersist() {
//        this.approvedDate = LocalDateTime.now();
//        String approverUserNameFaker = "adam";
//        this.approver = approverUserNameFaker;
////        this.approver = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        // You'll need to set the approver field based on the currently authenticated user
//        // You could do this in a service method that calls the save() method on the repository
//        // or use Spring Security's @AuthenticationPrincipal annotation to inject the currently
//        // authenticated user into the controller method that calls the service method.
//    }
}
