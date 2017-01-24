package game.intro;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.GameObject;
import com.engine.core.fx.Image;

/**
 * The background for the introduction
 */
public class IntroBackground extends GameObject {
	
	private int xPos=0;
	private int yPos=0;
	private Image back;
	private int cpt =0;
	
	public IntroBackground() {
		back = new Image("/intro/tileBack.png");
	}

	@Override
	public void update(GameContainer gc, float dt) {
		cpt += (dt*1000);
		if (cpt > 40){
			xPos --;
			yPos --;
			cpt = cpt%40;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(back,xPos,yPos);
	}

	@Override
	public void componentEvent(String name, GameObject object) {

	}

	@Override
	public void dispose() {

	}

}
