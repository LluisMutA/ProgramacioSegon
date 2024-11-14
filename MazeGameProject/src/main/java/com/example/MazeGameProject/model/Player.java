package com.example.MazeGameProject.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String password;
    private int id;
    private int score;
    private int coins;
    private List<Key> keys = new ArrayList<>();
//
//    public Player(String name, String password, int id, int score, int coins, List<Key> keys) {
//        this.name = name;
//        this.password = password;
//        this.id = id;
//        this.score = score;
//        this.coins = coins;
//        this.keys = keys;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }
}
