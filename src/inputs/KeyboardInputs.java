package inputs;

import main.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
//        System.out.println("a key was released");
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_A -> {
                System.out.println("left");
                gamePanel.changeXDelta(-10);
                break;
            }
            case KeyEvent.VK_W -> {
                gamePanel.changeYDelta(-10);
                System.out.println("up");
                break;
            }
            case KeyEvent.VK_S -> {
                System.out.println("Down");
                gamePanel.changeYDelta(10);
                break;
            }
            case KeyEvent.VK_D -> {
                System.out.println("Right");
                gamePanel.changeXDelta(10);
                break;
            }
        }

    }
}
