package com.example.adam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "designs")


public class Design extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(
            name = "design_version",
            length = 300,
            columnDefinition = "TEXT"
//            nullable = false
    )
    private String designVersion;


    @Column(
            name = "design_name",
            length = 300,
            columnDefinition = "TEXT"
//            nullable = false
    )
    private String designName;

    @Column(
            name = "is_editable",
            columnDefinition = "BOOLEAN DEFAULT false",
            nullable = false
    )
    private Boolean isEditable;


     // Ties to Approvals
    @OneToOne
    @JoinColumn(name = "approval_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_design_approval"))
    @JsonManagedReference
    private Approval approval;
}