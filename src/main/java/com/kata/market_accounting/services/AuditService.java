package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Audit;
import java.util.List;

public interface AuditService {
    List<Audit> getAllAudits();
    Audit getAuditById(Long id);
    Audit saveAudit(Audit audit);
    void deleteAudit(Long id);
}
