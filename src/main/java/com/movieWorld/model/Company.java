package com.movieWorld.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Company {

    private String formerly;
    private String type;
    private String industry;
    private String genre;
    private Date dateFounded;
    private List <Person> founders;
    private String headquarters;
    private String areaReserved;
    private List<Person> keyPeople;
    private List<String> products;
    private List<String> brands;
    private Company parent;
    private Company divisions;
    private List<Company> subsidiaries;
    private String url;



}
