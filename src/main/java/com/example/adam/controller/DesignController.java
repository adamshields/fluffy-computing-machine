package com.example.adam.controller;

import com.example.adam.dto.ApprovalDTO;
import com.example.adam.dto.DesignDTO;
import com.example.adam.model.Approval;
import com.example.adam.model.Design;
import com.example.adam.repository.ApprovalRepository;
import com.example.adam.repository.DesignRepository;
import com.example.adam.service.DesignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1")
public class DesignController {

    @Autowired
    private DesignService designService;



    @GetMapping("/designs/{designId}")
    public DesignDTO getDesignById(@PathVariable Long designId) {
        return designService.getDesignById(designId);
    }

    @PostMapping("/designs/{designId}/approvals")
    public DesignDTO addApproval(@PathVariable Long designId, @RequestBody ApprovalDTO approvalDTO) {
        return designService.addApproval(designId, approvalDTO);
    }

    @GetMapping("/designs/getall")
    public List<DesignDTO> getAllDesigns() {
        List<DesignDTO> designs = designService.getAllDesigns();
        return designs;
    }

}


