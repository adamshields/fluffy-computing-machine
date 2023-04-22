package com.example.adam.model.factory;

import com.example.adam.model.Resource;
import com.example.adam.model.GTM;




public class GTMFactory extends AbstractResourceFactory {
    @Override
    public Resource createResource(String id) {
        return new GTM(id);
    }
}