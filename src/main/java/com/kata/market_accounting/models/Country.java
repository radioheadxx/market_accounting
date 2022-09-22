package com.kata.market_accounting.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "countries", schema = "market")
@Data
@NoArgsConstructor
public class Country {

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

    public Country(Long id, String shortName, String fullName, byte digitalCode, String letterCode1, String letterCode2, boolean access) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.digitalCode = digitalCode;
        this.letterCode1 = letterCode1;
        this.letterCode2 = letterCode2;
        this.access = access;
    }

}

