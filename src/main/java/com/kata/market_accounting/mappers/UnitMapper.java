package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Unit;
import com.kata.market_accounting.models.dto.UnitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UnitMapper extends BaseMapper<Unit, UnitDto> {
}
