package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Contractor;
import com.kata.market_accounting.models.dto.ContractorDto;
import com.kata.market_accounting.services.ContractorService;
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
@RequestMapping("/api/contractors")
public class ContractorRestController {
    private final ContractorService contractorService;
    private final ModelMapper modelMapper;

    @Autowired
    public ContractorRestController(ContractorService contractorService, ModelMapper modelMapper) {
        this.contractorService = contractorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/new")
    @ApiOperation(value = "Создает нового контрагента", notes = "Создает нового контрагента", tags = {"Contractors API"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Новый контрагент успешно создан")
    })
    public ResponseEntity<HttpStatus> createContractor(@RequestBody ContractorDto contractorDto) {
        contractorService.create(convertToContractor(contractorDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список всех контрагентов", notes = "Возвращает список всех контрагентов", tags = {"Contractors API"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получено")
    })
    public List<Contractor> getAllContractors() {
        return contractorService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возврашает контрагента по его id", notes = "Возврашает контрагента по его id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получено"),
            @ApiResponse(code = 404, message = "Контрагент не найден")
    })
    public Contractor getContractor(@PathVariable("id") long id) {
        return contractorService.getOneById(id);
    }

    @PutMapping
    @ApiOperation(value = "Обновляет контрагента", notes = "Обновляет контрагента")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно обновлено"),
            @ApiResponse(code = 404, message = "Контрагент не найден")
    })
    public ResponseEntity<HttpStatus> updateContractor(@RequestBody ContractorDto contractorDto) {
        contractorService.update(convertToContractor(contractorDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет контрагента по его id", notes = "Удаляет контрагента по его id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно удалено"),
            @ApiResponse(code = 404, message = "Контрагент не найден")
    })
    public void deleteStatus(@PathVariable("id") long id) {
        contractorService.delete(id);
    }

    private Contractor convertToContractor(ContractorDto contractorDto) {
        return modelMapper.map(contractorDto, Contractor.class);
    }
}
