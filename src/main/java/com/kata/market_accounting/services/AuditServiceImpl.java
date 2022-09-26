package com.kata.market_accounting.services;

import com.kata.market_accounting.exceptions.EmptyInputException;
import com.kata.market_accounting.models.Audit;
import com.kata.market_accounting.repositories.AuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {


    private final AuditRepository auditRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public List<Audit> getAllAudits() {
        if(auditRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("There is no list of audits");
        }
        return auditRepository.findAll();
    }

    @Override
    public Audit getAuditById(Long id) {
        return auditRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no audit with ID " + id));
    }

    @Override
    public Audit saveAudit(Audit audit) {
        if(audit.getEmployee() == null || audit.getEvent() == null) {
            throw new EmptyInputException("Fields cannot be empty");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        audit.setTime(formattedDateTime);
        return auditRepository.save(audit);
    }

    @Override
    public void deleteAudit(Long id) {
        if(auditRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Cannot be deleted because there is no unit with ID " + id);
        }
        auditRepository.deleteById(id);
    }
}
