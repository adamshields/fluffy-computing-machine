package com.example.adam.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    @Schema(description = "Hostname of the Service.", example = "server1")
    private String name;

    @Column(nullable = true)
    @Schema(description = "Status of the Server.", example = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "server_id", nullable = false)
    private Server server;
}
