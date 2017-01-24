package game.states;

import com.engine.core.GameContainer;
import com.engine.core.Renderer;
import com.engine.core.components.State;
import com.engine.core.fx.Image;
import com.engine.core.fx.Pixel;
import com.engine.core.fx.SoundClip;
import game.core.Room;

/**
 * The transitionState is a state composed of a light close from a given value to 0, then a light open to 0
 * from a given value.
 * A sound of steps is played at the beginning.
 */
public class TransitionState extends State{

    private int duration;
    private float timer =0f;
    private float intensity;
    private boolean over =false;
    private int fromIntensity,toIntensity;
    private Image fromImage,toImage;
    private SoundClip steps;
    private boolean initialized =false;
    private Room destination;

    public boolean isOver() {
        return over;
    }

    /**
     * Constructor method for the transitionState
     *
     * @param duration The duration in ms for the transition
     * @param fromRoom The room leaved by the player
     * @param toRoom   The destination room
     */
    public TransitionState(int duration, Room fromRoom, Room toRoom){
        this.duration = duration;
        this.fromIntensity = fromRoom.getAmbientLight();
        this.toIntensity = toRoom.getAmbientLight();
        this.destination = toRoom;
        this.fromImage = fromRoom.getModel();
        this.toImage = toRoom.getModel();
        steps = new SoundClip("/sound/steps.wav");
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if(!initialized){
            steps.play();
            initialized =  true;
        }

        timer += dt*1000;
        if(timer > duration) {
            over = true;
        }
        if(timer < duration/2)
            intensity = (((duration/3)-timer)/(duration/3))*Pixel.getAlpha(fromIntensity);
        else
            intensity = (1-((duration-timer)/(duration/3)))*Pixel.getAlpha(toIntensity);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        if (timer > duration/2)
            r.drawImage(toImage);
        else
            r.drawImage(fromImage);
        if(intensity < 0)
            intensity = 0;
        r.ambientLight = Pixel.getColor(1.0f,intensity,intensity,intensity);
    }

    @Override
    public void dispose() {

    }

    public Room getDestination() {
        return destination;
    }
}
