package com.example.adam.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "old_approvals")
public class Approval {
//public class Approval extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    private String approvalLevel;
//
//    private String approver;
//
//    private Date approvedDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "design_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_design_approvals"))
//    private Design design;

}
//    @Column(name = "fully_approved", columnDefinition = "BOOLEAN DEFAULT false")
//    private Boolean fullyApproved;
//    @Column(name = "approval_level", length = 300, nullable = false)
//    private String approval_level;
//
//    // Reverse Side for Design
//    @OneToOne(mappedBy = "approval")
//    @JsonBackReference(value="approval")
//    private Design design;

//    public void approve(User user, int level) {
//        switch (level) {
//            case 1:
//                setLevel1Approval("Approved at level 1");
//                setLevel1Approval(user.getEmployeeId());
//                break;
//            case 2:
//                setLevel2Approval("Approved at level 2");
//                setLevel2Approval(user.getEmployeeId());
//                break;
//            case 3:
//                setLevel3Approval("Approved at level 3");
//                setLevel3Approval(user.getEmployeeId());
//                setFullyApproved(true);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid approval level: " + level);
//        }
//    }