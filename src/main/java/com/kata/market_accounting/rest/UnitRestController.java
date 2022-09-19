package com.kata.market_accounting.rest;

import com.kata.market_accounting.mappers.UnitMapper;
import com.kata.market_accounting.models.Unit;
import com.kata.market_accounting.models.dto.UnitDto;
import com.kata.market_accounting.services.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/unit")
@Api(tags = "Unit controller")
public class UnitRestController {
    private final UnitService unitService;
    private final UnitMapper unitMapper;

    public UnitRestController(UnitService unitService, UnitMapper unitMapper) {
        this.unitService = unitService;
        this.unitMapper = unitMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get unit by ID")
    public ResponseEntity<UnitDto> getUnitById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(unitMapper.domainToDTO(unitService.getUnitById(id)), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get all units")
    public ResponseEntity<List<UnitDto>> getAllUnits() {
        List<UnitDto> listDto = unitMapper.domainsToListDTO(unitService.getAllUnits());
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create new unit")
    public ResponseEntity<UnitDto> createUnit(@RequestBody @Valid Unit unit) {
        return new ResponseEntity<>(unitMapper.domainToDTO(unitService.saveUnit(unit)), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Update unit")
    public ResponseEntity<UnitDto> updateUnit(@RequestBody @Valid Unit unit) {
        return new ResponseEntity<>(unitMapper.domainToDTO(unitService.updateUnit(unit)), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete unit by ID")
    public void delete(@PathVariable("id") Long id) {
        unitService.deleteUnit(id);
    }


}
