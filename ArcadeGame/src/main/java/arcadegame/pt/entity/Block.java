package arcadegame.pt.entity;

import org.lwjgl.opengl.GL11;

import arcadegame.pt.game.GameApp;

public class Block extends Entity{
		
	public Block(int posX, int posY){
		
		super(posX, posY, 0.4, 0);
		
		//Set boundary's for the entity
		this.setBottomBoundary(0);
		this.setLeftBoundary(0);
		this.setUpperBoundary(64);
		this.setRightBoundary(64);
		
		this.setApplyGravity(false);
		
		//Set texture for the block
		this.setTextureLocation(GameApp.TEXTURE_LOCATION + "block/block.png");
		this.setGameTexture();
	}

	@Override
	public void draw() {
		
		//GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
	   // GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);		// Clear the screen and depth buffer
	    /*
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
		GL11.glPushMatrix();
		
			GL11.glTranslatef((float) this.getPositionX(), (float)this.getPositionY(), 0);
			GL11.glColor3f(1.0f,1.0f,1.0f);		//(R,G,B,A)
 
		    GL11.glBegin(GL11.GL_QUADS);
			    GL11.glVertex2f(0,50);
				GL11.glVertex2f(50,50);
				GL11.glVertex2f(50,0);
				GL11.glVertex2f(0,0);
		    GL11.glEnd();
		    
	    GL11.glPopMatrix();
	    */
	    this.drawTexture();
	}
}

