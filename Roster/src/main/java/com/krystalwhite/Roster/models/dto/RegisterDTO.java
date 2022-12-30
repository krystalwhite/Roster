package com.krystalwhite.Roster.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDTO extends LoginDTO {

    @NotNull
    @NotBlank(message="Please reenter your password exactly.")
    private String verifyPassword;

    @NotBlank(message="Please enter your name.")
    @NotNull
    private String name;

    /*  Complex password requirement
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }*/

}
