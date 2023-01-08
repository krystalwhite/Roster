package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @EqualsAndHashCode(callSuper = true)
public class Coach extends AbstractPerson{

    //private Team
    //private image image?

    public Coach() {}
    public Coach(String firstName, String lastName, String sport) {
        super();
    }
}
