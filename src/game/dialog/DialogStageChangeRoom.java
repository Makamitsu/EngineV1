package game.dialog;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import game.core.Room;
import game.states.DialogState;

/**
 * This extension of DialogStage uses the DialogOverGoRoom from the DialogState
 * to make the player change room.
 */
public class DialogStageChangeRoom extends DialogStage {

    private Room destination;

    @Override
    public void update(GameContainer gc, float dt, DialogState ds){
        if(!active)
            ds.DialogStageOver();
        ds.DialogOverGoRoom(destination);

    }

    @Override
    public void render(GameContainer gc, Renderer r){

    }

    public DialogStageChangeRoom(String sentence, int duration, boolean capital, Room destination) {
        super(sentence, duration, capital);
        this.destination = destination;
    }

    public DialogStageChangeRoom(String sentence, boolean capital, Room destination) {
        super(sentence, capital);
        this.destination = destination;
    }

    public DialogStageChangeRoom(String sentence, int duration, Room destination) {
        super(sentence, duration);
        this.destination = destination;
    }

    public DialogStageChangeRoom(String sentence, Room destination) {
        super(sentence);
        this.destination = destination;
    }
}
