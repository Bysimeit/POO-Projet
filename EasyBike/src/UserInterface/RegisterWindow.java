package UserInterface;

import Exception.JTextFieldException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterWindow extends JFrame {
    private RegisterPanel panel;
    private Container mainContent;

    public RegisterWindow() throws JTextFieldException {
        super("Inscription");
        setBounds(50,50,350,800);

        //fermeture avec l'icone X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(new RegisterPanel());
        setVisible(true);
    }


}
