import javax.swing.*;
import java.awt.*;

public class InterfaceConnexionTitle extends JPanel {
    private JLabel titleLable;

    public InterfaceConnexionTitle(){

        titleLable = new JLabel("EasyBike ");
        titleLable.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLable);
    }
}
