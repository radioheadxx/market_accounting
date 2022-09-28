package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Check;
import com.kata.market_accounting.repositories.CheckRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public CheckServiceImpl(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @Override
    public Check create(Check check) {
        return null;
    }

    @Override
    public List<Check> getAll() {
        return null;
    }

    @Override
    public Check getOneById(long id) {
        return null;
    }

    @Override
    public Check update(Check check) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
