package com.kata.market_accounting.models.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityDTO {
    @ApiModelProperty(notes = "Legal entity ID", example = "1", required = true)
    private Long id;

    @ApiModelProperty(notes = "Short name of the legal entity", example = "Legal entity 1", required = true)
    private String shortName;

    @ApiModelProperty(notes = "Legal entity code", example = "10")
    private Long code;

    @ApiModelProperty(notes = "Phone number of the legal entity", example = "8-999-999-99-99")
    private String telephone;

    @ApiModelProperty(notes = "Legal entity email", example = "Legalentity1@mail.ru", required = true)
    private String email;

    @ApiModelProperty(notes = "Physical address of the legal entity", example = "Moscow, Lipovaya, 10")
    private String physicalAddress;

    @ApiModelProperty(notes = "Legal entity comment with important information", example = "We have 4 branches...")
    private String comment;

    @ApiModelProperty(notes = "Legal entity public access", example = "true", required = true)
    private Boolean publicAccess;

}