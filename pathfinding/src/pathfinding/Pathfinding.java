package pathfinding;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Pathfinding extends JPanel {

    private int[][] world;
    private int height;
    private int width;

    public void setWorld(int[][] world, int width, int height) {
        this.world = world;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int i;
        int j;

        int w = this.getWidth();
        int h = this.getHeight();
        int dx = (w - 2 * 50) / width;
        int dy = (h - 2 * 50) / height;

        for (i = 0; i<= height - 1; i++) {
            for (j = 0; j <= width - 1; j++) {
                int x0 = 50 + j * dx;
                int y0 = 50 + i * dy;
                if (world[i][j] == -1) {
                    g.setColor(Color.GRAY);
                }
                else if (world[i][j] == 1) {
                    g.setColor(Color.GREEN);
                }
                else if (world[i][j] == 2) {
                    g.setColor(Color.RED);
                }
                else if (world[i][j] == 0) {
                    g.setColor(Color.WHITE);
                }
                else if (world[i][j] == 4) {
                    g.setColor(Color.ORANGE);
                }
                g.fillRect(x0, y0, dx, dy);
            }
        }


        g.setColor(Color.BLACK);
        for (i = 0; i <= width; i++) {
            int x0 = 50 + dx * i;
            int y0 = 50;
            int x1 = x0;
            int y1 = h - 50;
            g.drawLine(x0, y0, x1, y1);
        }
        for (j = 0; j <= height; j++) {
             int x0 = 50;
            int y0 = 50 + dy * j;
            int x1 = w - 50;
            int y1 = y0;
            g.drawLine(x0, y0, x1, y1);
        }

    }
}
