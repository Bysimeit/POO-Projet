package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JButton loginButton, registerButton;
    private JLabel title, emailLabel, passwordLabel;
    private JTextField emailText, passwordText;

    public LoginPanel(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);


        //title
        title = new JLabel("EasyBike");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(25, 0, 0, 0);
        c.weighty = 1;
        add(title, c);

        c.weighty = 2;

        //email area
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridwidth = 1;
        emailLabel = new JLabel("Email : ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(emailLabel, c);

        emailText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 0);
        add(emailText, c);

        //password area
        passwordLabel = new JLabel("Mot de passe : ");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(passwordLabel, c);

        passwordText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0, 0 ,0, 0);
        add(passwordText, c);

        //button area
        c.anchor = GridBagConstraints.SOUTH;
        loginButton = new JButton("Connexion");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 35 ,20, 0);
        add(loginButton, c);

        registerButton = new JButton("Inscritpion");
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 0 ,20, 0);
        add(registerButton, c);

    }
}