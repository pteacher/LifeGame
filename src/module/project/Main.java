package module.project;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Main extends Canvas {
    static final int WIDTH = 512;
    static final int HEIGHT = 512;
    static final int SIZE = 8;
    static int gameField[][] = new int[SIZE][SIZE];

    public static void main(String[] args) {
        JFrame window = new JFrame("Conway's Life Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        Canvas canvas = new Main();
        canvas.setSize(WIDTH, HEIGHT);
        window.add(canvas);
        window.setVisible(true);
    }

    public static void fillArray(int a[][]) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                a[i][j] = (int)Math.round(Math.random());
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
//        Font f = new Font("Arial", Font.BOLD, 42);
//        g2.setFont(f);
//        g2.setColor(Color.RED);
//        g2.drawString("GAME OVER", 116, 256);
        fillArray(gameField);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g2.setColor(gameField[i][j] == 0?Color.WHITE:Color.BLACK);
                g2.fillRect(i * WIDTH / SIZE, j * HEIGHT / SIZE,
                            WIDTH / SIZE, HEIGHT / SIZE);
            }
        }
    }
}
