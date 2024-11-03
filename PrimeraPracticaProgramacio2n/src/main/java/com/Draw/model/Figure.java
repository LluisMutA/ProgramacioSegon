package com.Draw.model;

import java.util.ArrayList;
import java.util.List;

public class Figure {
    private String tipo;
    private double x;
    private double y;
    private int size;
    private List<FreeDrawCoord> fdc = new ArrayList<>();

    @Override
    public String toString() {
        return "Figure{" +
                "tipo='" + tipo + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", size=" + size +
                ", fdc=" + fdc +
                '}';
    }

    public Figure(String tipo, double x, double y, int size, List<FreeDrawCoord> fdc) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.size = size;
        this.fdc = fdc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<FreeDrawCoord> getFdc() {
        return fdc;
    }

    public void setFdc(List<FreeDrawCoord> fdc) {
        this.fdc = fdc;
    }
}
