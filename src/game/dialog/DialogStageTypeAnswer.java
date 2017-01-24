package game.dialog;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import game.states.DialogState;

import java.util.ArrayList;

/**
 * A dialog that ask the user an input interaction and manages/checks his answer
 */
public class DialogStageTypeAnswer extends DialogStage {

    /**
     * All the possible solution
     */
    private ArrayList<Answer> answers;

    private InputString inputString;

    private final int xPosInputField = 55;
    private final int yPosInputField = 240;

    public DialogStageTypeAnswer(String dial, int duration, ArrayList<Answer> answers) {
        super(dial,duration);
        this.answers = answers;
        inputString = new InputString("");
    }

    public DialogStageTypeAnswer(String dial, ArrayList<Answer> answers) {
        super(dial);
        this.answers = answers;
        inputString = new InputString("");
    }

    @Override
    public void update(GameContainer gc, float dt, DialogState ds){
        if(!active)
            ds.DialogStageOver();
        timer += 1000*dt;
        if(timer < duration) return;

        inputString.update(gc, dt);
        if(inputString.isOver()){
            if (isGoodAnswer()){
                this.active = false;
                ds.DialogStageOver();
            }
            else
                ds.DialogStateWrongAnswer();
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r){
        if(active){
            super.render(gc,r);

            r.drawString("> "+inputString.getUserInput(),0xffffffff,xPosInputField,yPosInputField);
        }

    }

    /**
     * Check if the string typed by the user match at least one of the string in the
     * possible answers.
     * @return true if user type right answers / false if not
     */
    private boolean isGoodAnswer(){
        String answer = inputString.getUserInput();
        inputString=new InputString("");
        for (Answer ans:answers) {
            if(answer.equals(ans.getAnswer())){
                return true;
            }
        }
        return false;
    }

}
