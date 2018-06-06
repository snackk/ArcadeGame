package arcadegame.texture;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class GameTexture {
	
	public Texture initTexture(String location){
		Texture texture = null;

		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(location));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return texture;
	}
	
	public void drawTexture(Texture texture,double posx, double posy){ 
		//GL11.glEnable(GL11.GL_BLEND);
		texture.bind();

		GL11.glPushMatrix();

			GL11.glTranslatef((float)posx, (float)posy, -1);		//UPPER RIGHT SIDE

			GL11.glPushMatrix();

				GL11.glRotatef(180, 0, 0, -1);

				GL11.glBegin(GL11.GL_QUADS);

				GL11.glTexCoord2d(0,0);
				GL11.glVertex2d(0,0);

				GL11.glTexCoord2d(0, 1);
				GL11.glVertex2d(0,texture.getTextureHeight());

				GL11.glTexCoord2d(1,1);
				GL11.glVertex2d(texture.getTextureWidth(),texture.getTextureHeight());

				GL11.glTexCoord2d(1,0);
				GL11.glVertex2d(texture.getTextureWidth(),0);

				GL11.glEnd();

			GL11.glPopMatrix();
		GL11.glPopMatrix();
		//GL11.glDisable(GL11.GL_BLEND);
	}

}
