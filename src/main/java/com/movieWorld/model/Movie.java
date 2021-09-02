package com.movieWorld.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Movie {

    private String name;
    private List<Actor> starring;
    private Company productionCompany;
    private Date releaseDate;
    private int minutesRunningTime;
    private Producer producedBy;
    private List<Person> directedBy;
    private List<Person> distributedBy;
    private List<Person> screenplayBy;
    private Movie basedOnMovie;
    private String country;
    private String language;
    private Person cinematography;
    private List<Person> editedBy;
    private List<Person> musicBy;
    private String plot;
    private String budget;
    private String boxOffice;

}
