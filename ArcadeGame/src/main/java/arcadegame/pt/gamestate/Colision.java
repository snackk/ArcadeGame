package arcadegame.pt.gamestate;

import org.lwjgl.opengl.Display;

import arcadegame.pt.entity.Player;

public class Colision {
	
	//Window Boundary
	private static int UPPER_LIMIT;
	private static int RIGHT_SIDE_LIMIT;	
	private static int DOWN_LIMIT = 50;
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
	
	public boolean checkColision(Player player, int direction){
		
		if(direction == LEFT){
			if(player.getLeftBoundary() >= Colision.LEFT_SIDE_LIMIT)
				return true;
		}		
		if(direction == RIGHT){
			if(player.getRightBoundary() <= Colision.RIGHT_SIDE_LIMIT)
				return true;			
		}
		if(direction == UP){
			if(player.getUpperBoundary() <= Colision.UPPER_LIMIT)
				return true;			
		}			
		if(direction == DOWN){		
			if(player.getBottomBoundary() >= Colision.DOWN_LIMIT)
				return true;			
		}
		return false;
	}
}
