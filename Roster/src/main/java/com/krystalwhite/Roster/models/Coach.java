package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
public class Coach {

    @Id @GeneratedValue
    private int id;

    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="Sport is required")
    private String sport;
    private List<Player> players;
    public Coach() {}
    public Coach(String name, String sport) {
        this.name=name;
        this.sport=sport;
    }
    public Coach(String name, String sport, List<Player> players){
        this.name = name;
        this.sport = sport;
        this.players = players;
    }
    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", sport='" + sport + '\'' +
                ", players=" + players +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return id == coach.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
