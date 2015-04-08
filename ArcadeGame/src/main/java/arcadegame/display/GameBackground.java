package arcadegame.display;

import org.newdawn.slick.opengl.Texture;

import arcadegame.texture.GameTexture;

public class GameBackground {
	
	private String backgroundLocation;
	private GameTexture texture;
	private Texture background;
	private double posX, posY;
	
	public GameBackground(String background, double posx, double posy){
		this.setBackgroundLocation(background);
		this.setTexture();
		this.setBackground();
		this.setPosX(posx);
		this.setPosY(posy);
	}
	
	private String getBackgroundLocation() {
		return this.backgroundLocation;
	}

	private void setBackgroundLocation(String backgroundLocation) {
		this.backgroundLocation = backgroundLocation;
	}

	private GameTexture getTexture() {
		return this.texture;
	}
	
	private void setTexture(){
		this.texture = new GameTexture();
	}
	
	public void drawBackground(){
		this.getTexture().drawTexture(this.getBackground(), this.getPosX(), this.getPosY());
	}

	private Texture getBackground() {
		return this.background;
	}

	private void setBackground() {
		this.background = this.getTexture().initTexture(this.getBackgroundLocation());
	}

	private double getPosX() {
		return this.posX;
	}

	private void setPosX(double posX) {
		this.posX = posX;
	}

	private double getPosY() {
		return this.posY;
	}

	private void setPosY(double posY) {
		this.posY = posY;
	}
}
