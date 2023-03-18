package com.example.adam.service;

import com.example.adam.dto.ApprovalDTO;
import com.example.adam.dto.DesignDTO;
import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import com.example.adam.repository.ApprovalRepository;
import com.example.adam.repository.DesignRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
//import org.springframework.security.core.Authentication;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesignService {

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private ModelMapper modelMapper;
}

//    public DesignDTO getDesignById(Long designId) {
//        Design design = designRepository.findById(designId)
//                .orElseThrow(() -> new NotFoundException("Design not found with id " + designId));
//        List<ApprovalDTO> approvalDTOs = design.getApprovals().stream()
//                .map(approval -> modelMapper.map(approval, ApprovalDTO.class))
//                .collect(Collectors.toList());
//        DesignDTO designDTO = modelMapper.map(design, DesignDTO.class);
//        designDTO.setApprovals(approvalDTOs);
//        return designDTO;
//    }

//    public DesignDTO addApproval(Long designId, ApprovalDTO approvalDTO) {
//        Design design = designRepository.findById(designId)
//                .orElseThrow(() -> new NotFoundException("Design not found with id " + designId));
//        Approval approval = modelMapper.map(approvalDTO, Approval.class);
//        approval.setDesign(design);
//        design.getApprovals().add(approval);
//        designRepository.save(design);
//        return modelMapper.map(design, DesignDTO.class);
//    }

//    public List<Design> getAllDesigns() {
//        return designRepository.findAll();
//    }

//    public List<DesignDTO> getAllDesigns() {
//        List<Design> designs = designRepository.findAll();
//        return designs.stream()
//                .map(design -> modelMapper.map(design, DesignDTO.class))
//                .collect(Collectors.toList());
//    }
//}


//    public Design approveDesign(Integer id, int level) {
//
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String lastModifiedBy = authentication.getName();
//        String lastModifiedBy = "TestName";
//
//        Design design = designRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Design not found with id " + id));
//        Approval approval = design.getApproval();
//
//        if (approval == null) {
//            approval = new Approval();
//            design.setApproval(approval);
//            approval.setDesign(design);
//            approval.setLevel1Approval(""); // initialize all approval level fields to empty strings
//            approval.setLevel2Approval("");
//            approval.setLevel3Approval("");
//        }
//
//        switch (level) {
//            case 1:
//                approval.setLevel1Approval("approved-" + lastModifiedBy);
//                break;
//            case 2:
//                approval.setLevel2Approval("approved-" + lastModifiedBy);
//                break;
//            case 3:
//                approval.setLevel3Approval("approved-" + lastModifiedBy);
//                approval.setFullyApproved(true);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid approval level " + level);
//        }
//
//        approval = approvalRepository.save(approval); // save the Approval object
//        design = designRepository.save(design); // save the Design object
//
//        return design;
//    }
//    public List<Design> getAllDesigns() {
//        List<Design> designs = designRepository.findAll();
////        for (Design design : designs) {
////            Approval approval = design.getApproval();
////            if (approval != null) {
////                // fetch audit fields for Approval object
////                approval.getCreatedDate();
////                approval.getCreatedBy();
////                approval.getLastModifiedDate();
////                approval.getLastModifiedBy();
////            }
////        }
//        return designs;
//    }

//    public List<Design> getAllDesigns() {
//
//        return designRepository.findAll();
//    }

//    public Design createDesign(Design design) {
//
//        return designRepository.save(design);
//    }
//
//    public void updateDesign(Design design) {
//
//        designRepository.save(design);
//    }
//
//    public void deleteDesignById(Long designId) {
//
//        designRepository.deleteById(designId);
//    }
//}