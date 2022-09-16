package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.models.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    CountryDTO toDTO (Country country);
}
