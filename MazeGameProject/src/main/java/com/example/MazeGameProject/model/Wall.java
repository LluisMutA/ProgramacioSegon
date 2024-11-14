package com.example.MazeGameProject.model;

public class Wall {
    private int type;   // type = 0; air
                        // type = 1; solid
                        // type = 3; door
    private String position;
    private int id;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
