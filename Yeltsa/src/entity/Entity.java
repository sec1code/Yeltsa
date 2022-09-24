package entity;

import java.awt.image.BufferedImage;

public class Entity {
  public int worldX;
  public int worldY;
  public int speed;
  public BufferedImage down, runDown1, runDown2, up, runUp1, runUp2, left, runLeft1, runLeft2, right, runRight1, runRight2;
  public String direction;
  public boolean standing;
  public int spriteCounter = 0;
  public int spriteNum = 1;
}
