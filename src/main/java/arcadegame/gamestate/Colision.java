package arcadegame.gamestate;

import org.lwjgl.opengl.Display;

import arcadegame.entity.Entity;
import arcadegame.entity.Player;

public class Colision {
	
	//Window Boundary
	public static int UPPER_LIMIT;
	private static int RIGHT_SIDE_LIMIT;	
	public static int DOWN_LIMIT = 50;
	private static int LEFT_SIDE_LIMIT = 0;
	
	//"enum" to left,right,up,down
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	
	public Colision(){
		Colision.RIGHT_SIDE_LIMIT = Display.getWidth() - Display.getWidth()/4;
		Colision.UPPER_LIMIT = Display.getHeight();
	}
	
	public boolean checkColision(Entity entity, int direction){
		
		if(direction == LEFT){
			if(entity.getLeftBoundary() >= Colision.LEFT_SIDE_LIMIT)
				return true;
		}		
		if(direction == RIGHT){
			if(entity.getRightBoundary() <= Colision.RIGHT_SIDE_LIMIT)
				return true;			
		}
		if(direction == UP){
			if(entity.getUpperBoundary() <= Colision.UPPER_LIMIT)
				return true;			
		}			
		if(direction == DOWN){		
			if(entity.getBottomBoundary() >= Colision.DOWN_LIMIT)
				return true;			
		}
		return false;
	}
	
	public void checkColision(Player player, Entity entity){
		double playerUp = player.getBottomBoundary() - entity.getUpperBoundary();
		
		if(player.getBottomBoundary() >= entity.getUpperBoundary() && playerUp < 2){
			player.setPosition(player.getPositionX(), entity.getPositionY());
			player.setApplyGravity(false);
			player.setJumping(false);
		}
	}
}
