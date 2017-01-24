package game.states;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.GameObject;
import com.engine.core.components.State;
import game.GameManager;
import game.core.Room;
import game.core.VisualGameObject;

/**
 * The phase of gameplay, where the player can interacted with objects.
 */
public class ExplorationState extends State {

    private GameManager gameManager;
    private Room room;

    public ExplorationState(Room room,GameManager gameManager) {
        this.gameManager = gameManager;
        this.room = room;
    }

    @Override
	public void update(GameContainer gc, float dt) {
        gc.setClearScreen(true);
        this.room.update(gc,dt);

        if(gc.getInput().isButtonPressed(1)){
            for (GameObject vgo:room.getRoomContent().getObjects()) {
                if (gc.getInput().isMouseInArea((int)vgo.getX(),(int)vgo.getY(),vgo.getWidth(),vgo.getHeight())){
                    gameManager.dialogRequest(((VisualGameObject)vgo).getDialog(gameManager.getGameProgress()));
                }
            }
        }

	}

	@Override
	public void render(GameContainer gc, Renderer r) {
        r.ambientLight = 0xffffffff;
        this.room.render(gc,r);
	}



	@Override
	public void dispose() {
		this.room.dispose();
	}

    public Room getRoom() {
        return room;
    }
}
