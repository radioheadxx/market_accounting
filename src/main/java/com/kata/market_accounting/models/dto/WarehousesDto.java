package com.kata.market_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class WarehousesDto {
    private Long id;
    private String name;
    private Long cod;
    private String address;
    private Boolean access;
}
