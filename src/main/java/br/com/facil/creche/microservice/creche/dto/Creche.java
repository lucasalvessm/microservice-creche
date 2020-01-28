package br.com.facil.creche.microservice.creche.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Creche extends CrecheLight {

    private String activities;
    private String teachingMethod;

    public Creche() {
    }
}
