package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Warehouses;
import com.kata.market_accounting.models.dto.WarehousesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehousesMapper {

    WarehousesMapper INSTANCE = Mappers.getMapper(WarehousesMapper.class);

    WarehousesDto toDto(Warehouses unit);
}
