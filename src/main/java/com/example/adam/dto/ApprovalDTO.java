package com.example.adam.dto;

import com.example.adam.model.Approval;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class ApprovalDTO {

    private Long id;
    private Boolean fullyApproved;
    private String level1Approval;
    private String level2Approval;
    private String level3Approval;


    private DesignDTO design;

    public ApprovalDTO(Approval approval) {
        this.id = approval.getId();
        this.fullyApproved = approval.getFullyApproved();
        this.level1Approval = approval.getLevel1Approval();
        this.level2Approval = approval.getLevel2Approval();
        this.level3Approval = approval.getLevel3Approval();

        if (approval.getDesign() != null) {
            this.design = new DesignDTO(approval.getDesign());
        }
    }

    // getters and setters
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
