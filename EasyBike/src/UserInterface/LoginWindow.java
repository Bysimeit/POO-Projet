package UserInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginWindow extends JFrame {
    private LoginPanel mainPanel = new LoginPanel(this);

    public LoginWindow() {
        super("Connexion");
        setBounds(100,100,350,350);

        //fermeture avec l'icone X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(mainPanel);
        setVisible(true);
    }
}
