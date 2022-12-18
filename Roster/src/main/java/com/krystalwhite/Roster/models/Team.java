//package com.krystalwhite.Roster.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Team {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotBlank(message="A team name is required.")
//    private String name;
//
//    private List<Player> players = new ArrayList<>();
//
//
//}
