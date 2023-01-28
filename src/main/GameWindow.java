package main;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);

        // spawn the game window in the center of the screen
        jframe.setLocationRelativeTo(null);
        
        jframe.setResizable(false);
        jframe.pack();

        // this needs to be at the end of the method
        jframe.setVisible(true);
    }
}


