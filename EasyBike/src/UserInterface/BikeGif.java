package UserInterface;

import javax.swing.*;
import java.awt.*;

public class BikeGif {
    private ImageIcon bike;
    private int deltaX;

    public BikeGif(){
        bike = new ImageIcon(getClass().getResource(".../Pictures/velo-de-course.gif"));
        bike.getImage().getScaledInstance(20,20, Image.SCALE_FAST);
    }

    public void move(){
        this.deltaX += 1;
    }
}
