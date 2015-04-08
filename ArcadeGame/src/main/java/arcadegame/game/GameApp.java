package arcadegame.game;

import arcadegame.gamestate.GameState;


public class GameApp{
	
	private static GameState gamestate;	
	public static String TEXTURE_LOCATION = "src/main/java/arcadegame/textures/";
	
	public static void setGameState(){
		gamestate = GameState.getInstance();
	}
	
	public static GameState getGameState(){
		return gamestate;
	}		
	
	public static void main(String[] args) {
		setGameState();
		getGameState().startGame(); 
	}
}
