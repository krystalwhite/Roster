package com.krystalwhite.Roster.controllers;

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

    @GetMapping("")
    public String index(Model model) {
        return "player/index";
    }

    @GetMapping("add")
    public String displayAddPlayerForm(Model model) {
        model.addAttribute(new Player());
        return "player/add";
    }

}
