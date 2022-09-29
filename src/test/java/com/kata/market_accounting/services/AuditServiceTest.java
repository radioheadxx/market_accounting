package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Audit;
import com.kata.market_accounting.repositories.AuditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuditServiceTest {

    @Mock
    private static AuditRepository auditRepository;

    @InjectMocks
    private AuditServiceImpl auditService;

    private Audit audit;

    @BeforeEach
    public void setup() {
        auditRepository = Mockito.mock(AuditRepository.class);
        auditService = new AuditServiceImpl(auditRepository);
        audit = new Audit(12L, "User", "Выход из МойСклад");
    }

    @Test
    public void should_get_one_audit() {
        when(auditRepository.findById(12L)).thenReturn(Optional.of(audit));
        assertThat(auditService.getAuditById(12L)).isNotNull();

    }

    @Test
    public void should_get_list_of_audits() {
        when(auditRepository.findAll()).thenReturn(Arrays.asList(audit));
        assertThat(auditService.getAllAudits().size()).isEqualTo(1);
    }

    @Test
    public void should_create_one_audit() {
        when(auditRepository.save(audit)).thenReturn(audit);
        assertThat(auditService.saveAudit(audit)).isNotNull();
    }
    @Test
    public void should_delete_audit() {
        doNothing().when(auditRepository).deleteById(12L);
        when(auditRepository.findById(12L)).thenReturn(Optional.of(audit));
        auditService.deleteAudit(12L);
        verify(auditRepository).deleteById(12L);
    }
}
