package com.example.adam.model.factory;

import com.example.adam.dto.ResourceDTO;
import com.example.adam.model.Resource;
import com.example.adam.service.AbstractResourceService;



public abstract class AbstractResourceFactory {

    public abstract Resource createResource(ResourceDTO resourceDTO);

}
