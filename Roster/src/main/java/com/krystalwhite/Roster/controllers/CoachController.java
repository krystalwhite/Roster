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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("coach")
public class CoachController {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "List of Coaches");
        model.addAttribute("coaches", coachRepository.findAll());
        return "coach/index";
    }
    @GetMapping("view/{coachId}")
    public String displaySingleCoach(Model model, @PathVariable int coachId) {
        model.addAttribute("title", "Coach Information");

        Optional optCoach = coachRepository.findById(coachId);
        if (optCoach.isPresent()) {
            Coach coach = (Coach) optCoach.get();
            model.addAttribute("coach", coach);
            return "coach/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("add")
    public String displayAddCoachForm(Model model) {
        model.addAttribute("title", "Add a Coach");
        model.addAttribute(new Coach());
        return "coach/add";
    }

    @PostMapping("add")
    public String processAddCoachForm(@ModelAttribute @Valid Coach newCoach,
                                       Errors errors, Model model, @RequestParam List<Integer> players) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Invalid Entry. Please Try Again.");
            return "coach/add";
        }

        /*
        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        if (skillObjs.isEmpty()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("employers", employerRepository.findAll());
            model.addAttribute("skills", skillRepository.findAll());
            return "add";
        }
        newJob.setSkills(skillObjs);
         */

        List<Player> optPlayers = (List<Player>) playerRepository.findAllById(players);
        if (!optPlayers.isEmpty()) {
            model.addAttribute("roster", optPlayers);
            newCoach.setRoster(optPlayers);
        }

        model.addAttribute("title", "New Coach Added");
        coachRepository.save(newCoach);
        return "index";
    }
}
