package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
  GamePanel gp;
  
  Tile[] tile;
  
  int[][] mapTileNum;
  
  public TileManager(GamePanel gp) {
    this.gp = gp;
    this.tile = new Tile[10];
    gp.getClass();
    gp.getClass();
    this.mapTileNum = new int[44][26];
    getTileImage();
    loadMap("/maps/World001.txt");
  }
  
  public void getTileImage() {
    try {
      this.tile[0] = new Tile();
      (this.tile[0]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_tile.png"));
      this.tile[1] = new Tile();
      (this.tile[1]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_tile.png"));
      this.tile[2] = new Tile();
      (this.tile[2]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_tile.png"));
      this.tile[3] = new Tile();
      (this.tile[3]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/stone_tile.png"));
      this.tile[4] = new Tile();
      (this.tile[4]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_tile.png"));
      this.tile[5] = new Tile();
      (this.tile[5]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/coalore_tile.png"));
      this.tile[6] = new Tile();
      (this.tile[6]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/ironore_tile.png"));
      this.tile[7] = new Tile();
      (this.tile[7]).image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree_tile.png"));
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void loadMap(String filePath) {
    try {
      InputStream is = getClass().getResourceAsStream(filePath);
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      int col = 0;
      int row = 0;
      this.gp.getClass();
      this.gp.getClass();
      while (col < 44 && row < 26) {
        String line = br.readLine();
        this.gp.getClass();
        while (col < 44) {
          String[] numbers = line.split(" ");
          int num = Integer.parseInt(numbers[col]);
          this.mapTileNum[col][row] = num;
          col++;
        } 
        this.gp.getClass();
        if (col == 44) {
          col = 0;
          row++;
        } 
      } 
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void draw(Graphics2D g2) {
    int worldCol = 0;
    int worldRow = 0;
    this.gp.getClass();
    this.gp.getClass();
    while (worldCol < 44 && worldRow < 26) {
      int tileNum = this.mapTileNum[worldCol][worldRow];
      this.gp.getClass();
      int worldX = worldCol * 48;
      this.gp.getClass();
      int worldY = worldRow * 48;
      int screenX = worldX - this.gp.player.worldX + this.gp.player.screenX;
      int screenY = worldY - this.gp.player.worldY + this.gp.player.screenY;
      this.gp.getClass();
      this.gp.getClass();
      this.gp.getClass();
      this.gp.getClass();
      if (worldX + 48 > this.gp.player.worldX - this.gp.player.screenX && worldX - 48 < this.gp.player.worldX + this.gp.player.screenX && worldY + 48 > this.gp.player.worldY - this.gp.player.screenY && worldY - 48 < this.gp.player.worldY + this.gp.player.screenY) {
        this.gp.getClass();
        this.gp.getClass();
        g2.drawImage((this.tile[tileNum]).image, screenX, screenY, 48, 48, null);
      } 
      worldCol++;
      this.gp.getClass();
      if (worldCol == 44) {
        worldCol = 0;
        worldRow++;
      } 
    } 
  }
}
