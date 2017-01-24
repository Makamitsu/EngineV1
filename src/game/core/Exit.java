package game.core;

import com.engine.core.fx.Image;
import game.GameState;
import game.dialog.DialogStage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An exit.
 */
public class Exit extends VisualGameObject {

    private Room destination;

    public Exit(float xPox, float yPos, int width, int height, Image model, Room destination,HashMap<GameState, ArrayList<DialogStage>> dialogs) {
        super(xPox, yPos, width, height, model, dialogs);
        this.destination = destination;
    }

    public Room getDestination() {
        return destination;
    }
}
