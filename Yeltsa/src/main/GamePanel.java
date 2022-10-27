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
  
  public final int tileSize = originalTileSize * scale;
  public final int maxScreenCol = 16;
  public final int maxScreenRow = 12;
  
  public final int screenWidth = tileSize * maxScreenCol;
  public final int screenHeight = tileSize * maxScreenRow;
  
  public final int maxWorldCol = 59;
  public final int maxWorldRow = 59;
  public final int worldWidth = tileSize * maxWorldCol;
  public final int worldHeight = tileSize * maxWorldRow;
  
  int FPS = 60;
  
  TileManager tileManager = new TileManager(this);
  KeyHandler keyH = new KeyHandler();
  Thread gameThread;
  public CollisionChecker coChecker = new CollisionChecker(this);
  public Player player = new Player(this, this.keyH);

  
  public GamePanel() {
    setPreferredSize(new Dimension(screenWidth, screenHeight));
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
    double delta = 0;
    long lastTime = System.nanoTime();
    long timer = 0;
    int drawCount = 0;
    
    while (this.gameThread != null) {
      long currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      timer += currentTime - lastTime;
      lastTime = currentTime;
      if (delta >= 1) {
        update();
        repaint();
        delta--;
        drawCount++;
      } 
      if (timer >= 1000000000) {
        drawCount = 0;
        timer = 0;
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
