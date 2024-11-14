package db;

import model.Drawing;

import java.util.List;

public interface DrawingDAO {
    List<Drawing> getAllDrawings ();
    void addDraw (Drawing drawing);
    void deleteDraw(Drawing drawing);
    void printDrawsName();
}
