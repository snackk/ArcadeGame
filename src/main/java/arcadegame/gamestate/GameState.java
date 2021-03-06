package arcadegame.gamestate;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import arcadegame.display.GameBackground;
import arcadegame.display.GameDisplay;
import arcadegame.entity.Block;
import arcadegame.entity.Player;
import arcadegame.game.GameApp;
import arcadegame.maps.Maps;

public class GameState{
	
	private KeyboardInput keyboard;
	private Colision colision;
	private Player player;
	private GameDisplay display;
	private GameBackground background;
	private Maps map;
	private Timer timer;
	
	  private static GameState gameStateInstance = null;
	  
	   protected GameState() {

	   }
	   
	   public static GameState getInstance() {
	      if(gameStateInstance == null) {
	    	  gameStateInstance = new GameState();
	      }
	      return gameStateInstance;
	   }
	
	private void gameInterrupt(){
		
		//IF PLAYER IS JUMPING LET HIM FINISH 
		if(getPlayer().isJumping()){
			getPlayer().getGravity().makeJump();
		}
		
		//CASE FPS DROP PLAYER MOVES THE SAME 
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
			getPlayer().jump();
		}
		
		//PLAYER COLISION WITH BOUNDARYS CAUSED BY PHYSICS
		if(!getColision().checkColision(getPlayer(), Colision.DOWN)){
			getPlayer().setApplyGravity(false);
		}
		
		//CHECK MAP COLISION
		for(Block b : getMap().getBlocks()){
			getColision().checkColision(getPlayer(), b);
		}
	}
	
	
	private void initializeGameEntities(){
		
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
        initializeGameEntities();
		
    	while(!Display.isCloseRequested()) {
			gameInterrupt();
			
			handleGravity();
			
			handleDraw();

			Display.update();
			Display.sync(120);						
    	}
    	Display.destroy();
	}
	
	private void handleGravity(){
		getPlayer().getGravity().applygravity();
	}
	
	private void handleDraw(){
		getMap().drawMap();
		getBackground().drawBackground();
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
		this.background = new GameBackground(GameApp.TEXTURE_LOCATION + "background/background.png", Display.getWidth(), Display.getHeight());
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
