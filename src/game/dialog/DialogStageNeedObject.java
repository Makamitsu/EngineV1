package game.dialog;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import game.core.Item;
import game.states.DialogState;

import java.util.ArrayList;

/**
 * A dialog where an object is needed
 */
public class DialogStageNeedObject extends DialogStage {

    private Item neededItem;

    public DialogStageNeedObject(String sentence, int duration, boolean capital, Item neededItem) {
        super(sentence, duration, capital);
        this.neededItem = neededItem;
    }

    public DialogStageNeedObject(String sentence, boolean capital, Item neededItem) {
        super(sentence, capital);
        this.neededItem = neededItem;
    }

    public DialogStageNeedObject(String sentence, int duration, Item neededItem) {
        super(sentence, duration);
        this.neededItem = neededItem;
    }

    public DialogStageNeedObject(String sentence, Item neededItem) {
        super(sentence);
        this.neededItem = neededItem;
    }

    @Override
    public void update(GameContainer gc, float dt, DialogState ds) {
        if(!active)
            ds.DialogStageOver();
        timer += 1000*dt;
        if(timer < duration) return;

        if(gc.getInput().isButtonPressed(1))
            if(ds.getGameManager().getPlayer().getInventory().contains(neededItem))
                ds.DialogStageOver();
            else
                ds.DialogStateWrongAnswer();
    }


    @Override
    public void render(GameContainer gc, Renderer r){
        super.render(gc,r);
    }



}
