package de.wit.bibinfo.plattenspieler.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(schema = "PUBLIC", name = "RELEASES")
public class Releases implements Serializable {

    @Column(name = "ARTIST")
    private String artist;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "RELEASEDATE")
    private String releasedate;

    @Column(name = "LENGTH")
    private String length;

    @Column(name = "TRACKS")
    private int tracks;

    @Column(name = "GENRE")
    private String genre;

    @Id
    @Column(name = "CATALOG")
    private String catalog;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "PLAYED")
    private int played;

}