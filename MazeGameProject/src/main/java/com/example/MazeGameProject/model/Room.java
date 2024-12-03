package com.example.MazeGameProject.model;

public class Room {
    private boolean hasKey;  // quina clau
    private boolean hasCoin; // valor de la moneda
    private int id;
    private String name;
    private Walls n; // norte, sur, este, oeste -> Si esta abierta (aire) al click
                    // vamos a la siguiente room, si es una pared, no pasa nada (mssge), si es una puerta
                    // mirar si tienes la key, si no la tienes (msge), si la tienes pasa
                    // a ser aire y vas a la habitacion que toca
    private Walls s;
    private Walls e;
    private Walls o;
    private int mazeId;


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

    public Walls getN() {
        return n;
    }

    public void setN(Walls n) {
        this.n = n;
    }

    public Walls getS() {
        return s;
    }

    public void setS(Walls s) {
        this.s = s;
    }

    public Walls getE() {
        return e;
    }

    public void setE(Walls e) {
        this.e = e;
    }

    public Walls getO() {
        return o;
    }

    public void setO(Walls o) {
        this.o = o;
    }

    public int getMazeId() {
        return mazeId;
    }

    public void setMazeId(int mazeId) {
        this.mazeId = mazeId;
    }

}
