package com.krystalwhite.Roster.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Entity
public class Player extends AbstractPerson {

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
