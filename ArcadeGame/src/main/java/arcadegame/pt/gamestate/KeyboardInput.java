package arcadegame.pt.gamestate;

import org.lwjgl.input.Keyboard;


public class KeyboardInput {
	
	public boolean isAKeyDown(){
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
				return true;
			else return false;
	}
	
	public boolean isSKeyDown(){
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
			return true;
		else return false;
	}	
	
	public boolean isDKeyDown(){
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
			return true;
		else return false;
	}		
	
	public boolean isWKeyDown(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
			return true;
		else return false;
	}		
	
	public boolean isSPKeyDown(){
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			return true;
		else return false;
	}		
}
