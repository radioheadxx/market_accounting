package com.kata.market_accounting.init;

import com.kata.market_accounting.models.Audit;
import com.kata.market_accounting.services.AuditService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitAudit implements ApplicationRunner {

    private final AuditService auditService;

    public InitAudit(AuditService auditService) {
        this.auditService = auditService;
    }

    @Override
    public void run(ApplicationArguments args) {
        Audit audit = new Audit();
        audit.setEvent("Вход в МойСклад");
        audit.setEmployee("User");

        auditService.saveAudit(audit);
    }
}
