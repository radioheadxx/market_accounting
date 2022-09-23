package com.kata.market_accounting.services;

import com.kata.market_accounting.exceptions.EmptyInputException;
import com.kata.market_accounting.models.Contractor;
import com.kata.market_accounting.models.ContractorStatus;
import com.kata.market_accounting.repositories.ContractorRepository;
import com.kata.market_accounting.repositories.ContractorStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ContractorServiceImpl implements ContractorService{
    private final ContractorRepository contractorRepository;
    private final ContractorStatusRepository statusRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Autowired
    public ContractorServiceImpl(ContractorRepository contractorRepository, ContractorStatusRepository statusRepository) {
        this.contractorRepository = contractorRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void create(Contractor contractor) {
        if (contractor.getName() == null) {
            throw new EmptyInputException("Название не может быть пустым!");
        }
        String formattedDateTime = LocalDateTime.now().format(dateTimeFormatter);
        contractor.setCreatedAt(formattedDateTime);
        contractor.setChangedAt(formattedDateTime);
        contractor.setChangedWho("Test User");

        ContractorStatus status = new ContractorStatus("Новый", "Обычный", ContractorStatus.Colors.ORANGE);
        statusRepository.save(status);
        contractor.setStatus(status);
        contractorRepository.save(contractor);
    }

    @Override
    public List<Contractor> getAll() {
        if (contractorRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("Нет контрагентов");
        }
        return contractorRepository.findAll();
    }

    @Override
    public Contractor getOneById(long id) {
        return contractorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Нет такого контрагента"));
    }

    @Override
    public Contractor update(Contractor contractor) {
        if (contractor.getName() == null) {
            throw new EmptyInputException("Название не может быть пустым!");
        }
        String formattedDateTime = LocalDateTime.now().format(dateTimeFormatter);
        contractor.setChangedAt(formattedDateTime);
        contractor.setChangedWho("Test User");
        return contractorRepository.save(contractor);
    }

    @Override
    public void delete(Long id) {
        if (contractorRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Не могу удалить контрагента, так как контрагент не найден");
        }
        contractorRepository.deleteById(id);
    }
}
