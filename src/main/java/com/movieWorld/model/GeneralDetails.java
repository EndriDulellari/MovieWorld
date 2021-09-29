package com.movieWorld.model;

import com.movieWorld.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class GeneralDetails {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Location birthPlace;
    private Gender gender;
    private int age;
    private Date died;
    private int diesAged;

}
