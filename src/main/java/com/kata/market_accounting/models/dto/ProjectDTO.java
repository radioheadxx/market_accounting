package com.kata.market_accounting.models.dto;

import lombok.Data;
import org.mapstruct.Mapper;


@Data
public class ProjectDTO {

    private Long id;

    private String name;

    private Long code;

    private String description;

    private boolean access;

    private String date;
}
