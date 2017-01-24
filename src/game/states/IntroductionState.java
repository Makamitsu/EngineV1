package game.states;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.ObjectManager;
import com.engine.core.components.State;
import com.engine.core.fx.Pixel;
import game.intro.IntroBackground;
import game.intro.IntroLogo;

/**
 * This state corresponds to the introduction, with a moving background, a logo
 * and his raycasting light system.
 */
public class IntroductionState extends State {

	public IntroductionState() {
		manager = new ObjectManager();
		manager.addObject(new IntroBackground());
		manager.addObject(new IntroLogo());
	}

	@Override
	public void update(GameContainer gc, float dt) {
		manager.updateObjets(gc, dt);

	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		manager.renderObjects(gc, r);
		r.ambientLight = Pixel.getColor(1, 0.02f, 0.02f, 0.02f);
	}

	@Override
	public void dispose() {
		manager.disposeObjects();
	}

	public ObjectManager getManager() {
		return manager;
	}

	public void setManager(ObjectManager manager) {
		this.manager = manager;
	}

}
