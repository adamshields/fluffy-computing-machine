package com.example.adam.controller;

import com.example.adam.entity.Server;
import com.example.adam.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

@RestController
@RequestMapping("v1/api/")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @Operation(summary = "Create a new server")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/server")
    public ResponseEntity<Server> createServer(@Parameter(description = "Server to be created") @RequestBody Server server) {
        Server createdServer = serverService.create(server);
        return ResponseEntity.ok(createdServer);
    }

    @Operation(summary = "Get all servers")
    @GetMapping("/server")
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverService.findAll();
        return ResponseEntity.ok(servers);
    }

    @Operation(summary = "Get a server by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server found"),
            @ApiResponse(responseCode = "404", description = "Server not found")
    })
    @GetMapping("/server/{id}")
    public ResponseEntity<Server> getServerById(@Parameter(description = "ID of the server to be obtained") @PathVariable Long id) {
        Server server = serverService.findById(id);
        return ResponseEntity.ok(server);
    }

    @Operation(summary = "Update an existing server")
    @PutMapping("/server/{id}")
    public ResponseEntity<Server> updateServer(@Parameter(description = "ID of the server to be updated") @PathVariable Long id,
                                               @Parameter(description = "Updated server object") @RequestBody Server server) {
        Server updatedServer = serverService.update(id, server);
        return ResponseEntity.ok(updatedServer);
    }

    @Operation(summary = "Delete a server by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Server not found")
    })
    @DeleteMapping("/server/{id}")
    public ResponseEntity<Void> deleteServer(@Parameter(description = "ID of the server to be deleted") @PathVariable Long id) {
        serverService.delete(id);
        return ResponseEntity.ok().build();
    }
}