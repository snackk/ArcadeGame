package arcadegame.pt.game;

import arcadegame.pt.gamestate.GameState;

public class GameApp{
	
	private static GameState gamestate;	
	
	public static void setGameState(){
		gamestate = new GameState();
	}
	
	public static GameState getGameState(){
		return gamestate;
	}		
	
	public static void main(String[] args) {
		setGameState();
		getGameState().startGame(); 
	}
}
