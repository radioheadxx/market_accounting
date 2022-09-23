package com.kata.market_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDto {
    Long id;
    String time;
    Long image;
    String employee;
    String event;
}
