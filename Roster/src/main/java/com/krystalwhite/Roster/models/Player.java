package com.krystalwhite.Roster.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Objects;

@Entity @Data
public class Player {

    @Id @GeneratedValue
    private int id;
    @NotBlank(message = "Name is required.")
    private String name;
    @NotBlank(message = "Include a sport.")
    private String sport;

    private String team;

//    private image image;

    public Player() {}
    public Player(String name, String sport) {
        this.name=name;
        this.sport=sport;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSport() {
//        return sport;
//    }
//
//    public void setSport(String sport) {
//        this.sport = sport;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Player player = (Player) o;
//        return id == player.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Player{" +
//                "name='" + name + '\'' +
//                ", sport='" + sport + '\'' +
//                '}';
//    }
}
