package com.example.MazeGameProject.repository;

import com.example.MazeGameProject.model.Player;

import java.util.List;

public interface PlayerDAO {

    List<Player> findAll();

    void newPlayer(Player player);
}
