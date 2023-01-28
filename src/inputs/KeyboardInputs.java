package inputs;

import main.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
//        System.out.println("a key was pressed");
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_A -> {
                gamePanel.setDirection(LEFT);
                break;
            }
            case KeyEvent.VK_W -> {
                gamePanel.setDirection(UP);;
//                System.out.println("up");
                break;
            }
            case KeyEvent.VK_S -> {
                gamePanel.setDirection(DOWN);;
//                System.out.println("Down");
                break;
            }
            case KeyEvent.VK_D -> {
                gamePanel.setDirection(RIGHT);;
//                System.out.println("Right");
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
//        System.out.println("a key was released");
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D -> {
                gamePanel.setMoving(false);
            }
        }

    }
}
