package com.kata.market_accounting.init;

import com.kata.market_accounting.models.ContractorStatus;
import com.kata.market_accounting.repositories.ContractorStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitContractorStatus implements ApplicationRunner {
    private final ContractorStatusRepository contractorStatusRepository;

    @Autowired
    public InitContractorStatus(ContractorStatusRepository contractorStatusRepository) {
        this.contractorStatusRepository = contractorStatusRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ContractorStatus status1 = new ContractorStatus();
        ContractorStatus status2 = new ContractorStatus();
        ContractorStatus status3 = new ContractorStatus();
        ContractorStatus status4 = new ContractorStatus();
        ContractorStatus status5 = new ContractorStatus();

        status1.setDescription("Новый");
        status1.setDefinition(ContractorStatus.StatusDefinitions.USUAL.getDef());
        status1.setColor(ContractorStatus.Colors.ORANGE);

        status2.setDescription("Выслано предложение");
        status2.setDefinition(ContractorStatus.StatusDefinitions.USUAL.getDef());
        status2.setColor(ContractorStatus.Colors.PURPLE);

        status3.setDescription("Переговоры");
        status3.setDefinition(ContractorStatus.StatusDefinitions.USUAL.getDef());
        status3.setColor(ContractorStatus.Colors.BLUE);

        status4.setDescription("Сделка заключена");
        status4.setDefinition(ContractorStatus.StatusDefinitions.FINAL_POSITIVE.getDef());
        status4.setColor(ContractorStatus.Colors.KHAKI);

        status5.setDescription("Сделка не заключена");
        status5.setDefinition(ContractorStatus.StatusDefinitions.FINAL_NEGATIVE.getDef());
        status5.setColor(ContractorStatus.Colors.RED);

        contractorStatusRepository.save(status1);
        contractorStatusRepository.save(status2);
        contractorStatusRepository.save(status3);
        contractorStatusRepository.save(status4);
        contractorStatusRepository.save(status5);
    }
}
