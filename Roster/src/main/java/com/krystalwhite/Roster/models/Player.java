package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Player {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="A name is required.")
    private String name;
}
