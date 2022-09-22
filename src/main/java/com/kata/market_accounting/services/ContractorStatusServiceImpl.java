package com.kata.market_accounting.services;

import com.kata.market_accounting.models.ContractorStatus;
import com.kata.market_accounting.repositories.ContractorStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContractorStatusServiceImpl implements ContractorStatusService {
    private final ContractorStatusRepository contractorStatusRepo;

    @Autowired
    public ContractorStatusServiceImpl(ContractorStatusRepository contractorStatusRepo) {
        this.contractorStatusRepo = contractorStatusRepo;
    }

    @Override
    public ContractorStatus create(ContractorStatus contractorStatus) {
        return contractorStatusRepo.save(contractorStatus);
    }

    @Override
    public List<ContractorStatus> getAll() {
        return contractorStatusRepo.findAll();
    }

    @Override
    public ContractorStatus getOneById(long id) {
        Optional<ContractorStatus> foundContractorStatus = contractorStatusRepo.findById(id);
        return foundContractorStatus.orElse(null);
    }

    @Override
    public ContractorStatus update(ContractorStatus contractorStatus) {
        return contractorStatusRepo.save(contractorStatus);
    }

    @Override
    public void delete(Long id) {
        contractorStatusRepo.deleteById(id);
    }
}
