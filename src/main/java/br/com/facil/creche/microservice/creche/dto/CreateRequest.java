package br.com.facil.creche.microservice.creche.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CreateRequest extends Creche {

    public CreateRequest() {
    }
}
