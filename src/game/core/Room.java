package game.core;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.GameObject;
import com.engine.core.components.ObjectManager;
import com.engine.core.fx.Image;

/**
 * A room, it renders and update all his content!
 */
public class Room extends GameObject{

    private int ambientLight = 0xffffffff;
    private Image model;

    private ObjectManager roomContent;

    public Room(Image model) {
        this.xPos = 0;
        this.yPos = 0;
        this.model = model;
    }

    public Room(Image model, ObjectManager roomContent) {
        this.xPos = 0;
        this.yPos = 0;
        this.model = model;
        this.roomContent = roomContent;
    }

    @Override
    public void update(GameContainer gc, float dt) {
        roomContent.updateObjets(gc,dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(model);
        roomContent.renderObjects(gc,r);
    }

    @Override
    public void componentEvent(String name, GameObject object) {

    }

    @Override
    public void dispose() {

    }

    public Image getModel() {
        return model;
    }

    public int getAmbientLight() {
        return ambientLight;
    }

    public void setAmbientLight(int ambientLight) {
        this.ambientLight = ambientLight;
    }

    public ObjectManager getRoomContent() {
        return roomContent;
    }

    public void setRoomContent(ObjectManager roomContent) {
        this.roomContent = roomContent;
    }
}
