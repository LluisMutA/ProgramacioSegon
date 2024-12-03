package com.example.MazeGameProject.model;


import java.util.ArrayList;
import java.util.List;

public class GameStatus {
    private int gameStatusId;
    private int playerId;
    private List<itemKey> playerItemKeys = new ArrayList<>();
    private List<Coin> pickedCoins = new ArrayList<>();
    private int playerCoins;
    private int playerScore;
    private int roomId; // position
    private int mazeId;
    private List<Door> doorStatus = new ArrayList<>();

    public GameStatus(int gameStatusId, int playerId, List<itemKey> playerItemKeys, List<Coin> pickedCoins, int playerCoins, int playerScore, int roomId, int mazeId, List<Door> doorStatus) {
        this.gameStatusId = gameStatusId;
        this.playerId = playerId;
        this.playerItemKeys = playerItemKeys;
        this.pickedCoins = pickedCoins;
        this.playerCoins = playerCoins;
        this.playerScore = playerScore;
        this.roomId = roomId;
        this.mazeId = mazeId;
        this.doorStatus = doorStatus;
    }

    public int getGameStatusId() {
        return gameStatusId;
    }

    public void setGameStatusId(int gameStatusId) {
        this.gameStatusId = gameStatusId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<itemKey> getPlayerKeys() {
        return playerItemKeys;
    }

    public void setPlayerKeys(List<itemKey> playerItemKeys) {
        this.playerItemKeys = playerItemKeys;
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

    public List<Coin> getPickedCoins() {
        return pickedCoins;
    }

    public void setPickedCoins(List<Coin> pickedCoins) {
        this.pickedCoins = pickedCoins;
    }

    public List<Door> getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(List<Door> doorStatus) {
        this.doorStatus = doorStatus;
    }
}

