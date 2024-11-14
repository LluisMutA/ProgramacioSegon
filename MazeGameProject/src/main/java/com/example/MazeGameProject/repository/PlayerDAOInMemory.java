package com.example.MazeGameProject.repository;

import com.example.MazeGameProject.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class PlayerDAOInMemory implements PlayerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Player> players =new ArrayList<>();

    static { //TODO: rellenar cual pavo

    }

    @Override
    public List<Player> findAll() {
        return List.of();
    }

    @Override
    public void newPlayer(Player player) {
        jdbcTemplate.update("insert into player (name, password) values (?, ?)",
                player.getName(), player.getPassword());
    }

    public void updatePlayer(Player player){ //TODO: pasarlo al DAO e implementador crear el service y controller
        jdbcTemplate.update("insert into player (score, coins, keys) values (?, ?, ?)",
                player.getScore(), player.getCoins(), player.getKeys());
    }

    public void updateGameState(GameStatus gameStatus){ //TODO: implementar, crear Services y controller

    }
} //Tabla inventario para ir juntando player con objetos (problemas con SQL y listas)
