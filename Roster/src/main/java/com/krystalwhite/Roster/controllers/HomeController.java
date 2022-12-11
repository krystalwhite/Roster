package com.krystalwhite.Roster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String renderLandingPage(Model model){
        model.addAttribute("title", "Working Title For the Moment");
        return "index";
    }
}
