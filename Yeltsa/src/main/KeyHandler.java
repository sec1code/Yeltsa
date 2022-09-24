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
    if (code == 87)
      this.upPressed = true; 
    if (code == 65)
      this.leftPressed = true; 
    if (code == 83)
      this.downPressed = true; 
    if (code == 68)
      this.rightPressed = true; 
  }
  
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == 87)
      this.upPressed = false; 
    if (code == 65)
      this.leftPressed = false; 
    if (code == 83)
      this.downPressed = false; 
    if (code == 68)
      this.rightPressed = false; 
  }
}
