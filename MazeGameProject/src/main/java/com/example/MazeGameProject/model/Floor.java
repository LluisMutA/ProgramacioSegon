package com.example.MazeGameProject.model;

public class Floor {
    private int objectOne;
    private int objectTwo;
    // object = 0; Empty
    // object = 1; Coin
    // object = 2; Key


    public Floor(int objectOne, int objectTwo) {
        this.objectOne = objectOne;
        this.objectTwo = objectTwo;
    }


    public int getObjectOne() {
        return objectOne;
    }

    public void setObjectOne(int objectOne) {
        this.objectOne = objectOne;
    }

    public int getObjectTwo() {
        return objectTwo;
    }

    public void setObjectTwo(int objectTwo) {
        this.objectTwo = objectTwo;
    }
}
