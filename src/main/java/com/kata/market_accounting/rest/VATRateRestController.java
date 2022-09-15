package com.kata.market_accounting.rest;

import com.kata.market_accounting.mappers.VATRateMapper;
import com.kata.market_accounting.models.VATRate;
import com.kata.market_accounting.models.dto.VATRateDTO;
import com.kata.market_accounting.services.VATRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/api/vat_rate")
@Api(tags = "Value added tax rate controller")
public class VATRateRestController {

    private final VATRateService service;

    public VATRateRestController(VATRateService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Get list of value added tax rates",
            notes = "Returns a full list of value added tax rates from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<List<VATRateDTO>> getAllRates() {
        List<VATRateDTO> ratesList = service.listRates().stream()
                .map(VATRateMapper.INSTANCE::toDTO).toList();
        return new ResponseEntity<>(ratesList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get single value added tax rate by ID",
            notes = "Returns a value added tax rate by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<VATRateDTO> getRateById(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                VATRateMapper.INSTANCE.toDTO(service.getRate(id)),
                HttpStatus.OK
        );
    }

    @PostMapping
    @ApiOperation(value = "Create value added tax rate",
            notes = "Creates a new rate and saves it to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tax rate successfully created")
    })
    public ResponseEntity<String> createRate(@RequestBody VATRate rate) {
        service.createRate(rate);
        return new ResponseEntity<>(
                "Tax rate successfully created", HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Edit value added tax rate",
            notes = "Allows to change existing rate in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tax rate successfully edited")
    })
    public ResponseEntity<String> updateRate(@RequestBody VATRate rate) {
        service.updateRate(rate);
        return new ResponseEntity<>(
                "Tax rate successfully edited", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete value added tax rate by ID",
            notes = "Deletes a tax rate by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tax rate successfully deleted")
    })
    public ResponseEntity<String> deleteRate(@PathVariable("id") long id) {
        service.deleteRate(id);
        return new ResponseEntity<>(
                "Tax rate successfully deleted", HttpStatus.OK);
    }

}
