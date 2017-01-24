package game.dialog;

import com.engine.core.GameContainer;

import static java.awt.event.KeyEvent.*;

/**
 */
public class InputString{

    private String userInput ="";
    private boolean over = false;

    public InputString(String s) {
        userInput += s;
    }

    public boolean isOver() {
        return over;
    }

    public String getUserInput() {
        return userInput;
    }

    public void update(GameContainer gc, float dt) {
        if(!over){
            if (userInput.length() < 25)
            {
                if (gc.getInput().isKeyPressed(VK_A))
                    userInput+='A';
                if (gc.getInput().isKeyPressed(VK_B))
                    userInput+='B';
                if (gc.getInput().isKeyPressed(VK_C))
                    userInput+='C';
                if (gc.getInput().isKeyPressed(VK_D))
                    userInput+='D';
                if (gc.getInput().isKeyPressed(VK_E))
                    userInput+='E';
                if (gc.getInput().isKeyPressed(VK_F))
                    userInput+='F';
                if (gc.getInput().isKeyPressed(VK_G))
                    userInput+='G';
                if (gc.getInput().isKeyPressed(VK_H))
                    userInput+='H';
                if (gc.getInput().isKeyPressed(VK_I))
                    userInput+='I';
                if (gc.getInput().isKeyPressed(VK_J))
                    userInput+='J';
                if (gc.getInput().isKeyPressed(VK_K))
                    userInput+='K';
                if (gc.getInput().isKeyPressed(VK_L))
                    userInput+='L';
                if (gc.getInput().isKeyPressed(VK_M))
                    userInput+='M';
                if (gc.getInput().isKeyPressed(VK_N))
                    userInput+='N';
                if (gc.getInput().isKeyPressed(VK_O))
                    userInput+='O';
                if (gc.getInput().isKeyPressed(VK_P))
                    userInput+='P';
                if (gc.getInput().isKeyPressed(VK_Q))
                    userInput+='Q';
                if (gc.getInput().isKeyPressed(VK_R))
                    userInput+='R';
                if (gc.getInput().isKeyPressed(VK_S))
                    userInput+='S';
                if (gc.getInput().isKeyPressed(VK_T))
                    userInput+='T';
                if (gc.getInput().isKeyPressed(VK_U))
                    userInput+='U';
                if (gc.getInput().isKeyPressed(VK_V))
                    userInput+='V';
                if (gc.getInput().isKeyPressed(VK_W))
                    userInput+='W';
                if (gc.getInput().isKeyPressed(VK_X))
                    userInput+='X';
                if (gc.getInput().isKeyPressed(VK_Y))
                    userInput+='Y';
                if (gc.getInput().isKeyPressed(VK_Z))
                    userInput+='Z';
                if (gc.getInput().isKeyPressed(VK_SPACE))
                    userInput+=' ';
            }
            if (gc.getInput().isKeyPressed(VK_BACK_SPACE)&&userInput.length()!=0)
                userInput=userInput.substring(0,userInput.length()-1);
            if (gc.getInput().isKeyPressed(VK_ENTER)){
                over = true;
            }


        }
    }


}
