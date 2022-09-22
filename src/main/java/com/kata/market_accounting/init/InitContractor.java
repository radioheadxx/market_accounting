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
        Contractor contractor1 = new Contractor();
        Contractor contractor2 = new Contractor();
        Contractor contractor3 = new Contractor();
        String formattedDateTime = LocalDateTime.now().format(formatter);

        contractor1.setName("ООО Покупатель");
        contractor1.setStatus(new ContractorStatus("Новый", ContractorStatus.StatusDefinitions.USUAL.getDef(), ContractorStatus.Colors.ORANGE));
        contractor1.setContractorType("Юридическое лицо");
        contractor1.setCRR("773601002");
        contractor1.setOwnerEmployee("New employee 1");
        contractor1.setOwnerDept("Основной");
        contractor1.setCreatedAt(formattedDateTime);
        contractor1.setChangedAt(formattedDateTime);
        contractor1.setChangedWho("New employee 1");

        contractor2.setName("ООО Поставщик");
        contractor2.setStatus(new ContractorStatus("Новый", ContractorStatus.StatusDefinitions.FINAL_POSITIVE.getDef(), ContractorStatus.Colors.BLUE));
        contractor2.setFullName("Общество с ограниченной ответственностью \"Поставщик\"");
        contractor2.setTIN("7736570901");
        contractor1.setContractorType("Юридическое лицо");
        contractor1.setCRR("773601001");
        contractor2.setLegalAddress("г.Москва, ул.Строителей, д.12");
        contractor1.setOwnerEmployee("New employee 2");
        contractor1.setOwnerDept("Основной");
        contractor1.setCreatedAt(formattedDateTime);
        contractor1.setChangedAt(formattedDateTime);
        contractor1.setChangedWho("New employee 2");

        contractor2.setName("Розничный покупатель");
        contractor1.setStatus(new ContractorStatus("Новый", ContractorStatus.StatusDefinitions.USUAL.getDef(), ContractorStatus.Colors.BROWN));
        contractor1.setContractorType("Физическое лицо");
        contractor1.setOwnerEmployee("New employee 1");
        contractor1.setOwnerDept("Основной");
        contractor1.setCreatedAt(formattedDateTime);
        contractor1.setChangedAt(formattedDateTime);
        contractor1.setChangedWho("Test user 1");

        contractorRepository.save(contractor1);
        contractorRepository.save(contractor2);
        contractorRepository.save(contractor3);
    }
}
