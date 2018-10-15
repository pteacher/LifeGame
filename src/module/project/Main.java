package module.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements Runnable {
//    static final int WIDTH = 800;
//    static final int HEIGHT = 800;
    static final int SIZE = 100;
    static int gameField[][] = new int[SIZE][SIZE];

    int pause = 500;

    public Main() {
        setName("Conway's Life Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setUndecorated(true);
        pack();
        setVisible(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });

    }

    public static void main(String[] args) {
        fillArray(gameField);
        new Main();
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


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.setColor(gameField[i][j] == 0 ? Color.WHITE : Color.BLACK);
                g.fillRect(i * getWidth() / SIZE, j * getHeight() / SIZE,
                        getWidth() / SIZE, getHeight() / SIZE);
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
