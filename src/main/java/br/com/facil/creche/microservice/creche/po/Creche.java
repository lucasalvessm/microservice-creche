package br.com.facil.creche.microservice.creche.po;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "creche")
public class Creche {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TX_FANTASY_NAME")
    private String fantasyName;

    @Column(name = "TX_OPENING_HOURS")
    private String openingHours;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "ACTIVITIES")
    private String activities;

    @Column(name = "TEACHING_METHOD")
    private String teachingMethod;
}
