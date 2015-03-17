package arcadegame.pt.entity;

import org.lwjgl.opengl.GL11;

public class Block extends Entity{
		
	public Block(int posX, int posY){
		
		super(posX, posY, 0.4, 0);
		
		//Set boundary's for the entity
		this.setBottomBoundary(0);
		this.setLeftBoundary(0);
		this.setUpperBoundary(50);
		this.setRightBoundary(50);
		
		this.setApplyGravity(false);
		
		//Set texture for the block
		this.setTextureLocation("/src/main/java/arcadegame/textures/block/block.png");
		this.setGameTexture();		
	}

	@Override
	public void draw() {
		
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
	    
	    this.drawTexture();
	}
}

