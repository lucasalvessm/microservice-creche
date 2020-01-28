package br.com.facil.creche.microservice.creche.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateRequest extends Creche {

    @ApiModelProperty(required = true)
    @NotNull
    private Long id;
}
