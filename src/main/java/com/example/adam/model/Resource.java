package com.example.adam.model;

import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@Entity
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "resourceType",
        visible = false
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SAN.class, name = "san"),
        @JsonSubTypes.Type(value = Server.class, name = "server")
})

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
