package com.krystalwhite.Roster.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
}
