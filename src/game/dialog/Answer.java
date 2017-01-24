package game.dialog;

/**
 * The Anwser class is a simple class which binds a String to a boolean. In order to
 * handle possible answer for a multiple choice stage for exemple.
 */
public class Answer {

    /**
     * The answer is acceptable when good is set to true.
     */
    private boolean good;

    /**
     * The string that corresponds to the possible answer
     */
    private String answer;

    public Answer(boolean good, String answer) {
        this.good = good;
        this.answer = answer;
    }
    public Answer(String answer){
        this.answer = answer;
        this.good =true;
    }


    public boolean isGood() {
        return good;
    }

    public String getAnswer() {
        return answer;
    }
}
