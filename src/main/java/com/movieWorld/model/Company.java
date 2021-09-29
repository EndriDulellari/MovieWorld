package com.movieWorld.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Company {

    @Id
    private String id;
    private String formerly;
    private String type;
    private String industry;
    private String genre;
    private Date dateFounded;
    private List <GeneralDetails> founders;
    private String headquarters;
    private String areaReserved;
    private List<GeneralDetails> keyPeople;
    private List<String> products;
    private List<String> brands;
    private Company parent;
    private Company divisions;
    private List<Company> subsidiaries;
    private String url;



}
