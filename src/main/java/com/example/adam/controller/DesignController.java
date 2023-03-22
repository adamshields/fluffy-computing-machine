package com.example.adam.controller;

import com.example.adam.model.DesignsModel;
import com.example.adam.repository.DesignsRepo;
import com.example.adam.service.DesignRevisioningService;
import com.example.adam.service.DesignService;
import com.example.adam.utils.CustomAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1")
public class DesignController {

    @Autowired
    private DesignsRepo designsRepo;
    @Autowired
    private DesignRevisioningService designRevSvc;
    @Autowired
    private DesignService designService;

    String className = this.getClass().getSimpleName();

    @GetMapping("/designs")
    ResponseEntity<?> getAllDesigns(@RequestParam(value = "appId", required = false) Integer appId) {
        try {
            List<DesignsModel> designs;
            if (appId != null) {
                designs = designsRepo.findByAppId(appId);
            } else {
                designs = designsRepo.findAll();
            }
            if (designs.isEmpty()) {
                log.debug("No designs found in getAllDesignsController");
                return CustomAPIResponse.generate204Response("No designs match your criteria",
                        "The database returned empty dataset, check your request and try again");
            }
            return new ResponseEntity<>(designs, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error processing getAllDesigns on " + className);
            e.printStackTrace();
            return CustomAPIResponse.generate500Response("The server was unable to process your request.",
                    "Error in " + className + ".getAllDesigns Controller ");
        }
    }

    @PostMapping("/designs")
    ResponseEntity<?> createDesign(@RequestBody DesignsModel design) {
        try {
            DesignsModel newDesign = designRevSvc.createNewRevision(design);

            if (newDesign.getDesignId() == null) {
                log.debug("Design not created");

            return CustomAPIResponse.generate204Response("Design could not be created.",
                    "Design could not be created. Please check your request body and try again.");
            }

            return new ResponseEntity<>(newDesign, HttpStatus.CREATED);

        } catch (Exception e) {
            log.error("ERROR Processing createDesigns on " + className);
            e.printStackTrace();
            return CustomAPIResponse.generate500Response("The server was unable to process your request.",
                    "Error in " + className + ".createDesign ");
        }

    }

    @PutMapping("/designs/{id}")
    ResponseEntity<?> updateDesign(@RequestBody DesignsModel newDesigns, @PathVariable Integer id) {

        try {
            DesignsModel existingDesign;
            if (designsRepo.existsById(id)) {
                existingDesign = designsRepo.findById(id).get();
            } else {
                log.debug("Design does not exist and cannot be updated.");
                return CustomAPIResponse.generate204Response("No designs match your criteria",
                        "The database returned and empty dataset. Please check your request parameters and try again.");
            }
            try {
                BeanUtils.copyProperties(newDesigns, existingDesign);
            } catch (Exception e) {
                log.error("Cannot copy updates to original design.");
                e.printStackTrace();
                return CustomAPIResponse.generate500Response("The server was unable to process your request.",
                        "Error in " + className + ".updateDesign (Copy)");
            }

            // Add approvals to existing design
            existingDesign.setApprovals(newDesigns.getApprovals());

            DesignsModel update = designsRepo.save(existingDesign);
            if (update.getDesignId() == null) {
                log.debug("Cannot save design to the database.");
                return CustomAPIResponse.generate500Response(
                        "The server was unable to process your request.",
                        "Error in " + className + ".updateDesign (Save)");
            }
            return new ResponseEntity<>(existingDesign, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR Processing updateDesign on " + className);
            e.printStackTrace();
            return CustomAPIResponse.generate500Response("The server was unable to process your request.",
                    "Error in " + className + ".updateDesign ");
        }
    }
}

//    @GetMapping("/designs/{designId}")
//    public DesignDTO getDesignById(@PathVariable Long designId) {
//        return designService.getDesignById(designId);
//    }
//
//    @PostMapping("/designs/{designId}/approvals")
//    public DesignDTO addApproval(@PathVariable Long designId, @RequestBody ApprovalDTO approvalDTO) {
//        return designService.addApproval(designId, approvalDTO);
//    }
//
//    @GetMapping("/designs/getall")
//    public List<DesignDTO> getAllDesigns() {
//        List<DesignDTO> designs = designService.getAllDesigns();
//        return designs;
//    }
