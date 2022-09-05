package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.services.CurrencyService;
import com.kata.market_accounting.services.CurrencyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/currency")
@Api(tags = "Currency controller")
public class CurrencyController {
    private final CurrencyService service;

    @Autowired
    public CurrencyController(CurrencyServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    @ApiOperation(value = "Create currency")
    public void addNew(@RequestBody Currency currency) {
        service.create(currency);
    }

    @GetMapping
    @ApiOperation(value = "Get all currencies")
    public List<Currency> getCurrencies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get one currency")
    public Currency getCurrency(@PathVariable("id") long id) {
        return service.getOneById(id);
    }

    @PutMapping
    @ApiOperation(value = "Update currency")
    public void updateCurrency(@RequestBody Currency currency) {
        service.update(currency);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete currency")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
