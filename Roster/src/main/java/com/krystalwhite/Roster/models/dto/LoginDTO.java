package com.krystalwhite.Roster.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {

    @NotNull
    @Email(message="Please enter a valid email address.")
    @NotBlank(message="Please enter your email address.")
    private String email;

    @NotBlank(message="Please enter a unique password.")
    @NotNull
    @Size(min=8, message="Your password must be at least 8 characters long.")
    private String password;

}
