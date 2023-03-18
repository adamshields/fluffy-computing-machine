package com.example.adam.model;

import com.example.adam.utils.SlugGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "foo_designs")


public class Design extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @Column(
//            name = "design_version",
//            length = 300,
//            columnDefinition = "TEXT"
//    )
//    private String designVersion;
//
//
//    @Column(
//            name = "design_name",
//            length = 300,
//            columnDefinition = "TEXT"
//    )
//    private String designName;
//
////    @Column(name = "slug", unique = true)
//
////    private String slug;
//    @Column(
//            name = "is_editable",
//            columnDefinition = "BOOLEAN DEFAULT false",
//            nullable = false
//    )
//    private Boolean isEditable;
//
//
//    // Ties to Approvals
//    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL)
//    private List<Approval> approvals;


//    @Transient
//    private SlugGenerator slugGenerator;
//
//    @PrePersist
//    @PreUpdate
//    private void generateSlug() {
//        slug = slugGenerator.generateSlug(designName);
//    }
}



//    @OneToOne
//    @JoinColumn(name = "approval_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_design_approval"))
//    @JsonManagedReference
//    private Approval approval;
