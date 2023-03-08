
package com.example.adam.controller;


import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import com.example.adam.repository.DesignRepository;
import com.example.adam.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("v1")
public class ApprovalController {
    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private DesignRepository designRepository;

//    @GetMapping("/approvalsDTO")
//    public ResponseEntity<List<ApprovalDTO>> getApprovalsDto() {
//        List<ApprovalDTO> approvals = approvalService.getAllApprovalsDTO();
//        return new ResponseEntity<>(approvals, HttpStatus.OK);
//    }
//    @PostMapping("/approvals")
//    public ResponseEntity<Void> createApproval(@RequestBody ApprovalDTO approvalDTO) {
//        DesignDTO designDTO = approvalDTO.getDesign();
//        Design design = new Design();
//        design.setDesignVersion(designDTO.getDesignVersion());
//        design.setDesignName(designDTO.getDesignName());
//        design.setIsEditable(designDTO.getIsEditable());
//
//        Approval approval = new Approval();
//        approval.setFullyApproved(approvalDTO.getFullyApproved());
//        approval.setLevel1Approval(approvalDTO.getLevel1Approval());
//        approval.setLevel2Approval(approvalDTO.getLevel2Approval());
//        approval.setLevel3Approval(approvalDTO.getLevel3Approval());
//        approval.setDesign(design);
//
//        approvalService.createApproval(approval);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

//    @PostMapping("/approvals")
//    public ResponseEntity<Void> approveDesignRevision(@RequestBody Approval approval) {
//        approvalService.createApproval(approval);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @GetMapping("/approvals")
    public ResponseEntity<?> getApprovals() {
        return new ResponseEntity<>(approvalService.getAllApprovals(), HttpStatus.OK);
    }
}

//package com.example.adam.controller;
//
//import com.example.adam.model.Approval;
//import com.example.adam.model.ApprovalRequest;
//import com.example.adam.service.ApprovalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("v1")
//public class ApprovalController {
//    @Autowired
//    private ApprovalService approvalService;
//
//
//
//    @PostMapping("/approvals")
//    public ResponseEntity<Approval> createApproval(@RequestBody ApprovalRequest approvalRequest) {
//        Approval approval = approvalService.createApproval(approvalRequest);
//        return ResponseEntity.ok(approval);
//    }
//
//    @PostMapping("/{approvalId}/approve/{level}")
//    public ResponseEntity<Void> approveDesignRevision(@PathVariable Long approvalId,
//                                                      @RequestParam String employeeId,
//                                                      @PathVariable int level) {
//        approvalService.approveDesignRevision(approvalId, employeeId, level);
//        return ResponseEntity.ok().build();
//    }
////    @PostMapping("approvals/{approvalId}/approve/{level}")
////    public ResponseEntity<Void> approveDesignRevision(@PathVariable Long approvalId,
////                                                      @RequestParam String employeeId,
////                                                      @PathVariable int level) {
////        approvalService.approveDesignRevision(approvalId, employeeId, level);
////        return ResponseEntity.ok().build();
////    }
////    @GetMapping
////    public ResponseEntity<List<Approval>> getAllApprovals() {
////        List<Approval> approvals = approvalService.getAllApprovals();
////        return ResponseEntity.ok(approvals);
////    }
////    @GetMapping("/{approvalId}")
////    public ResponseEntity<Approval> getApproval(@PathVariable Long approvalId) {
////        Approval approval = approvalService.getApprovalById(approvalId);
////        return ResponseEntity.ok(approval);
////    }
//}
