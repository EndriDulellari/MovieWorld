package com.movieWorld.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Actor {

    @Id
    private String id;
    private GeneralDetails generalDetails;
    private Location currentLocation;
    private long netWorth;

    public Actor(GeneralDetails generalDetails, Location currentLocation, long netWorth) {
        this.generalDetails = generalDetails;
        this.currentLocation = currentLocation;
        this.netWorth = netWorth;
    }
}
