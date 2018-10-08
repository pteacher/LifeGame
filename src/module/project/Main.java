package module.project;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements Runnable {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int SIZE = 40;
    static int gameField[][] = new int[SIZE][SIZE];
    int pause = 500;

    public Main() {
        setName("Conway's Life Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public static void main(String[] args) {
        fillArray(gameField);
        new Main().run();
    }

    public static void fillArray(int a[][]) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                a[i][j] = (int) Math.round(Math.random());
            }
        }
    }

    public void gameText(String text, int x, int y, int size, Graphics2D g2) {
        Font f = new Font("Arial", Font.BOLD, size);
        g2.setFont(f);
        g2.setColor(Color.RED);
        g2.drawString(text, x, y);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g2.setColor(gameField[i][j] == 0 ? Color.WHITE : Color.BLACK);
                g2.fillRect(i * WIDTH / SIZE, j * HEIGHT / SIZE,
                        WIDTH / SIZE, HEIGHT / SIZE);
            }
        }
        //gameText("GAME OVER", 120, 256, 42, g2);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(pause);
                recalculate();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void recalculate() {
        // Этот пример можно удалить и написать свой код для обработки поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int randValue = (int) (Math.random() * 43);
                if (randValue == 42)
                if (gameField[i][j] == 0) {
                    gameField[i][j] = 1;
                }
                else {
                    gameField[i][j] = 0;
                }
            }
        }
    }
}
