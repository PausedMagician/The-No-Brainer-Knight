package thenobrainerknight.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

    int FPS = 60;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
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
                System.out.println("FPS:" + drawCount);
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

        g2.dispose();
    }
}
