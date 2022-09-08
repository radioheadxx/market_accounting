package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.services.ProjectServiceImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Gets all projects", tags = "project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    @GetMapping("/list")
    public List<Project> getProjectsList() {
        return countryService.findAll();
    }

    @Operation(summary = "Created new project", tags = "project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created")
    })
    @PostMapping("/add")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        countryService.save(project);
        return new ResponseEntity(project, HttpStatus.CREATED);

    }

    @Operation(summary = "Edit project", tags = "project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully edited")
    })
    @PutMapping("/edit")
    public ResponseEntity<Project> editProject(@RequestBody long id, Project project) {
        countryService.update(id, project);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @Operation(summary = "Delete project", tags = "project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully deleted")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProject(@RequestBody Project project) {
        countryService.delete(project);
        return new ResponseEntity("Project deleted", HttpStatus.OK);
    }
}








