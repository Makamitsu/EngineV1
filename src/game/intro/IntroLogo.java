package game.intro;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.GameObject;
import com.engine.core.fx.Image;
import com.engine.core.fx.Light;
import com.engine.core.fx.ShadowType;
import com.engine.core.fx.SoundClip;
/**
 * This class stores the sound, the logo for the introduction.
 * It also places the light.
 */
public class IntroLogo extends GameObject {
	
	SoundClip introSound;
	Image logo;
	Light spot;
	int xSpot = 200,ySpot = 150;
	int xSpeed = 2,ySpeed = 2;
	
	public IntroLogo() {
		introSound = new SoundClip("/sound/intro.wav");
		introSound.play();
		logo = new Image("/intro/logo_small.png");
		logo.shadowType = ShadowType.FADE;
		spot = new Light(0xffffffff,300);
		tag = "logo";
	}
	

	@Override
	public void update(GameContainer gc, float dt) {

	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(logo);
		if(gc.getInput().isMouseInArea(100,50,200,200)){
            if(gc.getInput().getMouseX() < xSpot)
                xSpot -=  xSpeed;
            if(gc.getInput().getMouseX() > xSpot)
                xSpot +=  xSpeed;
            if(gc.getInput().getMouseY() < ySpot)
                ySpot -=  ySpeed;
            if(gc.getInput().getMouseY() > ySpot)
                ySpot +=  ySpeed;
        }else
        {
            if(200 < xSpot)
                xSpot -=  xSpeed;
            if(200 > xSpot)
                xSpot +=  xSpeed;
            if(150 < ySpot)
                ySpot -=  ySpeed;
            if(150 > ySpot)
                ySpot +=  ySpeed;
        }
		r.drawLight(spot, xSpot, ySpot);

	}

	@Override
	public void componentEvent(String name, GameObject object) {

	}

	@Override
	public void dispose() {

	}

}
