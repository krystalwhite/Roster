package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity @Data
public class Coach {

    @Id @GeneratedValue
    private int id;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message="Sport is required")
    private String sport;

    public Coach() {}
    public Coach(String firstName, String lastName, String sport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport=sport;
    }
}
