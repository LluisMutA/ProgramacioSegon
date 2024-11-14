package com.example.MazeGameProject.model;

public class Room {
    private boolean hasKey;  // quina clau
    private boolean hasCoin; // valor de la moneda
    private int id;
    private String name;
    private Wall n; // norte, sur, este, oeste -> Si esta abierta (aire) al click
                    // vamos a la siguiente room, si es una pared, no pasa nada (mssge), si es una puerta
                    // mirar si tienes la key, si no la tienes (msge), si la tienes pasa
                    // a ser aire y vas a la habitacion que toca
    private Wall s;
    private Wall e;
    private Wall o;
    private Floor floorOne;
    private Floor floorTwo;
    private int mapId;


    public Room(boolean hasKey, boolean hasCoin, int id, String name, Wall n, Wall s, Wall e, Wall o, Floor floorOne, Floor floorTwo, int mapId) {
        this.hasKey = hasKey;
        this.hasCoin = hasCoin;
        this.id = id;
        this.name = name;
        this.n = n;
        this.s = s;
        this.e = e;
        this.o = o;
        this.floorOne = floorOne;
        this.floorTwo = floorTwo;
        this.mapId = getMapId();
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isHasCoin() {
        return hasCoin;
    }

    public void setHasCoin(boolean hasCoin) {
        this.hasCoin = hasCoin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wall getN() {
        return n;
    }

    public void setN(Wall n) {
        this.n = n;
    }

    public Wall getS() {
        return s;
    }

    public void setS(Wall s) {
        this.s = s;
    }

    public Wall getE() {
        return e;
    }

    public void setE(Wall e) {
        this.e = e;
    }

    public Wall getO() {
        return o;
    }

    public void setO(Wall o) {
        this.o = o;
    }

    public Floor getFloorOne() {
        return floorOne;
    }

    public void setFloorOne(Floor floorOne) {
        this.floorOne = floorOne;
    }

    public Floor getFloorTwo() {
        return floorTwo;
    }

    public void setFloorTwo(Floor floorTwo) {
        this.floorTwo = floorTwo;
    }
    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

}
