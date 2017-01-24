package game.dialog;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import game.core.Item;
import game.states.DialogState;

/**
 * A dialog stage is a Unique frame of dialog where the player has
 * to do some action to pass the frame and to go forward.
 * The sentence said by the NPC is stored as sentence.
 */
public class DialogStage {

    /**
     * Number max of chars that could be render on one line.
     */
    protected final int nbCharPerLine = 55;

    /**
     * The attribute capital, here, specify if the DialogStage
     * when displayed will make the game progress.
     */
    protected boolean capital = false;

    /**
     * The dialog stage will only works when it is active.
     */
    protected boolean active = true;

    /**
     * The minimal duration before the player can interract.
     */
    protected int duration = 0;
    protected String sentence;
    protected float timer = 0;

    public DialogStage(String sentence, int duration, boolean capital) {
        this.capital = capital;
        this.sentence = sentence;
        this.duration = duration;
    }

    public DialogStage(String sentence, boolean capital) {
        this.capital = capital;
        this.sentence = sentence;
    }

    public DialogStage(String sentence, int duration) {
        this.sentence = sentence;
        this.duration = duration;
    }

    public DialogStage(String sentence){
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public float getDuration() {
        return duration;
    }


    public void update(GameContainer gc, float dt, DialogState ds) {
        if(isCapital()){
            ds.getGameManager().progressTheGame();
            setNotCapital();
        }


        if(!active)
            ds.DialogStageOver();

        timer += 1000*dt;
        if(timer < duration) return;

        if(gc.getInput().isButtonPressed(1))
            ds.DialogStageOver();
    }

    public void render(GameContainer gc, Renderer r) {
        for (int i = 0;i < (sentence.length()/nbCharPerLine)+1;i++){
            if((i+1)*nbCharPerLine > sentence.length())
                r.drawString(sentence.substring(i*nbCharPerLine,sentence.length()),0xFFFFFFFF,39,180+10*i);
            else
                r.drawString(sentence.substring(i*nbCharPerLine,(i+1)*nbCharPerLine),0xFFFFFFFF,39,180+10*i);
            if(i >= 3) break;
        }

    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public void setNotCapital() {
        this.capital = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Virtual method for the Item setting.
     */
    public void setItem(Item i){}
}
