import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Model extends Controller {
    static final int DIMX = 400;
    static final int DIMY = 400;

    static final int GX = 100;
    static final int GY = 100;

    private boolean[][] grid = new boolean[GY][GX];

    public boolean getCell(int row, int col){
        return grid[row][col];
    }

    Model() {
        for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = Math.random() < 0.5;
                }
            }
    }

    public void update() {
        // Cualquier célula viva con dos o tres vecinos vivos sobrevive.
        // Cualquier célula muerta con tres vecinos vivos se convierte en una célula viva.

        boolean[][] newGrid = new boolean[GY][GX];
        for (int i = 0; i < GY; i++) {
            for (int j = 0; j < GX; j++) {
                int nneighs = calcNeighs(i, j);
                boolean current = grid[i][j];
                if ((nneighs == 2 || nneighs == 3) && current)
                    newGrid[i][j] = true;
                if ((nneighs == 3 && !current))
                    newGrid[i][j] = true;
            }
        }
        grid = newGrid;
    }

    private int calcNeighs(int row, int col) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r < 0 || c < 0 || r >= GY || c >= GX) continue;
                if (grid[r][c]) count++;
            }
        }
        return count;
    }
    class Cell {
        boolean alive;
        int nneighs;
    }
}
