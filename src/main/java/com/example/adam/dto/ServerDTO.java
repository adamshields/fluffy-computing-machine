package com.example.adam.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ServerDTO {
    @Schema(description = "Unique identifier of the Server. Not required when creating a new server.",
            example = "1", required = false, readOnly = true)
    private Long id;

    @Schema(description = "Hostname of the Server. Required for creating or updating a server.",
            example = "server1", required = true)
    private String hostname;

    @Schema(description = "IP Address of the Server. Required for creating or updating a server.",
            example = "192.168.1.1", required = true)
    private String ipAddress;

    @Schema(description = "Fully Qualified Domain Name (FQDN) of the Server. Required for creating or updating a server.",
            example = "server1.example.com", required = true)
    private String fqdn;

    @Schema(description = "List of services related to this server. Optional.",
            required = false)
    private List<ServiceDTO> services;
}
