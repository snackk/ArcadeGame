package arcadegame.maps;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import arcadegame.entity.Block;

public class Maps {
	private ArrayList<Block> blocks;
	
	public Maps(){
		this.setBlocks();	
		this.createMap();
	}
	
	private void createMap(){
		addBlock(new Block(500,114));	
		addBlock(new Block(600,200));
	}
	
	public void drawMap(){
		for(Block block: this.getBlocks()){
			block.draw();
		}
	}

	public List<Block> getBlocks() {
		return this.blocks;
	}

	private void setBlocks() {
		this.blocks = new ArrayList<Block>();
	}
	
	private void addBlock(Block block){
		this.getBlocks().add(block);
	}
	
	public void moveBlocks(double acceleration){
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		for(Block i : this.getBlocks()){
			i.setAccelerationX(acceleration);
			i.moveLeft();
		}
	}
}
