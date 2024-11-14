package Service;

import db.DrawingDAO;
import db.DrawingDAOInMemory;
import model.Drawing;
import java.util.List;

public class DrawingService {
    DrawingDAO drawingDAO = new DrawingDAOInMemory();

    public List<Drawing> getAllDrawings() {
        List<Drawing> drawings = drawingDAO.getAllDrawings();
        return drawings;
    }
    public void printDrawings(){
        drawingDAO.printDrawsName();
    }
    public void addDraw(Drawing drawing){
        drawingDAO.addDraw(drawing);
    }
}
