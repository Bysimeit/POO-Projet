package UserInterface;

import javax.swing.*;
import java.awt.*;

public class BikeGif extends JPanel{
    private Image bike;
    private int deltaX = 700;

    public BikeGif(){
        System.out.println("avant");
        bike = new ImageIcon(getClass().getResource("../Pictures/velo-de-course.gif")).getImage();
        System.out.println("après");
        setPreferredSize(new Dimension(100,100));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bike,deltaX,0,100,100,this);
        if (deltaX <= -100){
            deltaX = 650;
        }
    }

    public void move(){
        deltaX -= 3;
    }
}
