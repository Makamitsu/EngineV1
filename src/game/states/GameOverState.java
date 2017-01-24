package game.states;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.State;
import com.engine.core.fx.Image;
import com.engine.core.fx.SoundClip;

/**
 * This class loads all the elements related to the game over state
 * And then Update the position of the credit
 * And Render the back and the credit.
 */
public class GameOverState extends State {

    private float pos = 300;
    private Image back;
    private Image credit;
    private SoundClip sound;

    public GameOverState(){
        sound = new SoundClip("/sound/tiamo_short.wav");
        back = new Image("/gameOver/back.png");
        credit = new Image("/gameOver/text.png");
        sound.loop();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if(pos > -400)
            pos -= dt*15;
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(back);
        r.drawImage(credit,50,(int)pos);
    }

    @Override
    public void dispose() {

    }
}
