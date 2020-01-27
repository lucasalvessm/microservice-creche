package br.com.facil.creche.microservice.creche.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CrecheDTO {

    private Long id;

    @NotNull
    @ApiModelProperty(required = true)
    private String fantasyName;
    @NotNull
    @ApiModelProperty(required = true)
    private String openingHours;
    @NotNull
    @ApiModelProperty(required = true)
    private Double price;
    private String activities;
    private String teachingMethod;
}
