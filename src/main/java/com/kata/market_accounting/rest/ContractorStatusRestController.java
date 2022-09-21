package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.ContractorStatus;
import com.kata.market_accounting.models.dto.ContractorStatusDto;
import com.kata.market_accounting.services.ContractorStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contractors/status")
@Api(value = "/api/contractors/status", tags = "Contractors statuses controller", description = "Operations with statuses")
public class ContractorStatusRestController {
    private final ContractorStatusService statusService;
    private final ModelMapper modelMapper;

    @Autowired
    public ContractorStatusRestController(ContractorStatusService statusService, ModelMapper modelMapper) {
        this.statusService = statusService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/new")
    @ApiOperation(value = "Create a new status", notes = "Creates a new status", tags = {"Contractors statuses API"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created")
    })
    public ResponseEntity<HttpStatus> createStatus(@RequestBody ContractorStatusDto statusDto) {
        statusService.create(convertToStatus(statusDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get all statuses", notes = "Returns all statuses", tags = {"Contractors statuses API"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public List<ContractorStatusDto> getStatuses() {
        return statusService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a status by id", notes = "Returns a statuses as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The status was not found")
    })
    public ContractorStatusDto getStatus(@PathVariable("id") long id) {
        return convertToDto(statusService.getOneById(id));
    }

    @PutMapping
    @ApiOperation(value = "Update a status", notes = "Updates a statuses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated"),
            @ApiResponse(code = 404, message = "Not found - The status was not found")
    })
    public ResponseEntity<HttpStatus> updateStatus(@RequestBody ContractorStatus status) {
        statusService.update(status);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a status by id", notes = "Deletes a status as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted"),
            @ApiResponse(code = 404, message = "Not found - The status was not found")
    })
    public void deleteStatus(@PathVariable("id") long id) {
        statusService.delete(id);
    }

    private ContractorStatus convertToStatus(ContractorStatusDto statusDto) {
        return modelMapper.map(statusDto, ContractorStatus.class);
    }

    private ContractorStatusDto convertToDto(ContractorStatus status) {
        return modelMapper.map(status, ContractorStatusDto.class);
    }
}
