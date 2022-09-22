package com.kata.market_accounting.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @NotNull
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "digital_code")
    private int digitalCode;
    @Column(name = "type")
    private String type;
    @Column(name = "general_access")
    private boolean generalAccess;
    @Column(name = "owner_department")
    private String ownerDepartment;
    @Column(name = "owner_employee")
    private String ownerEmployee;
    @Column(name = "change_time")
    private String changeTime;
    @Column(name = "who_chaged")
    private String whoChanged;

    public Unit(Long id, String fullName, String shortName, int digitalCode) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.digitalCode = digitalCode;
    }
}
