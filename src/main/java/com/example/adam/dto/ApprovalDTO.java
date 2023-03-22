package com.example.adam.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApprovalDTO {
    private Integer id;
    private String approvalLevel;
    private String approver;
    private Date approvedDate;
}

//public class ApprovalDTO {
//
//    private Long id;
//    private Boolean fullyApproved;
//    private String level1Approval;
//    private String level2Approval;
//    private String level3Approval;
//
//    private DesignDTO design; // whole object
//
////    private Long designId; // new field
////    private Boolean isEditable; // new field
//
//
////    private Long id;
////    private Boolean fullyApproved;
////    private String level1Approval;
////    private String level2Approval;
////    private String level3Approval;
////    private Long designId;
////
////    public ApprovalDTO(Long id, Boolean fullyApproved, String level1Approval, String level2Approval, String level3Approval, Long designId) {
////        this.id = id;
////        this.fullyApproved = fullyApproved;
////        this.level1Approval = level1Approval;
////        this.level2Approval = level2Approval;
////        this.level3Approval = level3Approval;
////        this.designId = designId;
////    }
//
//
//}
