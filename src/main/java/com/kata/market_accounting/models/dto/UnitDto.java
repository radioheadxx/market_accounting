package com.kata.market_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitDto {
    private Long id;
    private String fullName;
    private String shortName;
    private int digitalCode;
    private String type;
    private boolean generalAccess;
    private String ownerDepartment;
    private String ownerEmployee;
    private String changeTime;
    private String whoChanged;
}
