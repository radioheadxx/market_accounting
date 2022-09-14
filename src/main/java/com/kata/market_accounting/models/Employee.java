package com.kata.market_accounting.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "entrance")
    private Boolean entrance;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "inn")
    private String inn;
    @Column(name = "login")
    private String login;
    @Column(name = "description")
    private String description;
    @Column(name = "general_access")
    private String generalAccess;
    @Column(name="date_and_time")
    private String dateAndTime;
    @Column(name = "author")
    private String author;
    @ManyToOne(targetEntity = Role.class)
    private Role roles;
}
