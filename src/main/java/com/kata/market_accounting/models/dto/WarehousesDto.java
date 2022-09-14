package com.kata.market_accounting.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WarehousesDto {
    private Long id;
    private String name;
    private Long cod;
    private String address;
    private Boolean access;
}
