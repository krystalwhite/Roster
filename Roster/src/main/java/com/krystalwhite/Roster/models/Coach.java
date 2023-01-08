package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @EqualsAndHashCode(callSuper = true)
public class Coach extends AbstractPerson{

    //private Team
    //private image image?

    @OneToMany
    @JoinColumn(name="coach_id")
    private List<Player> roster = new ArrayList<>();
    public Coach() {}
    public Coach(String firstName, String lastName, String sport) {
        super();
    }

    public Coach(List<Player> players) {
        this();
        this.roster = players;
    }
}
