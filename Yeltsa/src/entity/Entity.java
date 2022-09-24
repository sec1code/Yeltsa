package entity;

import java.awt.image.BufferedImage;

public class Entity {
  public int worldX;
  
  public int worldY;
  
  public int speed;
  
  public BufferedImage down;
  
  public BufferedImage runDown1;
  
  public BufferedImage runDown2;
  
  public BufferedImage up;
  
  public BufferedImage runUp1;
  
  public BufferedImage runUp2;
  
  public BufferedImage left;
  
  public BufferedImage runLeft1;
  
  public BufferedImage runLeft2;
  
  public BufferedImage right;
  
  public BufferedImage runRight1;
  
  public BufferedImage runRight2;
  
  public String direction;
  
  public boolean standing;
  
  public int spriteCounter = 0;
  
  public int spriteNum = 1;
}
