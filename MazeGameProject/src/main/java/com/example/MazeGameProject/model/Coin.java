package com.example.MazeGameProject.model;

public class Coin {
    private int id;
    private int value;
    boolean alreadyPicked;


    public Coin(int id, int value, boolean alreadyPicked) {
        this.id = id;
        this.value = value;
        this.alreadyPicked = alreadyPicked;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
