package com.kata.market_accounting.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project", schema = "market")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "description")
    private String description;

    @Column(name = "access")
    private boolean access;

    @Column(name = "date")
    private String date;

    public Project(Long id, String name, Long code, String description, boolean access) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.access = access;
    }
}
