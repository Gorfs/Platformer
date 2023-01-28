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
                gamePanel.changeXDelta(-10.0f);
//                System.out.println("left");
                break;
            }
            case KeyEvent.VK_W -> {
                gamePanel.changeYDelta(-10.0f);
//                System.out.println("up");
                break;
            }
            case KeyEvent.VK_S -> {
                gamePanel.changeYDelta(10.0f);
//                System.out.println("Down");
                break;
            }
            case KeyEvent.VK_D -> {
                gamePanel.changeXDelta(10.0f);
//                System.out.println("Right");
                break;
            }
        }

    }
}
