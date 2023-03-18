package com.example.adam.populater;


import com.example.adam.model.DesignsModel;
import com.example.adam.repository.DesignsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private DesignsRepo designsRepo;

    @PostConstruct
    public void initialize() {
        for (int i = 1; i <= 5; i++) {
            DesignsModel designsModel = new DesignsModel();
            designsModel.setAppId(i);
            designsModel.setDesignVersion("1.0");
            designsModel.setDesignName("Design " + i);
            designsModel.setDesignBase("Base " + i);
            designsModel.setIsEditable(true);
            designsRepo.save(designsModel);
        }
    }
}
