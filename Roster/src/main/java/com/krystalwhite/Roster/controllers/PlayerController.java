package com.krystalwhite.Roster.controllers;

import com.krystalwhite.Roster.data.PlayerRepository;
import com.krystalwhite.Roster.models.Player;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @GetMapping("view/{playerId}")
    public String displaySinglePlayer(Model model, @PathVariable int playerId) {
        model.addAttribute("title", "Player Information");

        Optional optPlayer = playerRepository.findById(playerId);
        if (optPlayer.isPresent()) {
            Player player = (Player) optPlayer.get();
            model.addAttribute("player", player);
            return "player/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("add")
    public String displayAddPlayerForm(Model model) {
        model.addAttribute("title", "Add a Player");
        model.addAttribute(new Player());
        return "player/add";
    }

    @PostMapping("add")
    public String processAddPlayerForm(@ModelAttribute @Valid Player newPlayer,
            Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Invalid Entry. Please Try Again.");
            return "player/add";
        }
        model.addAttribute("title", "New Player Added");
        playerRepository.save(newPlayer);
        return "index";
    }

}
