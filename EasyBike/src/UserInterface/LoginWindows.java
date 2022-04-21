package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginWindows extends JFrame {
    private LoginPanel panel = new LoginPanel();

    public LoginWindows() {
        super("Connexion");
        setBounds(100,100,350,350);

        //fermeture avec l'icone X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(panel);
        setVisible(true);
    }
}
