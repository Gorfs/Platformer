package main;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game(){
        GamePanel gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);

    }
}
