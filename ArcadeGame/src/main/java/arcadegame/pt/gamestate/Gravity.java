package arcadegame.pt.gamestate;

import arcadegame.pt.entity.Entity;

public class Gravity {
	private Timer gravityDelta;
	private Timer jumpDelta;
	private double downCounter;
	private double upCounter;	
	private Entity entity;

	public Gravity(Entity entityRe){
		setDelta();
		setEntity(entityRe);
		resetDownCounter();
		resetUpCounter();
	}
	
	private void setEntity(Entity entityRe){
		this.entity = entityRe;
	}
	
	private Entity getEntity(){
		return this.entity;
	}
	
	private Timer getGravityDelta() {
		return this.gravityDelta;
	}
	
	private Timer getJumpDelta() {
		return this.jumpDelta;
	}

	private void setDelta() {
		this.gravityDelta = new Timer();
		this.jumpDelta = new Timer();
	}
	
	private double getDownCouter(){
		return this.downCounter;
	}
	
	private void resetDownCounter(){
		this.downCounter = 0;
	}

	private double getUpCounter() {
		return this.upCounter;
	}

	private void resetUpCounter() {
		this.upCounter = 70;
	}
	
	public void applygravity(){
		double deltaTime = getGravityDelta().getTimerDelta();
		downCounter += deltaTime;
		double accel = (getDownCouter()/49);
		
		if(!(getEntity().getPositionY() - getEntity().getSpeedY()*accel >= Colision.DOWN_LIMIT)){
			resetDownCounter();
			getEntity().setApplyGravity(false);
			getEntity().setPosition(entity.getPositionX(), Colision.DOWN_LIMIT);		//When entity is close to DOWN_LIMIT, force it to be the DOWN_LIMIT
			getEntity().draw();
		}
		
		if(getEntity().getApplyGravity()){
			getEntity().setAccelerationY(accel);
			getEntity().moveDown();
		}
	}
	
	public void makeJump(){
		double deltaTime = getJumpDelta().getTimerDelta();
		upCounter -= deltaTime;
		double accel = (getUpCounter());
		
		if(getUpCounter() < 1){
			resetUpCounter();
			getEntity().setApplyGravity(true);
			getEntity().setJumping(false);
		}else{
			
			if(!getEntity().getApplyGravity()){
				getEntity().setAccelerationY(accel);
				getEntity().moveUp();
			}
		}
	}
}
