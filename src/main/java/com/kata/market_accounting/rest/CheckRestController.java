package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Check;
import com.kata.market_accounting.models.dto.CheckDto;
import com.kata.market_accounting.services.CheckService;
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

@RestController
@RequestMapping("/api/documents")
public class CheckRestController {
    private final CheckService checkService;
    private final ModelMapper mapper;


    @Autowired
    public CheckRestController(CheckService checkService, ModelMapper mapper) {
        this.checkService = checkService;
        this.mapper = mapper;
    }

    @PostMapping
    @ApiOperation(value = "Create check",
            notes = "Creates a new check and saves it to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Check successfully created")
    })
    public ResponseEntity<HttpStatus> createCheck(@RequestBody CheckDto checkDto) {
        checkService.create(convertToCheck(checkDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get list of check",
            notes = "Returns a full list of check from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public List<Check> getAllChecks() {
        return checkService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get single check by ID",
            notes = "Returns a check by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public Check getCheck(@PathVariable("id") long id) {
        return checkService.getOneById(id);
    }

    @PutMapping
    @ApiOperation(value = "Edit check",
            notes = "Allows to change existing check in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Check successfully edited")
    })
    public ResponseEntity<HttpStatus> updateCheck(@RequestBody CheckDto checkDto) {
        checkService.update(convertToCheck(checkDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete check by ID",
            notes = "Deletes a check by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Check successfully deleted")
    })
    public void deleteDocument(@PathVariable("id") long id) {
        checkService.delete(id);
    }

    private Check convertToCheck(CheckDto checkDto) {
        return mapper.map(checkDto, Check.class);
    }
}

