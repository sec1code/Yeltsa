package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		//These values get the position of the collision Rectangle from the Entity on the World Map
		//collision Rectangle is the smaller invisible Rectangle in the Entity Sprite, this smaller Rectangle is the one for that collision is checked
		//This smaller Rectangle makes the game smoother and more intuitive
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		//There is only the need to check two tiles, the ones the entity is walking towards
		//int tileNum1, tileNum2;
		
		if(entity.direction.equals("upL")) {
			if(checkUp(entity, entityTopRow, entityLeftCol, entityRightCol, entityTopWorldY) ||
			checkLeft(entity, entityTopRow, entityLeftCol, entityBottomRow, entityLeftWorldX)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("upR")) {
			if(checkUp(entity, entityTopRow, entityLeftCol, entityRightCol, entityTopWorldY) ||
			checkRight(entity, entityTopRow, entityRightCol, entityBottomRow, entityRightWorldX)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("downL")) {
			if(checkDown(entity, entityBottomRow, entityLeftCol, entityRightCol, entityBottomWorldY) ||
			checkLeft(entity, entityTopRow, entityLeftCol, entityBottomRow, entityLeftWorldX)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("downR")) {
			if(checkDown(entity, entityBottomRow, entityLeftCol, entityRightCol, entityBottomWorldY) ||
			checkRight(entity, entityTopRow, entityRightCol, entityBottomRow, entityRightWorldX)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("up")) {
			if(checkUp(entity, entityTopRow, entityLeftCol, entityRightCol, entityTopWorldY)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("left")) {
			if(checkLeft(entity, entityTopRow, entityLeftCol, entityBottomRow, entityLeftWorldX)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("down")) {
			if(checkDown(entity, entityBottomRow, entityLeftCol, entityRightCol, entityBottomWorldY)) {
				entity.collisionOn = true;
			}
		} else if(entity.direction.equals("right")) {
			if(checkRight(entity, entityTopRow, entityRightCol, entityBottomRow, entityRightWorldX)) {
				entity.collisionOn = true;
			}
		}
	}
	
	public boolean checkUp(Entity entity, int entityTopRow, int entityLeftCol, int entityRightCol, int entityTopWorldY) {
		entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
		int tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
		int tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
		
		//return true if player is hitting something, otherwise it return false
		if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
			return true;
		}
		return false;
	}
	
	public boolean checkLeft(Entity entity, int entityTopRow, int entityLeftCol, int entityBottomRow, int entityLeftWorldX) {
		entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
		int tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
		int tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
		
		if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
			return true;
		}
		return false;
	}
	
	public boolean checkDown(Entity entity, int entityBottomRow, int entityLeftCol, int entityRightCol, int entityBottomWorldY) {
		entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
		int tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
		int tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
		
		if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
			return true;
		}
		return false;
	}
	
	public boolean checkRight(Entity entity, int entityTopRow, int entityRightCol, int entityBottomRow, int entityRightWorldX) {
		entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
		int tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
		int tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
		
		if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
			return true;
		}
		return false;
	}
	
}
