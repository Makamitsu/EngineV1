package game.core;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.GameObject;
import com.engine.core.fx.Image;
import com.engine.core.fx.ImageTile;
import game.GameState;
import game.dialog.DialogStage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The visualGameObject (vgo) corresponds to anything that has to be
 * rendered,
 * A vgo has is own model, as image or image tile.
 * And dialogs to handle intercation
 */
public class VisualGameObject extends GameObject {

    protected Image model;

    protected HashMap<GameState,ArrayList<DialogStage>> dialogs;

    public VisualGameObject(float xPox, float yPos, int width, int height, Image model, HashMap<GameState, ArrayList<DialogStage>> dialogs) {
        this.xPos = xPox;
        this.yPos = yPos;
        this.model = model;
        this.width = width;
        this.height = height;
        this.dialogs = dialogs;
    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        drawMouseOver(gc, r);
    }

    @Override
    public void componentEvent(String name, GameObject object) {

    }

    @Override
    public void dispose() {

    }

    /**
     * Render the right tile for mouseover animation
     */
    protected void drawMouseOver(GameContainer gc, Renderer r){
        if(model instanceof ImageTile)
            if(gc.getInput().isMouseInArea((int)xPos,(int)yPos,width,height))
                r.drawImageTile((ImageTile) model,(int)xPos,(int)yPos,1,0);
            else r.drawImageTile((ImageTile) model,(int)xPos,(int)yPos,0,0);
        else r.drawImage(model,(int)xPos,(int)yPos);
    }

    public void actionLeftClicked(){

    }

    public ArrayList<DialogStage> getDialog(GameState gameProgess){
        return dialogs.get(gameProgess);
    }

    public Image getModel() {
        return model;
    }
}
