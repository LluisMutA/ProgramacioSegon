import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGame extends JPanel implements ActionListener {
    private Timer timer;
    private final int DELAY = 100; // Frecuencia de actualización (en milisegundos)

    public SimpleGame() {
        // Configuraciones del JPanel y el temporizador del juego
        setFocusable(true);
        setPreferredSize(new Dimension(Model.DIMX, Model.DIMY));
        setBackground(Color.BLACK);
        timer = new Timer(DELAY, this);
        timer.start(); // Inicia el juego
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        MyGame.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyGame.update();
        repaint(); // Vuelve a pintar el panel (actualiza la pantalla)
    }

    public static void main(String[] args) {
        MyGame.init();
        JFrame frame = new JFrame("Simple Game");
        SimpleGame game = new SimpleGame();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setVisible(true);
    }
}

