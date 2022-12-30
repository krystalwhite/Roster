package com.krystalwhite.Roster.controllers;

import com.krystalwhite.Roster.data.UserRepository;
import com.krystalwhite.Roster.models.User;
import com.krystalwhite.Roster.models.dto.LoginDTO;
import com.krystalwhite.Roster.models.dto.RegisterDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Optional;

@Controller
public class AuthenticationController {

    public static final String userSessionKey = "user";

    @Autowired
    private UserRepository userRepository;
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterDTO registerDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        User existingUser = userRepository.findByEmail(registerDTO.getEmail());

        if (existingUser != null) {
            errors.rejectValue("email", "email.alreadyexists", "A user with that email address already exists");
            model.addAttribute("title", "Register");
            return "register";
        }
        String password = registerDTO.getPassword();

        String verifyPassword = registerDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match.");
            model.addAttribute("title", "Register");
            return "register";
        }

        User newUser = new User(registerDTO.getName(), registerDTO.getEmail(),
                registerDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

    @GetMapping("/login")
    public String renderLoginForm(Model model) {
        model.addAttribute(new LoginDTO());
        model.addAttribute("title", "Login");
        return "login";
    }


    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginDTO loginDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model, User theUser) throws IOException, ScriptException, NoSuchMethodException {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        User user = userRepository.findByEmail(loginDTO.getEmail());

        if (user == null) {
            errors.rejectValue("email", "user.invalid", "The given email address is not registered with this site.");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginDTO.getPassword();

        if (!user.isPasswordMatching(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

        model.addAttribute("logout", "Logout");
        setUserInSession(request.getSession(), user);
        model.addAttribute("loggedInUser", user);

        return "redirect:/";
    }

    @GetMapping("/")
    public String renderIndexPage(Model model, HttpServletRequest request) {
        User theUser = getUserFromSession(request.getSession());
        model.addAttribute("loggedInUser", theUser);
        return "index";
    }
}
