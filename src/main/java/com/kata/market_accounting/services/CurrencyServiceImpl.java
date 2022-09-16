package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepo;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Override
    public Currency create(Currency currency){
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        currency.setDateEdit(formattedDateTime);
        return currencyRepo.save(currency);
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepo.findAll();
    }

    @Override
    public Currency getOneById(long id) {
        Optional<Currency> foundCurrency = currencyRepo.findById(id);
        return foundCurrency.orElse(null);
    }

    @Override
    public Currency update(Currency currency) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        currency.setDateEdit(formattedDateTime);
        return currencyRepo.save(currency);
    }

    @Override
    public void delete(Long id) {
        currencyRepo.deleteById(id);
    }
}
