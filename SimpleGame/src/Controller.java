import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
    
    private Model model;
    
    private View view;
    
    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public Controller() {
    }

    public void step(Graphics g){
        model.update();
        view.draw(g);
    }
}
