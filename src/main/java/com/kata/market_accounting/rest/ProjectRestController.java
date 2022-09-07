package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProjectRestController {
    private final ProjectServiceImpl countryService;

    @Autowired
    public ProjectRestController(ProjectServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public List<Project> getCountriesList() {
        return countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Project> createCountry(@RequestBody Project project) {
        countryService.save(project);
        return new ResponseEntity(project, HttpStatus.CREATED);

    }

    @PutMapping("/edit")
    public ResponseEntity<Project> editCountry(@RequestBody long id, Project project) {
        countryService.update(id, project);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCountry(@RequestBody Project project) {
        countryService.delete(project);
        return new ResponseEntity("User deleted", HttpStatus.OK);
    }
}








