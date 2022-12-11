package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Player {

    @Id
    @GeneratedValue
    private @Getter int id;

    @NotBlank(message="A name is required.")
    private @Getter @Setter String name;

    private @Getter @Setter String sport;

//    private List<Team> teams;
}
