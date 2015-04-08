package arcadegame.entity;
import org.lwjgl.opengl.GL11;

import arcadegame.game.GameApp;

public class Player extends Entity{
	
	public Player(int posX, int posY, double speedX, double speedY){
		
		super(posX, posY, speedX, speedY);
		
		//Set boundary's for the entity
		this.setBottomBoundary(0);
		this.setLeftBoundary(0);
		this.setUpperBoundary(64);
		this.setRightBoundary(64);
		
		this.setApplyGravity(true);
		
		//Set texture for the player
		this.setTextureLocation(GameApp.TEXTURE_LOCATION + "block/block.png");
		this.setGameTexture();
		
		this.draw();
	}
	
	public void jump(){
		setJumping(true);
		getGravity().makeJump();
	}

	@Override
	public void draw() {
		
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);		// Clear the screen and depth buffer
		/*
		GL11.glPushMatrix();
		
			GL11.glTranslatef((float) this.getPositionX(), (float)this.getPositionY(), -1);
			GL11.glColor3f(1.0f,1.0f,1.0f);		//(R,G,B,A)
 
		    GL11.glBegin(GL11.GL_QUADS);
			    GL11.glVertex2f(0,64);
				GL11.glVertex2f(64,64);
				GL11.glVertex2f(64,0);
				GL11.glVertex2f(0,0);
		    GL11.glEnd();
		    
	    GL11.glPopMatrix();
	    */
	    this.drawTexture();
	}
}