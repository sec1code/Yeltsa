package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
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
    screenX = gp.screenWidth / 2 - gp.tileSize / 2;
    screenY = gp.screenHeight / 2 - gp.tileSize / 2;
    
    //original values 5, 8, 6, 4
    //THE ORIGINAL VALUES ARE NOT TRUE
    solidArea = new Rectangle(15, 35, 18, 12);
    
    setDefaultValues();
    getPlayerImage();
  }
  
  public void setDefaultValues() {
	//Spawn coordinates
    worldX = gp.tileSize * 5;
    worldY = gp.tileSize * 5;
    
    speed = 4;
    direction = "down";
    standing = true;
  }
  
  public void getPlayerImage() {
    try {
      up = ImageIO.read(getClass().getResourceAsStream("/player/Player_Up_1.png"));
      left = ImageIO.read(getClass().getResourceAsStream("/player/Player_Left_1.png"));
      down = ImageIO.read(getClass().getResourceAsStream("/player/Player_Down_1.png"));
      right = ImageIO.read(getClass().getResourceAsStream("/player/Player_Right_1.png"));
      runUp1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Up_1.png"));
      runUp2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Up_2.png"));
      runLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Left_1.png"));
      runLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Left_22.png"));
      runDown1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Down_1.png"));
      runDown2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Down_2.png"));
      runRight1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Right_1.png"));
      runRight2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Run_Right_22.png"));
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void update() {
	//Set Speed
	speed = 4;
	
	standing = false;
	
	//Set Direction
	if(keyH.upPressed && keyH.leftPressed) {
		direction = "upL";
	} else if(keyH.upPressed && keyH.rightPressed) {
		direction = "upR";
	} else if(keyH.downPressed && keyH.leftPressed) {
		direction = "downL";
	} else if(keyH.downPressed && keyH.rightPressed) {
		direction = "downR";
	} else if(keyH.upPressed) {
		direction = "up";
    } else if(keyH.leftPressed) {
    	direction = "left";
    } else if(keyH.downPressed) {
    	direction = "down";
    } else if(keyH.rightPressed) {
    	direction = "right";
    } else {
      standing = true;
    }
	
	//Check Collision
	collisionOn = false;
	gp.coChecker.checkTile(this);
	
	//Only if player isn't hitting something, player moves.
	if(collisionOn == false && standing == false) {
		if(direction.equals("upL")) {
			updateUpL();
		} else if(direction.equals("upR")) {
			updateUpR();
		} else if(direction.equals("downL")) {
			updateDownL();
		} else if(direction.equals("downR")) {
			updateDownR();
		} else if(direction.equals("up")) {
			updateUp();
		} else if(direction.equals("left")) {
	    	updateLeft();
		} else if(direction.equals("down")) {
	    	updateDown();
		} else if(direction.equals("right")) {
		      updateRight();
		}
	}
    
    spriteCounter++;
    if (spriteCounter > 20) {
      if (spriteNum == 1) {
        spriteNum = 2;
      } else {
        spriteNum = 1;
      } 
      spriteCounter = 0;
    } 
  }
  
  private void updateUp() {
      worldY -= speed;
      standing = false;
  }
  
  private void updateLeft() {
      worldX -= speed;
      standing = false;
  }
  
  private void updateDown() {
      worldY += speed;
      standing = false;
  }
  
  private void updateRight() {
      worldX += speed;
      standing = false;
  }
  
  //Speed adjustment is made, so that you ain't moving too fast if going diagonal.
  private void updateUpL() {
	  speed *= 0.7571;
	  updateUp();
	  updateLeft();
  }
  
  private void updateUpR() {
	  speed *= 0.7571;
	  updateUp();
	  updateRight();
  }
  
  private void updateDownL() {
	  speed *= 0.7571;
	  updateDown();
	  updateLeft();
  }
  
  private void updateDownR() {
	  speed *= 0.7571;
	  updateDown();
	  updateRight();
  }
  
  
  public void draw(Graphics2D g2) {
    BufferedImage image = down;
    
    if (standing) {
      switch (direction) {
        case "up":
          image = up;
          break;
        case "down": 
          image = down;
          break;
        case "left":; 
          image = left;
          break;
        case "right":
          image = right;
          break;
      } 
    } else { //made and if else statement instead of switch, because its less lines of code and easier with the diagonal movement
    	if(direction.equals("up") || direction.equals("upL") || direction.equals("upR")) {
    		image =drawUp(image);
    	} if(direction.equals("left")) {
    		image = drawLeft(image);
    	} if(direction.equals("down") || direction.equals("downL") || direction.equals("downR")) {
    		image = drawDown(image);
    	} if(direction.equals("right")) {
    		image = drawRight(image);
    	}
    } 

    g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
  }
  
  private BufferedImage drawUp(BufferedImage image) {
      if (spriteNum == 1) {
          image = runUp1; 
      } else if (spriteNum == 2) {
          image = runUp2; 
      }
      return image;
  }
  
  private BufferedImage drawLeft(BufferedImage image) {
      if (spriteNum == 1) {
          image = runLeft1; 
      } else if (spriteNum == 2) {
          image = runLeft2; 
      }
      return image;
  }
  
  private BufferedImage drawDown(BufferedImage image) {
      if (spriteNum == 1) {
          image = runDown1; 
      } else if (spriteNum == 2) {
          image = runDown2; 
      }
      return image;
  }
  
  private BufferedImage drawRight(BufferedImage image) {
      if (spriteNum == 1) {
          image = runRight1; 
      } else if (spriteNum == 2) {
          image = runRight2; 
      }
      return image;
  }
}
