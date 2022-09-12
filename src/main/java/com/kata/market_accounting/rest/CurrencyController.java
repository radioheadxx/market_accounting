package com.kata.market_accounting.rest;

import com.kata.market_accounting.mappers.CurrencyMapper;
import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.models.dto.CurrencyDto;
import com.kata.market_accounting.services.CurrencyService;
import com.kata.market_accounting.services.CurrencyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/api/currency")
@Api(value = "/api/currency", tags = "Currency controller", description = "Operations with currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyServiceImpl currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/new")
    @ApiOperation(value = "Create a new currency", notes = "Creates a new currency", tags = {"Currency API"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created")
    })
    public ResponseEntity<CurrencyDto> addNew(@RequestBody Currency currency) {
            currencyService.create(currency);
            return new ResponseEntity<>(CurrencyMapper.INSTANCE.toDto(currencyService.create(currency)), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get all currencies", notes = "Returns all currencies", tags = {"Currency API"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<List<CurrencyDto>> getCurrencies() {
        List<CurrencyDto> listDto = currencyService.getAll().stream().map(CurrencyMapper.INSTANCE::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a currency by id", notes = "Returns a currency as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The currency was not found")
    })
    public ResponseEntity<CurrencyDto> getCurrency(@PathVariable("id") @ApiParam(name = "id", value = "Currency id", example = "1") long id) {
        return new ResponseEntity<>(CurrencyMapper.INSTANCE.toDto(currencyService.getOneById(id)), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Update a currency", notes = "Updates a currency")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated"),
            @ApiResponse(code = 404, message = "Not found - The currency was not found")
    })
    public ResponseEntity<CurrencyDto> updateCurrency(@RequestBody Currency currency) {
        currencyService.update(currency);
        return new ResponseEntity<>(CurrencyMapper.INSTANCE.toDto(currencyService.update(currency)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a currency by id", notes = "Deletes a currency as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted"),
            @ApiResponse(code = 404, message = "Not found - The currency was not found")
    })
    public void delete(@PathVariable("id") @ApiParam(name = "id", value = "Currency id", example = "1") long id) {
        currencyService.delete(id);
    }
}
