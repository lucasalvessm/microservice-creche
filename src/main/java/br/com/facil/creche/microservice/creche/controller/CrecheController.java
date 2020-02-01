package br.com.facil.creche.microservice.creche.controller;

import br.com.facil.creche.microservice.creche.dto.CreateRequest;
import br.com.facil.creche.microservice.creche.dto.CrecheResponse;
import br.com.facil.creche.microservice.creche.dto.ListResponse;
import br.com.facil.creche.microservice.creche.dto.UpdateRequest;
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

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("creches")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CrecheController {

    public static final String COULD_NOT_FIND_ANY_CRECHE_FOR_PROVIDED_ID = "Could not find any creche for provided id";

    @Autowired
    private CrecheService crecheService;

    public static final String CRECHE_ID = "Creche id";

    @ApiOperation(value = "Create a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Return the creche created")
    })
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CrecheResponse> create(@ApiParam("Creche object to create")
                                                 @Valid @RequestBody CreateRequest creche) {
        return ResponseEntity.status(HttpStatus.CREATED).body(crecheService.create(creche));
    }

    @ApiOperation(value = "Delete a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Creche deleted successfully"),
            @ApiResponse(code = 404, message = COULD_NOT_FIND_ANY_CRECHE_FOR_PROVIDED_ID)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@ApiParam(value = CRECHE_ID, required = true) @PathVariable(value = "id") long id) {
        try {
            crecheService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Update a creche register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creche updated successfully"),
            @ApiResponse(code = 404, message = COULD_NOT_FIND_ANY_CRECHE_FOR_PROVIDED_ID)
    })
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CrecheResponse> update(@ApiParam("Creche object to update")
                                                 @Valid @RequestBody UpdateRequest creche) {
        try {
            return ResponseEntity.ok(crecheService.update(creche));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "List all creches")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creches listed successfully")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ListResponse>> listAll() {
        return ResponseEntity.ok(crecheService.listAll());
    }

    @ApiOperation(value = "Get detail of one creche")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Creche retrieved successfully"),
            @ApiResponse(code = 404, message = COULD_NOT_FIND_ANY_CRECHE_FOR_PROVIDED_ID)
    })
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CrecheResponse> getDetail(@ApiParam(value = CRECHE_ID, required = true) @PathVariable(value = "id") long id) {
        try {
            return ResponseEntity.ok(crecheService.getDetail(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
