package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.services.CurrencyService;
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
@RequestMapping("/app/currency")
public class CurrencyController {
    private final CurrencyService service;

    @Autowired
    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void addNew(@RequestBody Currency currency) {
        service.create(currency);
    }

    @GetMapping
    public List<Currency> getCurrencies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Currency getCurrency(@PathVariable("id") long id) {
        return service.getOneById(id);
    }

    @PutMapping
    public void updateCurrency(@RequestBody Currency currency) {
        service.update(currency);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
