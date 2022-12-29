package com.krystalwhite.Roster.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractPerson {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="A name is required.")
    @Size(min=1, max = 75, message="The maximum character limit is 75.")
    private String name;

    private String sport;
}
