package com.example.adam.service;

import com.example.adam.model.DesignsModel;
import com.example.adam.repository.DesignsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DesignRevisioningService {

    @Autowired
    private DesignsRepository designsRepository;

    public DesignsModel createNewDesignRevision(DesignsModel design){

        DesignsModel newDesign = designsRepository.save(design);
        return newDesign;
    }

    private boolean checkAppIdExistence(Integer appId) {
        return designsRepository.checkAppIdExists().contains(appId);
    }

//    private String  getPresentVersion(Integer appId){
//        return  designsRepo.getPresentDesign(appId);
//    }

    private DesignsModel getPresentVersion(Integer appId) {
        return designsRepository.getPresentDesign(appId);
    }

    public DesignsModel createNewRevision(DesignsModel design) {
        DesignsModel rev = null;
        DesignsModel existingDesign = null;

        if (checkAppIdExistence(design.getAppId())) {
            existingDesign = getPresentVersion(design.getAppId());
        } else {
            createNewDesignRevision(design);
        }

        if (existingDesign != null) {
            // Set base version for new design
            design.setDesignBase(existingDesign.getDesignVersion());

            // Set old design ID for new design
            design.setOldDesignId(existingDesign.getDesignId());
        }

        // save design after object has been modified
        rev = designsRepository.save(design);

        return rev;
    }

//    public DesignsModel createNewRevision(DesignsModel design){
//        String designBase = null;
//        Integer oldDesignId = null;
//
//        if (checkAppIdExistence(design.getAppId()) == true){
//            String[] getIdAndVersion = getPresentVersion(design.getAppId()).split(",");
//            oldDesignId = Integer.parseInt(getIdAndVersion[0]);
//            designBase = getIdAndVersion[1];
//        } else {
//            createNewDesignRevision(design);
//        }
//        // Set base version for new design
//        design.setDesignBase(designBase);
//
//        // save design after object has been modified
//        DesignsModel rev = designsRepo.save(design);
//        Integer newDesignId = rev.getDesignId();
//
//        return rev;
//    }

}
