package com.kata.market_accounting.rest;

import com.kata.market_accounting.mappers.CountryMapper;
import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.models.dto.CountryDTO;
import com.kata.market_accounting.services.CountryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Api(tags = "Country controller")
public class CountryRestController {
    CountryServiceImpl countryService;

    @Operation(summary = "Gets all countries", tags = "country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })

    @GetMapping("/list")
    public ResponseEntity<List<CountryDTO>> getCurrencies() {
        return new ResponseEntity(countryService.getCountries(), HttpStatus.OK);
    }

    @Operation(summary = "Created new country", tags = "country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created")
    })
    @PostMapping("/add")
    public ResponseEntity<CountryDTO> createCountry(@RequestBody Country country) {
        countryService.save(country);
        return new ResponseEntity(CountryMapper.INSTANCE.toDTO(country), HttpStatus.CREATED);
    }

    @Operation(summary = "Edit country", tags = "country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully edited")
    })
    @PutMapping("/edit")
    public ResponseEntity<CountryDTO> editCountry(@RequestBody long id, Country country) {
        countryService.update(id, country);
        return new ResponseEntity(CountryMapper.INSTANCE.toDTO(country), HttpStatus.OK);
    }

    @Operation(summary = "Delete country", tags = "country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully deleted")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCountry(@RequestBody long id) {
        countryService.delete(id);
        return new ResponseEntity("Country deleted", HttpStatus.OK);
    }
}








