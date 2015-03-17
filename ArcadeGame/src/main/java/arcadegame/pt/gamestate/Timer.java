package arcadegame.pt.gamestate;

import org.lwjgl.Sys;

public class Timer {
	private long lastFrame;
	
	public Timer(){
		this.setLastFrame(this.getTime());
	}
	
	private void setLastFrame(long frame){
		this.lastFrame = frame;
	}
	
	private long getLastFrame(){
		return this.lastFrame;
	}
	
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public double getTimerDelta() {
		double delta = (double) getTime() - (double) getLastFrame();
		setLastFrame(getTime());
		return delta;
	}
}
