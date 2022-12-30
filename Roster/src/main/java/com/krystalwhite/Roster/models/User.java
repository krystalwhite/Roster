package com.krystalwhite.Roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Data @Entity
public class User {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Id @GeneratedValue
    private int id;
    @NotBlank(message = "Please enter your name.")
    @NotNull
    private String name;

    @NotBlank(message = "Please enter your email address.")
    @NotNull
    @Email(message = "Please enter a valid email address.")
    private String email;

    private String pwHash;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.pwHash = encoder.encode(password);
    }

    public User(String email, String password) {
        this.email = email;
        this.pwHash = password;
    }

    public User() {
    }

    public boolean isPasswordMatching(String password) {
        return encoder.matches(password, pwHash);
    }

}
