package com.example.adam.model.factory;

import com.example.adam.model.LTM;
import com.example.adam.model.Resource;

public class LTMFactory extends AbstractResourceFactory {
    @Override
    public Resource createResource(String id) {
        return new LTM(id);
    }
}