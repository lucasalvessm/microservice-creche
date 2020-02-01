package br.com.facil.creche.microservice.creche.po;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADDRESS")
public class Address {
    @Id
    @Column(name = "ID_ADDRESS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "ID_CRECHE")
    private Long idCreche;

    @Column(name = "TX_ADDRESS")
    private String address;

    @Column(name = "TX_CITY")
    private String city;

    @Column(name = "TX_NEIGHBORHOOD")
    private String neighborhood;
}
