package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.dto.LegalEntityDTO;
import com.kata.market_accounting.exceptions.LegalEntityException;
import com.kata.market_accounting.services.LegalEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/legal_entities")
@Api(tags = "Legal entity controller")
@RequiredArgsConstructor
public class LegalEntityRestController {
    private final LegalEntityService legalEntityService;

    @ApiOperation(value = "Get a list of legal entities", notes = "Returns a list of legal entities")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping()
    public ResponseEntity<List<LegalEntityDTO>> getAllLegalEntities() {
        return new ResponseEntity<>(legalEntityService.getAllLegalEntities(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a legal entity by id", notes = "Returns a legal entity per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 400, message = "Not found - The legal entity with this id wasn't found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LegalEntityDTO> getLegalEntityById(@PathVariable ("id") @ApiParam(name = "id"
            , value = "Legal entity id", example = "1") Long id) {
        try {
            LegalEntityDTO legalEntityDTO = legalEntityService.getLegalEntityById(id);
            return new ResponseEntity<>(legalEntityDTO, HttpStatus.OK);
        } catch (LegalEntityException legalEntityException) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Post a legal entity", notes = "Creating a new legal entity in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created"),
            @ApiResponse(code = 400, message = "The legal entity wasn't created - a required field wasn't filled")
    })
    @PostMapping()
    public ResponseEntity<String> createLegalEntity(@RequestBody LegalEntityDTO legalEntityDTO) {
        try {
            legalEntityService.createLegalEntity(legalEntityDTO);
            return new ResponseEntity<>("The legal entity was created", HttpStatus.OK);
        } catch (LegalEntityException legalEntityException) {
            return new ResponseEntity<>(legalEntityException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Put a legal entity", notes = "Updating a legal entity in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated"),
            @ApiResponse(code = 400, message = "The legal entity wasn't updated - a required field wasn't filled")
    })
    @PutMapping()
    public ResponseEntity<String> updateLegalEntity(@RequestBody LegalEntityDTO legalEntityDTO) {
        try {
            legalEntityService.createLegalEntity(legalEntityDTO);
            return new ResponseEntity<>("The legal entity was updated", HttpStatus.OK);
        } catch (LegalEntityException legalEntityException) {
            return new ResponseEntity<>(legalEntityException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Delete a legal entity", notes = "Deleting a legal entity per the id from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted"),
            @ApiResponse(code = 400, message = "The legal entity wasn't deleted - The legal entity with this id wasn't found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLegalEntity(@PathVariable ("id") @ApiParam(name = "id"
            , value = "Legal entity id", example = "1") Long id) {
        try {
            legalEntityService.deleteLegalEntityById(id);
            return new ResponseEntity<>("The legal entity was deleted", HttpStatus.OK);
        } catch (LegalEntityException legalEntityException) {
            return new ResponseEntity<>(legalEntityException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
