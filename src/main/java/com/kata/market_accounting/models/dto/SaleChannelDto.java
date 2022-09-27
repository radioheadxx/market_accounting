package com.kata.market_accounting.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleChannelDto {
    private long id;
    private String name;
    private String type;
    private String description;
    private Boolean generalAccess;
    private String ownerDepartment;
    private String ownerEmployee;
    private String dateAndTime;
    private String author;
}
