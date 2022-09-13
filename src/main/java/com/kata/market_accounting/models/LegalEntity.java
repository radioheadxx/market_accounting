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
@Table(name = "legal_entities")
@Data
@NoArgsConstructor
public class LegalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "code")
    private Long code;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Column(name = "comment")
    private String comment;

    @Column(name = "public_access", nullable = false)
    private Boolean publicAccess;

}
