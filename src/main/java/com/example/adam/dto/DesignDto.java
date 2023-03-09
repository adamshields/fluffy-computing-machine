package com.example.adam.dto;

import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DesignDto {
    private Integer id;
    private String designVersion;
    private String designName;
    private Boolean isEditable;
    private List<ApprovalDto> approvals;

    // constructor
    public DesignDto(Design design) {
        this.id = design.getId();
        this.designVersion = design.getDesignVersion();
        this.designName = design.getDesignName();
        this.isEditable = design.getIsEditable();

        // convert Approval objects to ApprovalDto objects
        List<ApprovalDto> approvalDtos = new ArrayList<>();
        Approval approval = design.getApproval();
        if (approval != null) {
            approvalDtos.add(new ApprovalDto(approval));
        }
        this.approvals = approvalDtos;
    }

    // getters and setters
    // ...
}
