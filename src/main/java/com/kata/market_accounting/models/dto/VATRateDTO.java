package com.kata.market_accounting.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VATRateDTO {
    private long id;
    private String type;
    private int rate;
    private String comment;
    private Boolean generalAccess;
    private String ownerDepartment;
    private String ownerEmployee;
    private String dateAndTime;
    private String author;
}
