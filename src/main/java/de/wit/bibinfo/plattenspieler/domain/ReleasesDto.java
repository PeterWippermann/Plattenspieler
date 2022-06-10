package de.wit.bibinfo.plattenspieler.domain;

import lombok.Data;

import java.io.Serializable;


@Data
public class ReleasesDto implements Serializable {

    private String artist;
    private String title;
    private String releasedate;
    private String length;
    private int tracks;
    private String genre;
    private String catalog;
    private String label;
    private int played;

}
