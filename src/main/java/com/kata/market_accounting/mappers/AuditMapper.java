package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Unit;
import com.kata.market_accounting.models.dto.UnitDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AuditMapper extends BaseMapper<Unit, UnitDto> {
}
