import java.awt.*;

public class MyGame {
    public static  Controller controller;

   static void init(){
        Model m = new Model();
        View v = new View(m);
        controller = new Controller(m, v);
    }

    static void update() {

    }


    static void draw(Graphics g) {
        controller.step(g);
    }
}
