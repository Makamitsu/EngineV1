package game.core;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.fx.Image;
import com.engine.core.fx.ImageTile;
import game.GameState;
import game.dialog.DialogStage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An Item.
 * It will Render his name on mouseOver
 */
public class Item extends VisualGameObject {
    private String name;
    private boolean onTheRoomFloor;

    public Item(float xPox, float yPos, int width, int height, Image model, String name, boolean onTheFloor,HashMap<GameState, ArrayList<DialogStage>> dialogs) {
        super(xPox, yPos, width, height, model, dialogs);
        this.name = name;
        this.onTheRoomFloor = onTheFloor;
    }

    public void setOnTheRoomFloor(boolean onTheRoomFloor) {
        this.onTheRoomFloor = onTheRoomFloor;
    }

    public String getName() {
        return name;
    }


    public boolean isOnTheRoomFloor() {
        return onTheRoomFloor;
    }

    @Override
    public void render(GameContainer gc, Renderer r){
        if (onTheRoomFloor)
            if (gc.getInput().isMouseInArea((int)xPos,(int)yPos,width,height)){
                r.drawString(name,0xffffffff,gc.getInput().getMouseX()+8,gc.getInput().getMouseY());
                r.drawImageTile((ImageTile) model,(int)xPos,(int)yPos,1,0);
            }else
                r.drawImageTile((ImageTile) model,(int)xPos,(int)yPos,0,0);
    }

}
