package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import utilz.Constants;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private int aniTick, aniIndex, aniSpeed = 20 ;
    private BufferedImage img;
    private BufferedImage[][] animations;
    float xDelta = 0.0f;
    float yDelta = 0.0f;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;

    }
    public void setMoving (boolean moving){
        this.moving = moving;
    }

    public GamePanel(){
        setPanelSize();

        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        importImg();
        loadAnimations();


    }

    private void loadAnimations() {
        animations = new BufferedImage[8][6];
        for (int j = 0; j < animations.length; j++){
            for (int i = 0; i < animations[j].length; i++){
                animations[j][i] = img.getSubimage(i*64, j*40,64, 40);
            }
        }
    }

    private void importImg(){
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }

    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
//            System.out.println(aniIndex);
            if (aniIndex >= Constants.PlayerConstants.GetSpriteAmount(playerAction))
                aniIndex = 0;
        }

    }
    private void updatePos() {
        if(moving){
            switch(playerDir){
                case LEFT:
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -=5;
                    break;
                case RIGHT:
                    xDelta += 5;
                    break;
                case DOWN:
                    yDelta +=5;
                    break;
            }
        }
    }

    private void setAnimation() {
    if(moving){
        playerAction = RUNNING;

    }else{
        playerAction = IDLE;
    }
    }

    public void updateGame(){
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(animations[playerAction][aniIndex], (int)(xDelta), (int)(yDelta),256, 160, null);
    }




}
