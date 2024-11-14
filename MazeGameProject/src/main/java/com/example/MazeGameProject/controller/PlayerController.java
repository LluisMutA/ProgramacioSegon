package com.example.MazeGameProject.controller;


import com.example.MazeGameProject.model.Player;
import com.example.MazeGameProject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @GetMapping("/players")
    public String listPlayers(Model model){
        List<Player> players = playerService.allPlayers();
        model.addAttribute("player", players);
        return "players";
    }

    @PostMapping("/players")
    public String newPlayer(@RequestParam String name, @RequestParam String password){
        playerService.newPlayer(name, password);
        return "player";
    }
}

