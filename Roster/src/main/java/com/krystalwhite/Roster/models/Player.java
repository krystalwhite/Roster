package com.krystalwhite.Roster.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @EqualsAndHashCode(callSuper = true)
public class Player extends AbstractPerson {

//    private Team team;

//    private image image;

    @ManyToOne
    private Coach coach;
    public Player() {}
    public Player(String firstName, String lastName, String sport) {
        super();
    }
    public Player(Coach coach) {
        this();
        this.coach = coach;
    }
}
