package com.example.adam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "design_revisions")
public class DesignsModel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designId;

    private Integer appId;

    private String designVersion;

    private String designName;

    private String designBase;

    private Boolean isEditable;

    private Integer oldDesignId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = true, updatable = true)
    private Set<DesignApproval> designApprovals;
}
