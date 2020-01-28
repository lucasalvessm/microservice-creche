package br.com.facil.creche.microservice.creche.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ListResponse extends CrecheLight {
    private Long id;

    public ListResponse() {
    }
}
