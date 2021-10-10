package com.movieWorld.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Movie {

    @Id
    private String id;
    private String name;
    private List<Actor> starring;
    private Company productionCompany;
    private Date releaseDate;
    private int minutesRunningTime;
    private Producer producedBy;
    private List<GeneralDetails> directedBy;
    private List<GeneralDetails> distributedBy;
    private List<GeneralDetails> screenplayBy;
    private Movie basedOnMovie;
    private String country;
    private String language;
    private GeneralDetails cinematography;
    private List<GeneralDetails> editedBy;
    private List<GeneralDetails> musicBy;
    private String plot;
    private String budget;
    private String boxOffice;

    public Movie(String name, List<Actor> starring, Company productionCompany, Date releaseDate, int minutesRunningTime, Producer producedBy,
                 List<GeneralDetails> directedBy, List<GeneralDetails> distributedBy, List<GeneralDetails> screenplayBy, Movie basedOnMovie, String country, String language,
                 GeneralDetails cinematography, List<GeneralDetails> editedBy, List<GeneralDetails> musicBy, String plot, String budget, String boxOffice) {
        this.name = name;
        this.starring = starring;
        this.productionCompany = productionCompany;
        this.releaseDate = releaseDate;
        this.minutesRunningTime = minutesRunningTime;
        this.producedBy = producedBy;
        this.directedBy = directedBy;
        this.distributedBy = distributedBy;
        this.screenplayBy = screenplayBy;
        this.basedOnMovie = basedOnMovie;
        this.country = country;
        this.language = language;
        this.cinematography = cinematography;
        this.editedBy = editedBy;
        this.musicBy = musicBy;
        this.plot = plot;
        this.budget = budget;
        this.boxOffice = boxOffice;
    }
    public Movie(String name, String plot, String budget, String boxOffice) {
        this.name = name;
        this.plot = plot;
        this.budget = budget;
        this.boxOffice = boxOffice;
    }
    public Movie() {

    }
}
