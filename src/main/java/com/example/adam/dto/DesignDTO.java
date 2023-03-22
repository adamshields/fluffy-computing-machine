package com.example.adam.dto;

import lombok.Data;

import java.util.List;

@Data
public class DesignDTO {
    private Long id;
    private String designVersion;
    private String designName;
    private Boolean isEditable;
    private List<ApprovalDTO> approvals;
}
