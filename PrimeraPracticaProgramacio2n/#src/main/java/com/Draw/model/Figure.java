package com.Draw.model;

import java.util.ArrayList;
import java.util.List;

public class Figure {
    private String tipo;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private List<FreeDrawCoord> drawPath = new ArrayList<>();
    private String strokeColor;
    private String fillColor;

    public Figure(String tipo, double startX, double startY, double endX, double endY, List<FreeDrawCoord> drawPath, String strokeColor, String fillColor) {
        this.tipo = tipo;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.drawPath = drawPath;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "tipo='" + tipo + '\'' +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", fdc=" + drawPath +
                ", strokeColor='" + strokeColor + '\'' +
                ", fillColor='" + fillColor + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public List<FreeDrawCoord> getDrawPath() {
        return drawPath;
    }

    public void setDrawPath(List<FreeDrawCoord> drawPath) {
        this.drawPath = drawPath;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
