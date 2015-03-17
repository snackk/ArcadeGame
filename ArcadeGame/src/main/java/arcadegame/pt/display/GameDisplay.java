package arcadegame.pt.display;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class GameDisplay {
	
	private int width,height;
	
	public GameDisplay(int width, int height){
		this.setWidth(width);
		this.setHeight(height);
	}
	
	private void setWidth(int width){
		this.width = width;
	}
	
	private void setHeight(int height){
		this.height = height;
	}
	
	private int getWidth(){
		return this.width;
	}
	
	private int getHeight(){
		return this.height;
	}	
	
    public void display() {
    	
    	try {
    		Display.setTitle("Episode 1 - The Game");
			Display.setDisplayMode(new DisplayMode(this.getWidth(),this.getHeight()));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
    	
    	//Textures
    	GL11.glEnable(GL11.GL_TEXTURE_2D); 
    	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    	
    	GL11.glShadeModel(GL11.GL_SMOOTH);
    	GL11.glEnable(GL11.GL_DEPTH_TEST);
    	//GL11.glEnable(GL11.GL_LIGHTING); 
    	
    	GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);  
    	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
    	
    	GL11.glViewport(0, 0, this.getWidth(), this.getHeight()); 	
    	GL11.glMatrixMode(GL11.GL_PROJECTION);
    	GL11.glLoadIdentity();
    	
    	GL11.glOrtho(0, this.getWidth(), 0, this.getHeight(), 1, -1);
    	GL11.glMatrixMode(GL11.GL_MODELVIEW);
    	GL11.glLoadIdentity();
    }    
}