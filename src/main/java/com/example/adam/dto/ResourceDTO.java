package com.example.adam.dto;


public class ResourceDTO {
    private String type;
    private String specificAttribute;

    public ResourceDTO() {
    }

    public ResourceDTO(String type, String specificAttribute) {
        this.type = type;
        this.specificAttribute = specificAttribute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecificAttribute() {
        return specificAttribute;
    }

    public void setSpecificAttribute(String specificAttribute) {
        this.specificAttribute = specificAttribute;
    }
}
