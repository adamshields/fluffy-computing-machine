package com.example.adam.controller;

import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import com.example.adam.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class DesignController {
    @Autowired
    private DesignService designService;

    @GetMapping("/designs/{designId}")
    public ResponseEntity<Design> getDesignById(@PathVariable Long designId) {
        Design design = designService.getDesignById(designId);
        return ResponseEntity.ok(design);
    }

    @GetMapping("/designs")
    public ResponseEntity<List<Design>> getAllDesigns() {
        List<Design> designs = designService.getAllDesigns();
        return ResponseEntity.ok(designs);
    }
    @PutMapping("/designs/{id}/approve/{level}")
    public Design approveDesign(@PathVariable Long id, @PathVariable int level) {
        return designService.approveDesign(id, level);
    }

//    @GetMapping("/designs/{id}")
//    public ResponseEntity<Design> getDesign(@PathVariable Long id) {
//        Design design = designService.getDesignById(id);
//        if (design == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            Approval approval = design.getApproval();
//            design.setApproval(approval); // set the Approval object in the Design object
//            return ResponseEntity.ok(design);
//        }
//    }


//    @PostMapping("/designs")
//    public ResponseEntity<Design> createDesign(@RequestBody Design design) {
//        Design createdDesign = designService.createDesign(design);
//        return ResponseEntity.ok(createdDesign);
//    }

//    @PutMapping("/designs/{designId}")
//    public ResponseEntity<Void> updateDesign(@PathVariable Long designId,
//                                             @RequestBody Design design) {
//        design.setId(designId);
//        designService.updateDesign(design);
//        return ResponseEntity.ok().build();
//    }

//    @DeleteMapping("/designs/{designId}")
//    public ResponseEntity<Void> deleteDesign(@PathVariable Long designId) {
//        designService.deleteDesignById(designId);
//        return ResponseEntity.ok().build();
//    }
}


