package model;

public class Shape {
    String type;
    String x;
    String y;
    String size;
    String fillColor;

    public Shape(String type, String x, String y, String size, String fillColor) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.size = size;
        this.fillColor = fillColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
