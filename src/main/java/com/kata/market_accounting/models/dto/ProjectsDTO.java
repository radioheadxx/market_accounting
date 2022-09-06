package com.kata.market_accounting.models.dto;

import lombok.Data;

@Data
public class ProjectsDTO {

    private Long id;

    private String name;

    private Long code;

    private String description;

    private boolean access;

    private String date;
}
