package br.com.facil.creche.microservice.creche.dto;

import lombok.Data;

@Data
public class Creche extends CrecheLight {

    private String activities;
    private String teachingMethod;
}
