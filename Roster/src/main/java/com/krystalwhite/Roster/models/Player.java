package com.krystalwhite.Roster.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity @Data
public class Player {

    @Id @GeneratedValue
    private int id;
    @NotBlank(message = "First name is required.")
    private String firstName;
    @NotBlank(message = "Last name is required.")
    private String lastName;
    @NotBlank(message = "Include a sport.")
    private String sport;

//    private String team;

//    private image image;

    public Player() {}
    public Player(String firstName, String lastName, String sport) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.sport=sport;
    }
}
