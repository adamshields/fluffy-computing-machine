package com.example.adam.tbd;


import com.example.adam.model.Approval;
import com.example.adam.repository.DesignRepository;
import com.example.adam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApprovalService {

//    @Autowired
//    private ApprovalRepository approvalRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private DesignRepository designRepository;


//    public List<Approval> getAllApprovals(){
//
//        return approvalRepository.findAll();
//    }

//    public ApprovalDTO createApproval(ApprovalDTO approvalDTO) {
//        Approval approval = new Approval();
//        approval.setFullyApproved(false);
//        approval.setLevel1Approval(approvalDTO.getLevel1Approval());
//        approval.setLevel2Approval(approvalDTO.getLevel2Approval());
//        approval.setLevel3Approval(approvalDTO.getLevel3Approval());
//
//        Design design = designRepository.findById(approvalDTO.getDesignId())
//                .orElseThrow(() -> new EntityNotFoundException("Design not found with id " + approvalDTO.getDesignId()));
//        approval.setDesign(design);
//
//        approval = approvalRepository.save(approval);
//
//        ApprovalDTO dto = new ApprovalDTO();
//        dto.setId(approval.getId());
//        dto.setFullyApproved(approval.getFullyApproved());
//        dto.setLevel1Approval(approval.getLevel1Approval());
//        dto.setLevel2Approval(approval.getLevel2Approval());
//        dto.setLevel3Approval(approval.getLevel3Approval());
//
//        if (approval.getDesign() != null) {
//            dto.setDesign(new DesignDTO(approval.getDesign().getId(), approval.getDesign().getDesignVersion(), approval.getDesign().getDesignName(), approval.getDesign().getIsEditable()));
//        }
//
//        return dto;
//    }

//    public List<ApprovalDTO> getAllapprovals() {
//        List<Approval> approvals = approvalRepository.findAll();
//        List<ApprovalDTO> dtos = new ArrayList<>();
//
//        for (Approval approval : approvals) {
//            ApprovalDTO dto = new ApprovalDTO();
//            dto.setId(approval.getId());
//            dto.setFullyApproved(approval.getFullyApproved());
//            dto.setLevel1Approval(approval.getLevel1Approval());
//            dto.setLevel2Approval(approval.getLevel2Approval());
//            dto.setLevel3Approval(approval.getLevel3Approval());
//
//            if (approval.getDesign() != null) {
//                dto.setDesign(new DesignDTO(approval.getDesign().getId(), approval.getDesign().getDesignVersion(), approval.getDesign().getDesignName(), approval.getDesign().getIsEditable()));
//            }
//
//            dtos.add(dto);
//        }
//
//        return dtos;
//    }
}

//@Service
//public class ApprovalService {
//
//    @Autowired
//    private ApprovalRepository approvalRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private DesignRepository designRepository;
//
//
//    public List<ApprovalDTO> getAllApprovalsDTO() {
//        List<Approval> approvals = approvalRepository.findAll();
//        List<ApprovalDTO> dtos = new ArrayList<>();
//        for (Approval approval : approvals) {
//            ApprovalDTO dto = new ApprovalDTO();
//            dto.setId(approval.getId());
//            dto.setFullyApproved(approval.getFullyApproved());
//            dto.setLevel1Approval(approval.getLevel1Approval());
//            dto.setLevel2Approval(approval.getLevel2Approval());
//            dto.setLevel3Approval(approval.getLevel3Approval());
//            if (approval.getDesign() != null) {
////                dto.setDesign(approval.getDesign().getDesignName());
////                dto.setDesignId(approval.getDesign().getId());
////                dto.setIsEditable(approval.getDesign().getIsEditable());
//            }
//            dtos.add(dto);
//        }
//        return dtos;
//    }
////    public ApprovalDTO createApproval(ApprovalDTO approvalDTO) {
////        Design design = designRepository.findById(approvalDTO.getDesignId())
////                .orElseThrow(() -> new EntityNotFoundException("Design not found with id " + approvalDTO.getDesignId()));
////
////        Approval approval = new Approval();
////        approval.setFullyApproved(approvalDTO.getFullyApproved());
////        approval.setLevel1Approval(approvalDTO.getLevel1Approval());
////        approval.setLevel2Approval(approvalDTO.getLevel2Approval());
////        approval.setLevel3Approval(approvalDTO.getLevel3Approval());
////        approval.setDesign(design);
////
////        approval = approvalRepository.save(approval);
////
////        ApprovalDTO createdApprovalDTO = new ApprovalDTO();
////        createdApprovalDTO.setId(approval.getId());
////        createdApprovalDTO.setFullyApproved(approval.getFullyApproved());
////        createdApprovalDTO.setLevel1Approval(approval.getLevel1Approval());
////        createdApprovalDTO.setLevel2Approval(approval.getLevel2Approval());
////        createdApprovalDTO.setLevel3Approval(approval.getLevel3Approval());
//////        createdApprovalDTO.setDesignId(design.getId());
//////        createdApprovalDTO.setIsEditable(design.getIsEditable());
////
////        return createdApprovalDTO;
////    }
////    public Approval createApproval(Approval approval) {
////        return approvalRepository.save(approval);
////    }
//
////    public List<ApprovalDTO> getAllapprovalsDTO() {
////        List<Approval> approvals = approvalRepository.findAll();
////        List<ApprovalDTO> dtos = new ArrayList<>();
////        for (Approval approval : approvals) {
////            dtos.add(new ApprovalDTO(approval));
////        }
////        return dtos;
////    }
////
////    // Approve a Design object at the specified level
////    public Approval approveDesign(Long designId, Long approvalId, String userEmail, int level) {
////        Design design = designRepository.findById(designId)
////                .orElseThrow(() -> new EntityNotFoundException("Design not found with id " + designId));
////
////        Approval approval = approvalRepository.findById(approvalId)
////                .orElseThrow(() -> new EntityNotFoundException("Approval not found with id " + approvalId));
////
////        User user = userService.getUserByEmail(userEmail);
////
////        approval.approve(user, level);
////
////        if (approval.getLevel1Approval() != null && approval.getLevel2Approval() != null && approval.getLevel3Approval() != null) {
////            approval.setFullyApproved(true);
////        }
////
////        design.setApproval(approval);
////
////        designRepository.save(design);
////
////        return approvalRepository.save(approval);
////    }
//
//    public List<Approval> getAllapprovals() {
//        return approvalRepository.findAll();
//    }
////    public Approval createApproval(Approval approval) {
////        return approvalRepository.save(approval);
////    }
//
//}
//
//
//
////package com.example.adam.service;
////
////import com.example.adam.tbd.Approval;
////import com.example.adam.tbd.ApprovalRequest;
////import com.example.adam.tbd.Design;
////import com.example.adam.tbd.ApprovalRepository;
////import com.example.adam.repository.DesignRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import javax.persistence.EntityNotFoundException;
////
////@Service
////public class ApprovalService {
////    @Autowired
////    private ApprovalRepository approvalRepository;
////
////    @Autowired
////    private DesignRepository designRepository;
////
////    public Approval createApproval(ApprovalRequest approvalRequest) {
////        Design design = designRepository.findById(approvalRequest.getDesignId())
////                .orElseThrow(() -> new EntityNotFoundException("Design not found with id: " + approvalRequest.getDesignId()));
////
////        Approval approval = new Approval();
////        approval.setDesign(design);
////        approval.setLevel1Approval(approvalRequest.getLevel1Approval());
////        approval.setLevel2Approval(approvalRequest.getLevel2Approval());
////        approval.setLevel3Approval(approvalRequest.getLevel3Approval());
////        approval.setFullyApproved(false);
////
////        return approvalRepository.save(approval);
////    }
////
////    public void approveDesignRevision(Long approvalId, String employeeId, int level) {
////        Approval approval = approvalRepository.findById(approvalId)
////                .orElseThrow(() -> new EntityNotFoundException("Approval not found with id: " + approvalId));
////
////        if (level == 1) {
////            approval.setLevel1Approval(employeeId);
////        } else if (level == 2) {
////            approval.setLevel2Approval(employeeId);
////        } else if (level == 3) {
////            approval.setLevel3Approval(employeeId);
////        }
////
////        if (approval.getLevel1Approval() != null && approval.getLevel2Approval() != null && approval.getLevel3Approval() != null) {
////            approval.setFullyApproved(true);
////        }
////
////        approvalRepository.save(approval);
////    }
//}