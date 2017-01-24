package game.dialog;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.fx.ImageTile;
import game.core.Item;
import game.states.DialogState;

/**
 * An item will be given to the player and drawn in the middle of the screen.
 * The sentence is still here and minimal duration parameter could be precised.
 */
public class DialogStageGiveObject extends DialogStage {

    private Item item;

    private final int xPosItem = 60;
    private final int yPosItem = 235;

    public DialogStageGiveObject(String sentence, int duration, Item item) {
        super(sentence, duration);
        this.item = item;
    }

    public DialogStageGiveObject(String sentence, Item item) {
        super(sentence);
        this.item = item;
    }

    @Override
    public void update(GameContainer gc, float dt, DialogState ds){
        if(!active)
            ds.DialogStageOver();
        timer += 1000*dt;
        if(timer < duration) return;

        if(gc.getInput().isButtonPressed(1)){
            setActive(false);
            ds.DialogStageOverAndGiveItem(item);
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r){
        if(active){
        super.render(gc,r);
        if(item.getModel() instanceof ImageTile)
            r.drawImageTile((ImageTile) item.getModel(),xPosItem,yPosItem,0,0);
        else
            r.drawImage(item.getModel(),xPosItem,yPosItem);
        r.drawString(item.getName()+" as been added!",0xffffffff,xPosItem+item.getWidth()+1,yPosItem+(item.getHeight()/2));
        }
    }

    public void setItem(Item i){
        item = i;
    }

}
