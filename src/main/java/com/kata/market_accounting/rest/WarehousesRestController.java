package com.kata.market_accounting.rest;


import com.kata.market_accounting.mappers.WarehousesMapper;
import com.kata.market_accounting.models.Warehouses;
import com.kata.market_accounting.models.dto.WarehousesDto;
import com.kata.market_accounting.services.WarehousesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WarehousesRestController {
    WarehousesService warehousesService;

    @GetMapping
    @ApiOperation(value = "Get list of warehouses",
            notes = "Returns a full list of warehouses from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<List<WarehousesDto>> getWarehousesList(){
        List<WarehousesDto> listDto = warehousesService.getAllWarehouses().stream().map(WarehousesMapper.INSTANCE::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(listDto, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get single warehouses by ID",
            notes = "Returns a sale channel by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<WarehousesDto> getWarehouses(@PathVariable("id") Long id) {
        return new ResponseEntity<>(WarehousesMapper.INSTANCE.toDto(warehousesService.getWarehouses(id)), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create warehouses",
            notes = "Creates a new warehouses and saves it to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Warehouses successfully created")
    })
    public ResponseEntity<WarehousesDto> createWarehouses(@RequestBody Warehouses warehouses){
        return new ResponseEntity<>(WarehousesMapper.INSTANCE.toDto(warehousesService.createWarehouses(warehouses)), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Edit warehouses",
            notes = "Allows to change existing warehouses in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Warehouses successfully edited")
    })
    public ResponseEntity<WarehousesDto> updateWarehouses(@RequestBody Warehouses warehouses){
        return new ResponseEntity<>(WarehousesMapper.INSTANCE.toDto(warehousesService.createWarehouses(warehouses)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete warehouses by ID",
            notes = "Deletes a warehouses by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Warehouses successfully deleted")
    })
    public ResponseEntity<String> deleteWarehouses(@RequestBody Warehouses warehouses){
        warehousesService.deleteWarehouses(warehouses);
        return  new ResponseEntity("User deleted", HttpStatus.OK);
    }
}
