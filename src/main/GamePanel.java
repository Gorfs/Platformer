package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private int aniTick, aniIndex, aniSpeed = 15 ;
    private BufferedImage img;
    private BufferedImage[][] animations;
    float xDelta = 0.0f;
    float yDelta = 0.0f;

    public void changeXDelta(float x){
        // if x = 1 then you move it left, else you move it right
        xDelta += x;
    }
    public void changeYDelta(float y){
        yDelta += y;
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
            System.out.println(aniIndex);
            if (aniIndex >= 6)
                aniIndex = 0;
        }

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();


        g.drawImage(animations[1][aniIndex], (int)(xDelta), (int)(yDelta),120, 80, null);
    }



}
