package com.krystalwhite.Roster.controllers;

import com.krystalwhite.Roster.data.PlayerRepository;
import com.krystalwhite.Roster.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "List of Players");
        model.addAttribute("players", playerRepository.findAll());
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
