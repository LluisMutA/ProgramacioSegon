package com.example.MazeGameProject.services;

import com.example.MazeGameProject.model.Player;
import com.example.MazeGameProject.repository.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerDAO playerDAO;

    public List<Player> allPlayers(){
        return playerDAO.findAll();
    }

    public void newPlayer(String name, String password) {
        Player player = new Player();
        player.setName(name);
        player.setPassword(password);
        playerDAO.newPlayer(player);
    }
}
