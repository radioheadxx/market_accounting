package com.kata.market_accounting.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouses", schema = "market")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cod")
    private Long cod;
    @Column(name = "address")
    private String address;
    @Column(name = "access")
    private Boolean access;
}
