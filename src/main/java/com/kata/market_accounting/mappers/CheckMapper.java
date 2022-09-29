package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Check;
import com.kata.market_accounting.models.dto.CheckDto;
import org.mapstruct.factory.Mappers;

public interface CheckMapper {
    CheckMapper INSTANCE = Mappers.getMapper(CheckMapper.class);

    CheckDto toDto(Check check);
}

