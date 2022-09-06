package com.kata.market_accounting.models.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class DTOProjects {

    private Long id;

    private String name;

    private Long code;

    private String description;

    private boolean access;

    private String date;
}
