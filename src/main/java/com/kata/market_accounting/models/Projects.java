package com.kata.market_accounting.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Data
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "digital_code")
    private byte digitalCode;

    @Column(name = "letter_code1")
    private String letterCode1;

    @Column(name = "letter_code2")
    private String letterCode2;

    @Column(name = "access")
    private boolean access;

    @Column(name = "date")
    private String date;


}
