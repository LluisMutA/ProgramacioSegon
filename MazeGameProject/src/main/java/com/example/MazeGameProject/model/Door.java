package com.example.MazeGameProject.model;

public class Door {
    private int id;
    private boolean isOpen;
    private String position;


    public Door(int id, boolean isOpen, String position) {
        this.id = id;
        this.isOpen = isOpen;
        this.position = position;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
