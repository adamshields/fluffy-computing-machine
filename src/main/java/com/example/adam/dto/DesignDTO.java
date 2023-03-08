package com.example.adam.dto;

import com.example.adam.model.Design;
import lombok.Data;

@Data
public class DesignDTO {

    private Long id;
    private String designVersion;
    private String designName;
    private Boolean isEditable;

    public DesignDTO(Design design) {
        this.id = design.getId();
        this.designVersion = design.getDesignVersion();
        this.designName = design.getDesignName();
        this.isEditable = design.getIsEditable();
    }
}
