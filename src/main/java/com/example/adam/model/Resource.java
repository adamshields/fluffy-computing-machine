package com.example.adam.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("resource") // ignore the resource field in the Attribute object during serialization
    private List<Attribute> attributes;

    private Integer activeRecord;

    // Required by JPA
    protected Resource() {}

    public Resource(String type, List<Attribute> attributes, Integer activeRecord) {
        this.type = type;
        this.attributes = attributes;
        this.activeRecord = activeRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Integer getActiveRecord() {
        return activeRecord;
    }

    public void setActiveRecord(Integer activeRecord) {
        this.activeRecord = activeRecord;
    }
}
