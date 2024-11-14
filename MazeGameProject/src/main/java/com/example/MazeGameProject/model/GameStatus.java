package com.example.MazeGameProject.model;


import java.util.ArrayList;
import java.util.List;

public class GameStatus {
    private int playerId;
    private List<Key> playerKeys = new ArrayList<>();
    private int playerCoins;
    private int playerScore;
    private int roomId; // position
    private int mazeId;

    public GameStatus(int playerId, List<Key> playerKeys, int playerCoins, int playerScore, int roomId, int mazeId) {
        this.playerId = playerId;
        this.playerKeys = playerKeys;
        this.playerCoins = playerCoins;
        this.playerScore = playerScore;
        this.roomId = roomId;
        this.mazeId = mazeId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<Key> getPlayerKeys() {
        return playerKeys;
    }

    public void setPlayerKeys(List<Key> playerKeys) {
        this.playerKeys = playerKeys;
    }

    public int getPlayerCoins() {
        return playerCoins;
    }

    public void setPlayerCoins(int playerCoins) {
        this.playerCoins = playerCoins;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMazeId() {
        return mazeId;
    }

    public void setMazeId(int mazeId) {
        this.mazeId = mazeId;
    }
}

