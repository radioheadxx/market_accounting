package com.kata.market_accounting.services;

import com.kata.market_accounting.exception.LegalEntityException;
import com.kata.market_accounting.mappers.LegalEntityMapper;
import com.kata.market_accounting.models.dto.LegalEntityDTO;
import com.kata.market_accounting.models.LegalEntity;
import com.kata.market_accounting.repositories.LegalEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LegalEntityServiceImpl implements LegalEntityService {

    private final LegalEntityRepository legalEntityRepository;
    private final LegalEntityMapper legalEntityMapper;

    @Override
    public List<LegalEntityDTO> getAllLegalEntities() {
        return legalEntityMapper.domainsToListDTO(legalEntityRepository.findAll());
    }

    @Override
    public LegalEntityDTO getLegalEntityById(Long id) {
        return legalEntityRepository.findById(id).map(legalEntityMapper::domainToDTO)
                .orElseThrow(() -> new LegalEntityException("Not found legal entity with ID: " + id));
    }

    @Override
    public boolean createLegalEntity(LegalEntityDTO legalEntityDTO) {
        if (legalEntityDTO.getShortName() == null || legalEntityDTO.getEmail() == null
                || legalEntityDTO.getPublicAccess() == null) {
                throw new LegalEntityException("Field 'short_name', 'email' or 'public_access' is not filled!");
        }
        legalEntityRepository.save(legalEntityMapper.DTOToDomain(legalEntityDTO));
        return true;
    }

    @Override
    public void deleteLegalEntityById(Long id) {
        LegalEntity legalEntityFromDB = legalEntityRepository.findById(id)
                .orElseThrow(() -> new LegalEntityException("Not found legal entity with ID: " + id));
        legalEntityRepository.deleteById(legalEntityFromDB.getId());
    }
}
