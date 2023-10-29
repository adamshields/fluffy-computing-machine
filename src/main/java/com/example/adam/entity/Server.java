package com.example.adam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "servers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique identifier of the Server.", example = "1", required = false, readOnly = true)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Hostname of the Server.", example = "server1")
    private String hostname;

    @Column(nullable = false)
    @Schema(description = "IP Address of the Server.", example = "192.168.1.1")
    private String ipAddress;

    @Column(nullable = false)
    @Schema(description = "FQDN of the Server.", example = "server1.example.com")
    private String fqdn;

}
