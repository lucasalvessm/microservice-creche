package br.com.facil.creche.microservice.creche.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class CrecheResponse extends Creche {
    private Long id;
    private List<String> images;
    private Address addressInfo;

    public CrecheResponse() {
    }
}
