package com.example.adam.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ServiceDTO {
    @Schema(description = "Unique identifier of the Service. Not required when creating a new server.",
            example = "1", required = false, readOnly = true)
    private Long id;

    @Schema(description = "Name Not required when creating a new server.",
            example = "Foo", required = false)
    private String name;

    @Schema(description = "Status",
            example = "active", required = false)
    private String status;
}
