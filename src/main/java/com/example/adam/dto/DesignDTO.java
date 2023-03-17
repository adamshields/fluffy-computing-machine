package com.example.adam.dto;

import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DesignDTO {
    private Long id;
    private String designVersion;
    private String designName;
    private Boolean isEditable;
    private List<ApprovalDTO> approvals;
}
