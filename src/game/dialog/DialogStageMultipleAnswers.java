package game.dialog;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import game.states.DialogState;

import java.util.ArrayList;

/**
 * A dialog where the player has to select one of the propose.
 */
public class DialogStageMultipleAnswers extends DialogStage {
    private ArrayList<Answer> answers;

    private final int xPosClickAns = 55;
    private final int yPosClickAns = 230;
    private final int spacementClickAns = 14;


    public DialogStageMultipleAnswers(String sentence, ArrayList<Answer> answers) {
        super(sentence);
        this.answers = answers;
    }

    public DialogStageMultipleAnswers(String sentence, int duration, ArrayList<Answer> answers) {
        super(sentence, duration);
        this.answers = answers;
    }

    @Override
    public void update(GameContainer gc, float dt, DialogState ds){
        if(!active)
            ds.DialogStageOver();
        timer += 1000*dt;
        if(timer < duration) return;

        if(gc.getInput().isButtonPressed(1))
            for (int i=0;i < answers.size();i++)
                if(gc.getInput().isMouseInArea(xPosClickAns,yPosClickAns+i*spacementClickAns,12,12))
                    if (!answers.get(i).isGood()){
                        ds.DialogStateWrongAnswer();
                    }
                    else{
                        this.active = false;
                        ds.DialogStageOver();
                    }
    }

    @Override
    public void render(GameContainer gc, Renderer r){
        super.render(gc,r);

        for (int i=0;i < answers.size();i++)
            if(gc.getInput().isMouseInArea(xPosClickAns,yPosClickAns+i*spacementClickAns,12,12))
                r.drawString("% "+answers.get(i).getAnswer(),0xffffffff,xPosClickAns,yPosClickAns+spacementClickAns*i);
            else
                r.drawString("$ "+answers.get(i).getAnswer(),0xffffffff,xPosClickAns,yPosClickAns+spacementClickAns*i);

    }






}
