package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.SaleChannel;
import com.kata.market_accounting.models.dto.SaleChannelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleChannelMapper {

    SaleChannelMapper INSTANCE = Mappers.getMapper(SaleChannelMapper.class);

    SaleChannelDto toDto(SaleChannel saleChannel);
}
