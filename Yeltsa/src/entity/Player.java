package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
  GamePanel gp;
  
  KeyHandler keyH;
  
  public final int screenX;
  
  public final int screenY;
  
  public Player(GamePanel gp, KeyHandler keyH) {
    this.gp = gp;
    this.keyH = keyH;
    gp.getClass();
    gp.getClass();
    this.screenX = 768 / 2 - 48 / 2;
    gp.getClass();
    gp.getClass();
    this.screenY = 576 / 2 - 48 / 2;
    setDefaultValues();
    getPlayerImage();
  }
  
  public void setDefaultValues() {
    this.gp.getClass();
    this.worldX = 48 * 10;
    this.gp.getClass();
    this.worldY = 48 * 10;
    this.speed = 4;
    this.direction = "down";
    this.standing = true;
  }
  
  public void getPlayerImage() {
    try {
      this.up = ImageIO.read(getClass().getResourceAsStream("/player/Player_Up_1.png"));
      this.left = ImageIO.read(getClass().getResourceAsStream("/player/Player_Left_1.png"));
      this.down = ImageIO.read(getClass().getResourceAsStream("/player/Player_Down_1.png"));
      this.right = ImageIO.read(getClass().getResourceAsStream("/player/Player_Right_1.png"));
      this.runUp1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Up_1.png"));
      this.runUp2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Up_2.png"));
      this.runLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Left_1.png"));
      this.runLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Left_22.png"));
      this.runDown1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Down_1.png"));
      this.runDown2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Down_2.png"));
      this.runRight1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Right_1.png"));
      this.runRight2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Right_22.png"));
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void update() {
    if (this.keyH.upPressed) {
      this.worldY -= this.speed;
      this.standing = false;
      this.direction = "up";
    } else if (this.keyH.leftPressed) {
      this.worldX -= this.speed;
      this.direction = "left";
      this.standing = false;
    } else if (this.keyH.downPressed) {
      this.worldY += this.speed;
      this.direction = "down";
      this.standing = false;
    } else if (this.keyH.rightPressed) {
      this.worldX += this.speed;
      this.standing = false;
      this.direction = "right";
    } else {
      this.standing = true;
    } 
    this.spriteCounter++;
    if (this.spriteCounter > 20) {
      if (this.spriteNum == 1) {
        this.spriteNum = 2;
      } else {
        this.spriteNum = 1;
      } 
      this.spriteCounter = 0;
    } 
  }
  
  public void draw(Graphics2D g2) {
    BufferedImage image = null;
    if (this.standing) {
      String str;
      switch ((str = this.direction).hashCode()) {
        case 3739:
          if (!str.equals("up"))
            break; 
          image = this.up;
          break;
        case 3089570:
          if (!str.equals("down"))
            break; 
          image = this.down;
          break;
        case 3317767:
          if (!str.equals("left"))
            break; 
          image = this.left;
          break;
        case 108511772:
          if (!str.equals("right"))
            break; 
          image = this.right;
          break;
      } 
    } else {
      String str;
      switch ((str = this.direction).hashCode()) {
        case 3739:
          if (!str.equals("up"))
            break; 
          if (this.spriteNum == 1)
            image = this.runUp1; 
          if (this.spriteNum == 2)
            image = this.runUp2; 
          break;
        case 3089570:
          if (!str.equals("down"))
            break; 
          if (this.spriteNum == 1)
            image = this.runDown1; 
          if (this.spriteNum == 2)
            image = this.runDown2; 
          break;
        case 3317767:
          if (!str.equals("left"))
            break; 
          if (this.spriteNum == 1)
            image = this.runLeft1; 
          if (this.spriteNum == 2)
            image = this.runLeft2; 
          break;
        case 108511772:
          if (!str.equals("right"))
            break; 
          if (this.spriteNum == 1)
            image = this.runRight1; 
          if (this.spriteNum == 2)
            image = this.runRight2; 
          break;
      } 
    } 
    this.gp.getClass();
    this.gp.getClass();
    g2.drawImage(image, this.screenX, this.screenY, 48, 48, null);
  }
}
