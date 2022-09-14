package com.kata.market_accounting.models.dto;

import lombok.Data;

@Data
public class CountryDTO {

    private Long id;

    private String shortName;

    private String fullName;

    private byte digitalCode;

    private String letterCode1;

    private String letterCode2;

    private boolean access;

    private String date;
}
