package game.states;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.State;
import com.engine.core.fx.Image;
import game.GameManager;
import game.core.Item;
import game.core.Player;
import game.core.Room;
import game.dialog.*;

import java.util.ArrayList;

/**
 * This manages the Dialog phase with a given dialogs arraylist
 * it will render
 */
public class DialogState extends State {

    private ArrayList<DialogStage> dialogs;
    private int progress=0;

    private Image textArea;

    private boolean wrong = false;
    private boolean over = false;

    private GameManager gameManager;

    public DialogState(ArrayList<DialogStage> dialogs,GameManager gameManager) {
        this.dialogs = dialogs;
        this.gameManager = gameManager;
        this.textArea = new Image("/sprite/textArea.png");
    }

    public ArrayList<DialogStage> getDialogList() {
        return dialogs;
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if(over || progress > dialogs.size()-1){
            gameManager.dialogOver();
        }else
            dialogs.get(progress).update(gc, dt, this);

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        if(over || progress > dialogs.size()-1) {
            over = true;
            return;
        }
        if (!(dialogs.get(progress) instanceof DialogStageChangeRoom))
            r.drawImage(textArea);

        dialogs.get(progress).render(gc, r);
    }

    @Override
    public void dispose() {

    }

    /**
     * used when a user give a wrong answer, it closed the Diolog
     */
    public void DialogStateWrongAnswer(){
        over = true;
        wrong = true;
    }

    /**
     * used when a dialog, have to progress
     */
    public void DialogStageOver(){
        progress++;
        if (progress > dialogs.size() || over){
            over = true;
        }
    }

    /**
     * Semantic
     * @param i given item
     */
    public void DialogStageOverAndGiveItem(Item i){
        DialogStageOver();
        i.setOnTheRoomFloor(false);
        if (!gameManager.getPlayer().getInventory().contains(i))
            gameManager.getPlayer().getInventory().add(i);
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    /**
     * Close the dialog and the change the player of the room
     * @param destination the destination
     */
    public void DialogOverGoRoom(Room destination){
        gameManager.changeRoomRequest(destination);
        over=true;
    }
}
