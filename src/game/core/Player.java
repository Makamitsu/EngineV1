package game.core;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.GameObject;
import com.engine.core.fx.Image;
import com.engine.core.fx.ImageTile;

import java.util.ArrayList;

/**
 * The player just saved his own current room and inventory
 * and render his inventory
 */
public class Player extends GameObject {

    protected ArrayList<Item> inventory;
    protected Room currentRoom;
    protected Image bag;
    private boolean bagOpen = false;

    public Player(Room currentRoom){
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<Item>();
        this.bag = new Image("/sprite/backpack.png");
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(bag);
        if(gc.getInput().isMouseInArea(0,0,60,60)){
            bagOpen = true;
        }

        if(gc.getInput().getMouseY() > 70){
            bagOpen = false;
        }
        if(bagOpen){
            if(inventory.size() == 0)
                r.drawString("empty",0xffffffff,35,5);
            for(int i = 0; i < inventory.size();i++){
                if(gc.getInput().isMouseInArea(35+i*30,5,29,29)){
                    r.drawImageTile((ImageTile) inventory.get(i).getModel(),35+i*30,5,1,0);
                    r.drawString(inventory.get(i).getName(),0xffffffff,gc.getInput().getMouseX()+6,gc.getInput().getMouseY());
                }
                else
                    r.drawImageTile((ImageTile) inventory.get(i).getModel(),35+i*30,5,0,0);
            }
        }

    }

    @Override
    public void componentEvent(String name, GameObject object) {

    }

    @Override
    public void dispose() {

    }


}
