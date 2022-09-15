package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.models.dto.CurrencyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);
    CurrencyDto toDto(Currency currency);
}
