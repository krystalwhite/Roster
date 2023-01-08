package com.krystalwhite.Roster.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @EqualsAndHashCode(callSuper = true)
public class Player extends AbstractPerson {

//    private Team team;

//    private image image;

    public Player() {}
    public Player(String firstName, String lastName, String sport) {
        super();
    }
}
