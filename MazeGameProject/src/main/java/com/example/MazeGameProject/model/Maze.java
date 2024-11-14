package com.example.MazeGameProject.model;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private int id;
    private List<Room> rooms = new ArrayList<>();

    public Maze(List<Room> rooms, int id) {
        this.rooms = rooms;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
