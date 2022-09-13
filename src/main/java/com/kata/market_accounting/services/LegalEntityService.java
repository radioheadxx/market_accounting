package com.kata.market_accounting.services;

import com.kata.market_accounting.models.dto.LegalEntityDTO;

import java.util.List;


public interface LegalEntityService {

    List<LegalEntityDTO> getAllLegalEntities();

    LegalEntityDTO getLegalEntityById(Long id);

    void createLegalEntity(LegalEntityDTO legalEntityDTO);

    void deleteLegalEntityById(Long id);

}
