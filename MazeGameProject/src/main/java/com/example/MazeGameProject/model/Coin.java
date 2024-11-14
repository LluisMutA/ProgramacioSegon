package com.example.MazeGameProject.model;

public class Coin {
    private int id;
    boolean alreadyPicked;

    public Coin(int id, boolean alreadyPicked) {

        this.id = id;
        this.alreadyPicked = alreadyPicked;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAlreadyPicked() {
        return alreadyPicked;
    }

    public void setAlreadyPicked(boolean alreadyPicked) {
        this.alreadyPicked = alreadyPicked;
    }
}
