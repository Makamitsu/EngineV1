package game.core;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.fx.Image;
import game.GameState;
import game.dialog.DialogStage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A NPC
 */
public class NPC extends VisualGameObject{

    String name;

    public NPC(float xPox, float yPos, int width, int height, Image model, String name, HashMap<GameState, ArrayList<DialogStage>> dialogs) {
        super(xPox, yPos, width, height, model, dialogs);
        this.name = name;
    }

    @Override
    public void render(GameContainer gc, Renderer r){
        super.render(gc,r);
        if (gc.getInput().isMouseInArea((int)xPos,(int)yPos,width,height))
            r.drawString(name,0xffffffff,gc.getInput().getMouseX()+8,gc.getInput().getMouseY());
    }
}
