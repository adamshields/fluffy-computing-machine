package com.example.adam.model;

import com.example.adam.utils.AuditModel;
import lombok.Data;

import javax.persistence.*;
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

    private String designStatus = "Future";

    private String designBase;

    private Boolean isEditable;

    private Integer oldDesignId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "design_id",
            referencedColumnName = "designId",
            insertable = true,
            updatable = true,
            foreignKey = @ForeignKey(name = "fk_design_approvals_design_id")
    )
    private Set<Approval> approvals;
}
