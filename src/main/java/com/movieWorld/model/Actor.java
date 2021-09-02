package com.movieWorld.model;

import lombok.Data;

@Data
public class Actor extends Person{

    private Location currentLocation;
    private long netWorth;
}
