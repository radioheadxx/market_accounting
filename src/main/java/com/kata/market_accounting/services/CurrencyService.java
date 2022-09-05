package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.repositiries.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepo;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Transactional
    public void create(Currency currency){
        currencyRepo.save(currency);
    }

    public List<Currency> getAll() {
        return currencyRepo.findAll();
    }

    public Currency getOneById(long id) {
        Optional<Currency> foundCurrency = currencyRepo.findById(id);
        return foundCurrency.orElse(null);
    }

    @Transactional
    public void update(Currency currency) {
        currencyRepo.save(currency);
    }

    @Transactional
    public void delete(Long id) {
        currencyRepo.deleteById(id);
    }
}
