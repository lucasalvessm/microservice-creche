package br.com.facil.creche.microservice.creche.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CrecheLight {

    @NotNull
    @ApiModelProperty(required = true)
    private String fantasyName;
    @NotNull
    @ApiModelProperty(required = true)
    private String openingHours;
    @NotNull
    @ApiModelProperty(required = true)
    private Double price;
}
