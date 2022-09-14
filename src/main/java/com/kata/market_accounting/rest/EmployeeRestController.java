package com.kata.market_accounting.rest;

import com.kata.market_accounting.mappers.EmployeeMapper;
import com.kata.market_accounting.models.Employee;
import com.kata.market_accounting.models.dto.EmployeeDto;;
import com.kata.market_accounting.services.EmployeeService;
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
public class EmployeeRestController {
    EmployeeService employeeService;

    @GetMapping
    @ApiOperation(value = "Get list of employee",
            notes = "Returns a full list of employee from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        List<EmployeeDto> listDto = employeeService.listEmployee().stream().map(EmployeeMapper.INSTANCE::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get single employee by ID",
            notes = "Returns a employee by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(EmployeeMapper.INSTANCE.toDto(employeeService.getEmployee(id)), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create employee",
            notes = "Creates a new employee and saves it to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee successfully created")
    })
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(EmployeeMapper.INSTANCE.toDto(employeeService.createEmployee(employee)), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Edit employee",
            notes = "Allows to change existing employee in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee successfully edited")
    })
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(EmployeeMapper.INSTANCE.toDto(employeeService.createEmployee(employee)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete employee by ID",
            notes = "Deletes a employee by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Employee successfully deleted")
    })
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployee(employee);
        return  new ResponseEntity("User deleted", HttpStatus.OK);
    }
}
