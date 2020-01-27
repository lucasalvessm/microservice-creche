package br.com.facil.creche.microservice.creche.controller;

import br.com.facil.creche.microservice.creche.dto.CrecheDTO;
import br.com.facil.creche.microservice.creche.dto.CrecheLightDTO;
import br.com.facil.creche.microservice.creche.service.CrecheService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("creches")
public class CrecheController {

    @Autowired
    private CrecheService crecheService;

    public static final String CRECHE_ID = "Creche id";

    @ApiOperation(value = "Create a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return the creche created")
    })
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CrecheDTO> create(@ApiParam("Creche object to create") CrecheDTO creche) {
        return ResponseEntity.status(HttpStatus.CREATED).body(crecheService.create(creche));
    }

    @ApiOperation(value = "Delete a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Creche deleted successfully"),
            @ApiResponse(code = 404, message = "Could not find any creche for provided id")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@ApiParam(CRECHE_ID) long id) {
        try {
            crecheService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Update a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creche updated successfully")
    })
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CrecheDTO> update(
            @ApiParam(CRECHE_ID) long id,
            @ApiParam("Creche object to update") CrecheDTO creche
    ) {
        return ResponseEntity.ok(crecheService.update(creche));
    }

    @ApiOperation(value = "List all creches")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creches listed successfully")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CrecheLightDTO>> listAll() {
        return ResponseEntity.ok(crecheService.listAll());
    }

    @ApiOperation(value = "Get detail of one creche")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creche retrieved successfully"),
            @ApiResponse(code = 404, message = "Could not find any creche for provided id")
    })
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CrecheDTO> getDetail(@ApiParam(CRECHE_ID) long id) {
        return ResponseEntity.ok(crecheService.getDetail(id));
    }
}
