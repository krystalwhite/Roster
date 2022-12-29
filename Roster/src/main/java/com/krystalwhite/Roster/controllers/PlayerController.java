package com.krystalwhite.Roster.controllers;

import com.krystalwhite.Roster.models.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("player")
public class PlayerController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "List of Players");
        return "player/index";
    }
    @GetMapping("view")
    public String displaySinglePlayer(Model model) {
        model.addAttribute("title", "Player Information");
        return "player/view";
    }

    @GetMapping("add")
    public String displayAddPlayerForm(Model model) {
        model.addAttribute(new Player());
        model.addAttribute("title", "Add a Player");
        return "player/add";
    }

}
