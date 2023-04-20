package com.example.adam.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Other common fields and methods

    // Getters and setters
}
