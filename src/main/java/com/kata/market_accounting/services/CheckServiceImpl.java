package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Check;
import com.kata.market_accounting.repositories.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CheckServiceImpl implements CheckService{
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final CheckRepository checkRepository;

    @Autowired
    public CheckServiceImpl(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @Override
    public Check create(Check check) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        check.setDataAndTime(formattedDateTime);
        return checkRepository.save(check);
    }

    @Override
    public List<Check> getAll() {
        if (checkRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("Нет счета");
        }
        return checkRepository.findAll();
    }

    @Override
    public Check getOneById(long id) {
        return checkRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Нет такого счета"));
    }

    @Override
    public Check update(Check check) {
        String formattedDateTime = LocalDateTime.now().format(formatter);
        check.setDataAndTime(formattedDateTime);
        return checkRepository.save(check);
    }

    @Override
    public void delete(Long id) {
        if (checkRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Не могу удалить счет, так как счет не найден");
        }
        checkRepository.deleteById(id);
    }
}

