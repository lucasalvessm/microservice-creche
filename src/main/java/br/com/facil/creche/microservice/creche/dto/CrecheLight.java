package br.com.facil.creche.microservice.creche.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
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

    public CrecheLight() {
    }
}
