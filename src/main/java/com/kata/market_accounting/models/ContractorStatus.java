package com.kata.market_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ContractorStatus {
    @Id
    private long id;
    private String description;
    private StatusDefinitions definition;
    private Colors color;

    public enum StatusDefinitions {
        USUAL("Обычный"),
        FINAL_POSITIVE("Финальный положительный"),
        FINAL_NEGATIVE("Финальный отрицательный");

        private String def;

        StatusDefinitions(String def) {
            this.def = def;
        }
    }

    public enum Colors {
        GRAY, RED, ORANGE, BROWN, SAGE, CHARTREUSE, KHAKI, GREEN, LIGHT_BLUE, BLUE, INDIGO, DARK_BLUE, PINK, PURPLE, PLUM, BLACK
    }
}