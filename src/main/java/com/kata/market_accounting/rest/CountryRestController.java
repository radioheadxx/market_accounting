package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Projects;
import com.kata.market_accounting.service.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {
    CountryServiceImpl countryService;

    @GetMapping("/list")
    public List<Projects> getCountriesList() {
        return countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Projects> createCountry(@RequestBody Projects projects) {
        countryService.save(projects);
        return new ResponseEntity(projects, HttpStatus.CREATED);

    }

    @PutMapping("/edit")
    public ResponseEntity<Projects> editCountry(@RequestBody Projects projects) {
        countryService.update(projects);
        return new ResponseEntity(projects, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCountry(@RequestBody Projects projects) {
        countryService.delete(projects);
        return new ResponseEntity("User deleted", HttpStatus.OK);
    }
}








