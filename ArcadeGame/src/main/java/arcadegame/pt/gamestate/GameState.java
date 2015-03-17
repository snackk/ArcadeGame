package arcadegame.pt.gamestate;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import arcadegame.pt.display.GameBackground;
import arcadegame.pt.display.GameDisplay;
import arcadegame.pt.entity.Player;
import arcadegame.pt.maps.Maps;

public class GameState{
	
	private KeyboardInput keyboard;
	private Colision colision;
	private Player player;
	private GameDisplay display;
	private GameBackground background;
	private Maps map;
	private Timer timer;
	
	private void gameInterrupt(){
		
		double instanteAcceleration = getTimer().getTimerDelta();
		getPlayer().setAccelerationX(instanteAcceleration);
		getPlayer().setAccelerationY(instanteAcceleration);
		
		//KEYBOARD INTERRUPT && PLAYER COLISION WITH BOUNDARYS
		
		if(keyboard.isAKeyDown()){
			if(getColision().checkColision(getPlayer(), Colision.LEFT)){
				getPlayer().moveLeft();
			}
		}
		
		if(keyboard.isSKeyDown()){
			if(getColision().checkColision(getPlayer(), Colision.DOWN)){
				getPlayer().moveDown();
			}
		}	
		
		if(keyboard.isDKeyDown()){
			if(getColision().checkColision(getPlayer(), Colision.RIGHT)){		
				getPlayer().moveRight();
			}
			else{
				getMap().moveBlocks(instanteAcceleration);
				getPlayer().draw();
			}
		}	
		
		if(keyboard.isWKeyDown()){
			if(getColision().checkColision(getPlayer(), Colision.UP)){
				getPlayer().moveUp();
			}
		}	
		
		if(keyboard.isSPKeyDown()){
		}
	}
	
	
	private void initializeGameEntitys(){
		
		Mouse.setGrabbed(true);

		//Create display
        setDisplay(new GameDisplay(800, 600));	
        getDisplay().display();						//Display need to be before GameState. GameState needs height and width
        
        //Add background
        setBackground();
        getBackground().drawBackground();
        
		//Add Interaction
		setKeyboard();		
		setColision();
        
        //Add player
        setPlayer(new Player(100, 500, 0.5 , 0.4));	
        
        //Add Map
        setMap();
        
        //Initialize Time
        setTimer();
	}
	
	public void startGame(){
        initializeGameEntitys();
		
    	while(!Display.isCloseRequested()) {
    		
			gameInterrupt();
			getMap().drawMap();
			getBackground().drawBackground();
			
			Display.update();
			Display.sync(120);						
    	}
    	Display.destroy();
	}
	
	private void setDisplay(GameDisplay display){
		this.display = display;
	}

	private GameDisplay getDisplay(){
		return this.display;
	}
	
	private void setPlayer(Player player){
		this.player = player;
	}
	
	private Player getPlayer(){
		return this.player;
	}
	
	private void setKeyboard(){
		this.keyboard = new KeyboardInput();
	}
	
	private void setColision(){
		this.colision = new Colision();
	}
	
	private Colision getColision(){
		return this.colision;
	}

	private GameBackground getBackground() {
		return this.background;
	}

	private void setBackground() {
		this.background = new GameBackground("src/main/java/arcadegame/textures/background/background.png", Display.getWidth(), Display.getHeight());
	}

	private Maps getMap() {
		return this.map;
	}

	private void setMap() {
		this.map = new Maps();
	}
	
	private Timer getTimer() {
		return this.timer;
	}

	private void setTimer() {
		this.timer = new Timer();
	}
}
