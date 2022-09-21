package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.VATRate;
import com.kata.market_accounting.models.dto.VATRateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VATRateMapper {
    VATRateMapper INSTANCE = Mappers.getMapper(VATRateMapper.class);

    VATRate toRate(VATRateDTO dto);
    VATRateDTO toDTO(VATRate rate);
}
