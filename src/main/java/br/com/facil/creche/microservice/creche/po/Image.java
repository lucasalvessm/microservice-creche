package br.com.facil.creche.microservice.creche.po;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Data
@Table(name = "IMAGE")
public class Image {

    public Image() {

    }

    public Image(String image) {
        this.imageBase64 = image;
    }

    @Id
    @Column(name = "ID_IMAGE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ID_CRECHE")
    private Long idCreche;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "TX_IMAGE_BASE64", length=16777215)
    private String imageBase64;

}
