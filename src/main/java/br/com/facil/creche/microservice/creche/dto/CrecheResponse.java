package br.com.facil.creche.microservice.creche.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CrecheResponse extends Creche {
    private Long id;

    public CrecheResponse() {}
}
