package com.example.MazeGameProject.model;

public class Key {
    private int id;
    private int price;
    boolean alreadyPicked;

    public Key(int id, int price, boolean alreadyPicked) {
        this.id = id;
        this.price = price;
        this.alreadyPicked = alreadyPicked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAlreadyPicked() {
        return alreadyPicked;
    }

    public void setAlreadyPicked(boolean alreadyPicked) {
        this.alreadyPicked = alreadyPicked;
    }
}
