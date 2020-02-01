package br.com.facil.creche.microservice.creche.po;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CRECHE")
@SuperBuilder
public class Creche {

    @Id
    @Column(name = "ID_CRECHE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TX_FANTASY_NAME")
    private String fantasyName;

    @Column(name = "TX_OPENING_HOURS")
    private String openingHours;

    @Column(name = "VL_PRICE")
    private Double price;

    @Column(name = "TX_CNPJ")
    private String cnpj;

    @Column(name = "TX_ACTIVITIES")
    private String activities;

    @Column(name = "TX_TEACHING_METHOD")
    private String teachingMethod;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID_ADDRESS")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CRECHE", referencedColumnName = "ID_CRECHE")
    private List<Image> imageList;

    public Creche() {
    }
}
