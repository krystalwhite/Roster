package com.krystalwhite.Roster.controllers;

import com.krystalwhite.Roster.data.CoachRepository;
import com.krystalwhite.Roster.data.PlayerRepository;
import com.krystalwhite.Roster.models.Coach;
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

    @Autowired
    private CoachRepository coachRepository;

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
        model.addAttribute("coaches", coachRepository.findAll());
        model.addAttribute(new Player());
        return "player/add";
    }

    @PostMapping("add")
    public String processAddPlayerForm(@ModelAttribute @Valid Player newPlayer,
            Errors errors, Model model, @RequestParam int coachId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Invalid Entry. Please Try Again.");
            model.addAttribute("coaches", coachRepository.findAll());
            return "player/add";
        }
        Optional optCoach = coachRepository.findById(coachId);
        if (optCoach.isPresent()) {
            Coach coach = (Coach) optCoach.get();
            model.addAttribute("coach", coach);
            newPlayer.setCoach(coach);
        }
        playerRepository.save(newPlayer);
        model.addAttribute("title", "New Player Added");
        return "index";
    }

}
