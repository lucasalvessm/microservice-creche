package br.com.facil.creche.microservice.creche.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
public class UpdateRequest extends Creche {

    @ApiModelProperty(required = true)
    @NotNull
    private Long id;

    public UpdateRequest() {
    }
}
