package com.kata.market_accounting.rest;
import com.kata.market_accounting.mappers.AuditMapper;
import com.kata.market_accounting.models.Audit;
import com.kata.market_accounting.models.dto.AuditDto;
import com.kata.market_accounting.services.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/audit")
@Api(tags = "Audit controller")
public class AuditRestController {

    private final AuditService auditService;
    private final AuditMapper auditMapper;

    public AuditRestController(AuditService auditService, AuditMapper auditMapper) {
        this.auditService = auditService;
        this.auditMapper = auditMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get audit by ID")
    public ResponseEntity<AuditDto> getAuditById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(auditMapper.domainToDTO(auditService.getAuditById(id)), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get all audits")
    public ResponseEntity<List<AuditDto>> getAllAudits() {
        return new ResponseEntity<>(auditMapper.domainsToListDTO(auditService.getAllAudits()), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create new audit")
    public ResponseEntity<AuditDto> createAudit(@RequestBody @Valid Audit audit) {
        return new ResponseEntity<>(auditMapper.domainToDTO(auditService.saveAudit(audit)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete unit by ID")
    public void deleteAudit(@PathVariable("id") Long id) {
        auditService.deleteAudit(id);
    }

}














