package com.example.adam.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "approvals")
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fully_approved", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean fullyApproved;

    @Column(name = "level_1_approval", length = 300, nullable = false)
    private String level1Approval;

    @Column(name = "level_2_approval", length = 300, nullable = false)
    private String level2Approval;

    @Column(name = "level_3_approval", length = 300, nullable = false)
    private String level3Approval;

    // Reverse Side for Design
    @OneToOne(mappedBy = "approval")
    @JsonBackReference(value="approval")
    private Design design;

}

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