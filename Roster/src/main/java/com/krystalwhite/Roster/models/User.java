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
    private String id;
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Email
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
