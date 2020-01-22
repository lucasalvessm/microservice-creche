package br.com.facil.creche.microservice.creche.controller;

import br.com.facil.creche.microservice.creche.entity.Creche;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrecheController {

    public static final String CRECHE_ID = "Creche id";

    @ApiOperation(value = "Create a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return the creche created")
    })
    @PostMapping(value = "/creches", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> create(@ApiParam("Creche object to create") Object body) {
        Creche creche = Creche.builder().id(1L).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ApiOperation(value = "Delete a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Creche deleted successfully")
    })
    @DeleteMapping("/creches/:id")
    public ResponseEntity delete(@ApiParam(CRECHE_ID) long id) {
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Update a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creche updated successfully")
    })
    @PutMapping(value = "/creches/:id", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> update(
            @ApiParam(CRECHE_ID) long id,
            @ApiParam("Creche object to update") Object body
    ) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "List all creches")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creches listed successfully")
    })
    @GetMapping(value = "/creches", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> listAllByLocation() {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "Get detail of one creche")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creche retrieved successfully")
    })
    @GetMapping(value = "/creches/:id", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getDetail(@ApiParam(CRECHE_ID) long id) {
        return ResponseEntity.ok(null);
    }
}
