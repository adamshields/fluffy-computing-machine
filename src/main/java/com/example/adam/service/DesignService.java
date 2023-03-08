package com.example.adam.service;

import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import com.example.adam.repository.ApprovalRepository;
import com.example.adam.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DesignService {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Autowired
    private DesignRepository designRepository;

    public Design getDesignById(Long designId) {
        return designRepository.findById(designId)
                .orElseThrow(() -> new EntityNotFoundException("Design not found with id: " + designId));
    }


    public Design approveDesign(Long id, int level) {
        Design design = designRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Design not found with id " + id));
        Approval approval = design.getApproval();

        if (approval == null) {
            approval = new Approval();
            design.setApproval(approval);
            approval.setDesign(design);
            approval.setLevel1Approval(""); // initialize all approval level fields to empty strings
            approval.setLevel2Approval("");
            approval.setLevel3Approval("");
        }

        switch (level) {
            case 1:
                approval.setLevel1Approval("approved");
                break;
            case 2:
                approval.setLevel2Approval("approved");
                break;
            case 3:
                approval.setLevel3Approval("approved");
                approval.setFullyApproved(true);
                break;
            default:
                throw new IllegalArgumentException("Invalid approval level " + level);
        }

        approval = approvalRepository.save(approval); // save the Approval object
        design = designRepository.save(design); // save the Design object

        return design;
    }
    public List<Design> getAllDesigns() {
        List<Design> designs = designRepository.findAll();
        for (Design design : designs) {
            Approval approval = design.getApproval();
            if (approval != null) {
                // fetch audit fields for Approval object
                approval.getCreatedDate();
                approval.getCreatedBy();
                approval.getLastModifiedDate();
                approval.getLastModifiedBy();
            }
        }
        return designs;
    }

//    public List<Design> getAllDesigns() {
//
//        return designRepository.findAll();
//    }

    public Design createDesign(Design design) {

        return designRepository.save(design);
    }

    public void updateDesign(Design design) {

        designRepository.save(design);
    }

    public void deleteDesignById(Long designId) {

        designRepository.deleteById(designId);
    }
}