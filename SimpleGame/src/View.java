import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View  {

    private Model model;

    View(Model m){
        this.model = m;
    }

    public void draw(Graphics g) {
        int dx = Model.DIMX / Model.GX;
        int dy = Model.DIMY / Model.GY;
        for (int i = 0; i < Model.GY; i++) {
            for (int j = 0; j < Model.GX; j++) {
                if (this.model.getCell(i, j)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * dx, i * dy, dx, dy);
                g.setColor(Color.GRAY);
                g.drawRect(j * dx, i * dy, dx, dy);
            }
        }
    }
}
