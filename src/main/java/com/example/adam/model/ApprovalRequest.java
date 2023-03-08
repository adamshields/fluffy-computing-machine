package com.example.adam.model;



public class ApprovalRequest {
    private Long designId;
    private String level1Approval;
    private String level2Approval;
    private String level3Approval;

    // getters and setters
    public Long getDesignId() {
        return designId;
    }

    public void setDesignId(Long designId) {
        this.designId = designId;
    }

    public String getLevel1Approval() {
        return level1Approval;
    }

    public void setLevel1Approval(String level1Approval) {
        this.level1Approval = level1Approval;
    }

    public String getLevel2Approval() {
        return level2Approval;
    }

    public void setLevel2Approval(String level2Approval) {
        this.level2Approval = level2Approval;
    }

    public String getLevel3Approval() {
        return level3Approval;
    }

    public void setLevel3Approval(String level3Approval) {
        this.level3Approval = level3Approval;
    }
}
