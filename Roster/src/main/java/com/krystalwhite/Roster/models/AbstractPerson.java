package com.krystalwhite.Roster.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@MappedSuperclass @Data
public abstract class AbstractPerson {

    @Id @GeneratedValue
    private int id;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message = "Include a sport.")
    private String sport;


}
