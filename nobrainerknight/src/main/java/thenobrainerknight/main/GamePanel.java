package thenobrainerknight.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; // 16x16
    final int scale = 3; // 16x16 looks very small on a 1080p monitor
    final int tileSize = originalTileSize * scale; // 16x16 gets scaled to 48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    // final int screenWidth = tileSize * maxScreenCol;
    // final int screenHeight = tileSize * maxScreenRow;
    final int screenWidth = 500;
    final int screenHeight = 800;

    int FPS = 120;
    int actualFPS = 0;

    int random = 10;
    int randcoords = 1;
    int randcoords2 = 1;

    Boolean reverse = true;
    Boolean reverse2 = true;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // @Override
    // public void run() {

    // double drawInterval = 1000000000 / FPS;
    // double nextDrawTime = System.nanoTime() + drawInterval;

    // while (gameThread != null) {

    // update();
    // repaint();

    // try {
    // double remainingTime = nextDrawTime - System.nanoTime();
    // remainingTime = remainingTime / 1000000;

    // if (remainingTime < 0) {
    // remainingTime = 0;
    // }

    // Thread.sleep((long) remainingTime);

    // nextDrawTime += drawInterval;
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                actualFPS = drawCount;
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.cyan);

        g2.drawRect(10, 10, 10, 10);

        g2.drawString("FPS: " + String.valueOf(actualFPS), 10, 50);

        makefancy(10, 50, 50, 100, 10, 10, g);

        g2.dispose();
    }

    public void makefancy(int x, int y, int xwidth, int ywidth, int input1, int input2, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int max = 3600;
        int min = 1;
        int max2 = 360;
        int min2 = 1;
        random = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (randcoords > max) {
            reverse = true;
        } else if (randcoords < min) {
            reverse = false;
        }
        if (reverse == true) {
            randcoords -= 1 + Math.floor(randcoords / 250);
        } else if (reverse == false) {
            randcoords += 1 + Math.floor(randcoords / 250);
        }
        if (randcoords2 > max2) {
            reverse2 = true;
        } else if (randcoords2 < min2) {
            reverse2 = false;
        }
        if (reverse2 == true) {
            randcoords2 -= 1 + Math.floor(randcoords2 / 250);
        } else if (reverse2 == false) {
            randcoords2 += 1 + Math.floor(randcoords2 / 250);
        }
        for (int i = 1; i < input2; i++) {
            g2.drawArc(x + i * i, y + i * i, xwidth + i * i, ywidth + i * i, randcoords + i * i, randcoords2 + i * i);
        }
    }
}
