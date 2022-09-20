package com.kata.market_accounting.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class InitContractor implements ApplicationRunner {
    private final ContractorRepository contractorRepository;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");


    @Autowired
    public InitContractor(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Contractor contractor = new Contractor();
        String formattedDateTime = LocalDateTime.now().format(formatter);
        contractor.setName("ООО Покупатель");
        contractor.setStatus(new ContractorStatus("Новый", ContractorStatus.StatusDefinitions.USUAL.getDef(), ContractorStatus.Colors.ORANGE));
        contractor.setContractorType("Юридическое лицо");
        contractor.setCRR("773601002");
        contractor.setOwnerEmployee("New employee 1");
        contractor.setOwnerDept("Основной");
        contractor.setCreatedAt(formattedDateTime);
        contractor.setChangedAt(formattedDateTime);
        contractor.setChangedWho("Test user 1");
        contractorRepository.save(contractor);
    }
}
