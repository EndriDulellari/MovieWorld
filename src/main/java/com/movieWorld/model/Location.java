package com.movieWorld.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String country;
    private String city;
    private String postCode;

}
