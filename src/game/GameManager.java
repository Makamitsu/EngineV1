package game;

import com.engine.core.AbstractGame;
import com.engine.core.GameContainer;
import com.engine.core.Renderer;

import game.dialog.DialogStage;
import game.states.*;
import game.core.*;

import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;


@SuppressWarnings("unused")
/**
 * The GameManager class is our main game, it includes the main method
 * and the managing system for the state of the game. The progress made
 * by the player.
 * This class also manager the stack game phase:
 * starting with the IntroductionState
 * then replacing it by the ExplorationState
 * and a DialogState is push over the Exploration state
 * when a dialog is needed.
 * this class also stored the player.
 *
 * This class use the Update and Render method from his Super, the abstract game
 * please notice that these methods are run with a given frequency (GameContainer.framCap)
 */
public class GameManager extends AbstractGame{

    /**
     * This store the current progress of the game, following the states in the
     * GameState enum.
     */
    private GameState gameProgress = GameState.INIT;
    private final int introductionDuration = 8000; //unit=ms // GO BACK TO 8000 !!!!!!!!!!
    private final int transitionDuration = 1500;
    private boolean isGameOver = false;
	private float timer = 0; //unit=ms

    private Player player;
    private Room tower,courtyard,kitchen,banquetHall,stock,throneHall,vestibule,stables;
    private Initialisation init;

    /**
     * All the elements of the game are initialised in this constructor using the
     * Initialisation class.
     *
     * Then the introduction is started.
     */
    public GameManager(){
        init = new Initialisation();
        tower=init.getTower();
        courtyard=init.getCourtyard();
        kitchen=init.getKitchen();
        banquetHall=init.getBanquetHall();
        stock=init.getStock();
        throneHall=init.getThroneHall();
        vestibule=init.getVestibule();
        stables=init.getStables();

        this.player = new Player(tower);

        push(new IntroductionState());
	}

	@Override
	public void update(GameContainer gc, float dt) {
        peek().update(gc, dt);
        timer += dt*1000;

        if (peek() instanceof DialogState)
            gc.setClearScreen(false);
        else
            gc.setClearScreen(true);

        if(peek() instanceof TransitionState)
            if(((TransitionState) peek()).isOver())
                setState(new ExplorationState(((TransitionState) peek()).getDestination(),this));

        if(peek() instanceof IntroductionState && timer > introductionDuration)
            setState(new ExplorationState(tower,this));

        if(gameProgress == GameState.GAMEOVER && !isGameOver)
        {
            isGameOver =true;
            setState(new GameOverState());
        }
        if(gc.getInput().isKeyPressed(VK_F11)){
            progressTheGame();
            System.out.println("game state set to :"+gameProgress);
        }


    }

	@Override
	public void render(GameContainer gc, Renderer r) {
		peek().render(gc, r);
        if (peek() instanceof ExplorationState)
            player.render(gc, r);
	}

    /**
     * A getter for the player
     * @return the player
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * This method is called when an element(exit, NPC...) ask for a change room.
     * It manage the transition phase, with the black fade.
     * @param destination the destination room
     */
    public void changeRoomRequest(Room destination){
        this.pop();
        this.setState(new TransitionState(transitionDuration,player.getCurrentRoom(),destination));
        this.player.setCurrentRoom(destination);
    }

    /**
     * This method push a DialogState over the current explorationState
     * @param dialogs the dialogs that have to be considered
     */
    public void dialogRequest(ArrayList<DialogStage> dialogs){
        this.push(new DialogState(dialogs,this));
    }

    /**
     * This method is called when a dialog is over, and the game has to go back
     * to the exploration phase
     */
    public void dialogOver(){
        if(this.peek() instanceof DialogState)
            pop();
    }

    /**
     * A getter for the current progress in the game
     * @return
     */
    public GameState getGameProgress() {
        return gameProgress;
    }

    /**
     * The main of our project. A new GameContainer is created using this
     * GameManager.
     * The GameContainer class contains all the elements (input manager, renderer...)
     * @param arg
     */
    public static void main(String arg[]){
        GameContainer gc = new GameContainer(new GameManager());

        gc.setWidth(400);
        gc.setHeight(300);
        gc.setScale(2);

        gc.setClearScreen(true);
        gc.setLightEnable(true);
        gc.setDynamicLights(true);
        gc.start();
    }

    /**
     * This function is called when an action has to make the game go forward.
     */
    public void progressTheGame() {
        gameProgress = GameState.values()[this.gameProgress.ordinal()+1];
    }
}