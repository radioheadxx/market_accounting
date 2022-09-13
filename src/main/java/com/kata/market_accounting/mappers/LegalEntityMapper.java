package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.LegalEntity;
import com.kata.market_accounting.models.dto.LegalEntityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LegalEntityMapper extends BaseMapper<LegalEntity, LegalEntityDTO> {

}
