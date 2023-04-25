package com.example.adam.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private boolean activeRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActiveRecord() {
        return activeRecord;
    }

    public void setActiveRecord(boolean activeRecord) {
        this.activeRecord = activeRecord;
    }

}
