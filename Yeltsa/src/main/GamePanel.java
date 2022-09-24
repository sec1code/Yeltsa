package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
  final int originalTileSize = 16;
  
  final int scale = 3;
  
  public final int tileSize = 48;
  
  public final int maxScreenCol = 16;
  
  public final int maxScreenRow = 12;
  
  public final int screenWidth = 768;
  
  public final int screenHeight = 576;
  
  public final int maxWorldCol = 44;
  
  public final int maxWorldRow = 26;
  
  public final int worldWidth = 2112;
  
  public final int worldHeight = 1248;
  
  int FPS = 60;
  
  KeyHandler keyH = new KeyHandler();
  
  Thread gameThread;
  
  public Player player = new Player(this, this.keyH);
  
  TileManager tileManager = new TileManager(this);
  
  public GamePanel() {
    setPreferredSize(new Dimension(768, 576));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);
    addKeyListener(this.keyH);
    setFocusable(true);
  }
  
  public void startGameThread() {
    this.gameThread = new Thread(this);
    this.gameThread.start();
  }
  
  public void run() {
    double drawInterval = (1000000000 / this.FPS);
    double delta = 0.0D;
    long lastTime = System.nanoTime();
    long timer = 0L;
    int drawCount = 0;
    while (this.gameThread != null) {
      long currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      timer += currentTime - lastTime;
      lastTime = currentTime;
      if (delta >= 1.0D) {
        update();
        repaint();
        delta--;
        drawCount++;
      } 
      if (timer >= 1000000000L) {
        System.out.println("FPS: " + drawCount);
        drawCount = 0;
        timer = 0L;
      } 
    } 
  }
  
  public void update() {
    this.player.update();
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    this.tileManager.draw(g2);
    this.player.draw(g2);
    g2.dispose();
  }
}
