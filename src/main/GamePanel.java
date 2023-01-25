package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private int xDelta = 0, yDelta=0;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(100 + xDelta, 100 + yDelta, 200,50);
    }

    public void changeXDelta (int n){
        this.xDelta += n;
        repaint();
    }
    public void changeYDelta(int n){
        this.yDelta += n;
        repaint();
    }
    public void setRectPosition(int x_pos, int y_pos){
        this.yDelta = y_pos-100;
        this.xDelta = x_pos -100;
        repaint();
    }
}
