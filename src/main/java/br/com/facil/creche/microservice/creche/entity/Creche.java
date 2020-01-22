package br.com.facil.creche.microservice.creche.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Creche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
