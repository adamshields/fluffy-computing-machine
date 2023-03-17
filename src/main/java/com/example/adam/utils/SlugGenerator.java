package com.example.adam.utils;

import org.springframework.stereotype.Component;

@Component
public class SlugGenerator {

    public String generateSlug(String text) {
        String baseSlug = text.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
        return baseSlug.replaceAll("\\s+", "-");
    }
}
