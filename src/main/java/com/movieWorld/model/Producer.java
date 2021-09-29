package com.movieWorld.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Producer {

    @Id
    private String id;
    private GeneralDetails generalDetails;
    private List<String> areas;
    private List<GeneralDetails> collaborators;
    private List<String> awards;
    private long netWorth;

}
