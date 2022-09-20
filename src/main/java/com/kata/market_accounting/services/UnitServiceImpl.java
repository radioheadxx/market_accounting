package com.kata.market_accounting.services;

import com.kata.market_accounting.exception.EmptyInputException;
import com.kata.market_accounting.models.Unit;
import com.kata.market_accounting.repositories.UnitRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> getAllUnits() {
        if (unitRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("There is no list of units");
        }
        return unitRepository.findAll();
    }

    @Override
    public Unit getUnitById(Long id) {
        return unitRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no unit with ID " + id));
    }

    @Override
    public Unit saveUnit(Unit unit) {
        if (unit.getShortName() == null) {
            throw new EmptyInputException("Short name field cannot be empty");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        unit.setChangeTime(formattedDateTime);
        unit.setGeneralAccess(true);
        unit.setType("Пользовательский");
        unit.setOwnerDepartment("Основной");
        unit.setOwnerEmployee("Username");
        unit.setWhoChanged("Username");
        return unitRepository.save(unit);
    }

    @Override
    public Unit updateUnit(Unit unit) {
        if (unit.getShortName() == null) {
            throw new EmptyInputException("Short name field cannot be empty");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        unit.setChangeTime(formattedDateTime);
        unit.setWhoChanged("Username");
        return unitRepository.save(unit);
    }

    @Override
    public void deleteUnit(Long id) {
        if (unitRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Cannot be deleted because there is no unit with ID " + id);
        }
        unitRepository.deleteById(id);
    }

}
