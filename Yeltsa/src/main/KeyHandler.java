package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
  public boolean upPressed;
  
  public boolean leftPressed;
  
  public boolean downPressed;
  
  public boolean rightPressed;
  
  public void keyTyped(KeyEvent e) {}
  
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    
    if (code == KeyEvent.VK_W)
      this.upPressed = true; 
    
    if (code == KeyEvent.VK_A)
      this.leftPressed = true; 
    
    if (code == KeyEvent.VK_S)
      this.downPressed = true; 
    
    if (code == KeyEvent.VK_D)
      this.rightPressed = true; 
  }
  
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    
    if (code == KeyEvent.VK_W)
      this.upPressed = false; 
    
    if (code == KeyEvent.VK_A)
      this.leftPressed = false; 
    
    if (code == KeyEvent.VK_S)
      this.downPressed = false; 
    
    if (code == KeyEvent.VK_D)
      this.rightPressed = false; 
    
  }
}
