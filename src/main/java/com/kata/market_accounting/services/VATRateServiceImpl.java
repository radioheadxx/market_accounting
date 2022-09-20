package com.kata.market_accounting.services;

import com.kata.market_accounting.models.VATRate;
import com.kata.market_accounting.repositories.VATRateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class VATRateServiceImpl implements VATRateService {

    private final VATRateRepository repository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public VATRateServiceImpl(VATRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VATRate> listRates() {
        return repository.findAll();
    }

    @Override
    public VATRate getRate(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void createRate(VATRate rate) {
        System.out.println(rate.getRate());
        rate.setGeneralAccess(true);
        rate.setOwnerDepartment("Основной");
        rate.setType("Пользовательский");
        rate.setDateAndTime(LocalDateTime.now().format(formatter));
        repository.save(rate);
    }

    @Override
    public void updateRate(VATRate rate) {
        VATRate rateFromDB = repository.getReferenceById(rate.getId());
        rateFromDB.setType("Пользовательский");
        rateFromDB.setRate(rate.getRate());
        rateFromDB.setComment(rate.getComment());
        rateFromDB.setGeneralAccess(true);
        rateFromDB.setOwnerDepartment(rate.getOwnerDepartment());
        rateFromDB.setOwnerEmployee(rate.getOwnerEmployee());
        rateFromDB.setDateAndTime(LocalDateTime.now().format(formatter));
        rateFromDB.setAuthor(rate.getAuthor());
        repository.flush();
    }

    @Override
    public void deleteRate(long id) {
        repository.deleteById(id);
    }
}
