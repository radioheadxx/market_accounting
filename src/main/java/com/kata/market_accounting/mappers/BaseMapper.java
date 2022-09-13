package com.kata.market_accounting.mappers;

import java.util.List;

public interface BaseMapper<D, DTO> {

    DTO domainToDTO(D domain);

    D DTOToDomain(DTO dto);

    List<DTO> domainsToListDTO(List<D> domains);

    List<D> DTOToListDomains(List<DTO> dto);
}
