package com.krystalwhite.Roster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String renderLandingPage(Model model){
        return "index";
    }
    @GetMapping("/login")
    public String renderLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String renderRegisterPage(Model model) {
        return "register";
    }
}
