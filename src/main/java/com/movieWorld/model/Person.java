package com.movieWorld.model;

import com.movieWorld.enums.Gender;

import java.util.Date;

public abstract class Person {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Location birthPlace;
    private Gender gender;
    private int age;
    private Date died;
    private int diesAged;

}
