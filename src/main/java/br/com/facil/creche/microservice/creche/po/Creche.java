package br.com.facil.creche.microservice.creche.po;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "creche")
public class Creche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
