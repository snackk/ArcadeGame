package arcadegame.pt.entity;

import org.newdawn.slick.opengl.Texture;

import arcadegame.pt.texture.GameTexture;

public abstract class Entity {
	
	private double speedX, speedY;
	private double accelerationX, accelerationY;
	private double positionX, positionY;
	private int leftBoundary, rightBoundary, upperBoundary, bottomBoundary;
	private boolean applyGravity;
	
	private GameTexture gameTexture;
	private Texture texture;
	private String textureLocation;
	
	public Entity(double posX, double posY, double speedX, double speedY){
		
		//Set position and speed for all entity
		this.setPosition(posX, posY);
		this.setSpeed(speedX, speedY);
		
		//Set the axis acceleration for all entity
		this.setAccelerationX(1);
		this.setAccelerationY(1);
	}
	
	public abstract void draw();
	
	public final void drawTexture(){
		this.getGameTexture().drawTexture(this.getTexture(), this.getRightBoundary(), this.getUpperBoundary());
	}
	
	public final double getLeftBoundary() {	//add speed??
		return this.leftBoundary + this.getPositionX();
	}

	public final void setLeftBoundary(int leftBoundary) {
		this.leftBoundary = leftBoundary;
	}

	public final double getRightBoundary() {
		return this.rightBoundary + this.getPositionX();
	}

	public final void setRightBoundary(int rightBoundary) {
		this.rightBoundary = rightBoundary;
	}

	public final double getBottomBoundary() {
		return this.bottomBoundary + this.getPositionY();
	}

	public final void setBottomBoundary(int bottomBoundary) {
		this.bottomBoundary = bottomBoundary;
	}

	public final double getUpperBoundary() {
		return this.upperBoundary + this.getPositionY();
	}

	public final void setUpperBoundary(int upperBoundary) {
		this.upperBoundary = upperBoundary;
	}

	public final void setPosition(double x, double y){
		this.positionX = x;
		this.positionY = y;
	}
	
	public final double getPositionX(){
		return this.positionX;
	}
	
	public final double getPositionY(){
		return this.positionY;
	}	
	
	public final void setSpeed(double x, double y){
		this.speedX = x;
		this.speedY = y;
	}
	
	private final double getSpeedX(){
		return this.speedX;
	}

	private final double getSpeedY(){
		return this.speedY;
	}	
	
	private final double getAccelerationY() {
		return accelerationY;
	}

	public final void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}

	private final double getAccelerationX() {
		return accelerationX;
	}

	public final void setAccelerationX(double accelerationX) {
		this.accelerationX = accelerationX;
	}

	public final void moveLeft(){
		this.setPosition(this.getPositionX() - this.getSpeedX()*this.getAccelerationX(), this.getPositionY());
		this.draw();
	}
	
	public final void moveRight(){
		this.setPosition(this.getPositionX() + this.getSpeedX()*this.getAccelerationX(), this.getPositionY());
		this.draw();
	}
	
	public final void moveUp(){
		this.setPosition(this.getPositionX(), this.getPositionY() + this.getSpeedY()*this.getAccelerationY());
		this.draw();
	}
	
	public final void moveDown(){
		this.setPosition(this.getPositionX(), this.getPositionY() - this.getSpeedY()*this.getAccelerationY());
		this.draw();
	}
	
	public final void moveTo(double x, double y){
		this.setPosition(x,y);
		this.draw();
	}

	private final GameTexture getGameTexture() {
		return this.gameTexture;
	}

	public final void setGameTexture() {
		this.gameTexture = new GameTexture();
		this.generateTexture();
	}

	private String getTextureLocation() {
		return textureLocation;
	}

	public void setTextureLocation(String textureLocation) {
		this.textureLocation = textureLocation;
	}

	private Texture getTexture() {
		return this.texture;
	}

	private void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public void generateTexture(){
		this.setTexture(this.getGameTexture().initTexture(getTextureLocation()));
	}

	public boolean getApplyGravity() {
		return this.applyGravity;
	}

	public void setApplyGravity(boolean applyGravity) {
		this.applyGravity = applyGravity;
	}	
}
