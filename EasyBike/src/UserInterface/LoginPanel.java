package UserInterface;

import Controller.ApplicationController;
import Exception.JTextFieldException;
import Exception.JTextFieldEmptyException;
import Model.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class LoginPanel extends JPanel {
    private JButton loginButton, registerButton;
    private JLabel title, emailLabel, passwordLabel;
    private JTextField emailText, passwordText;

    private JRadioButton memberButton, employeeButton;
    private ButtonGroup buttonGroup;
    private Boolean isMember = true;

    private JFrame loginWindow;

    public LoginPanel(JFrame loginWindow) {
        this.loginWindow = loginWindow;

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        this.memberButton = new JRadioButton("Client(e)", true);
        this.employeeButton = new JRadioButton("Employé(e)", false);

        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(memberButton);
        this.buttonGroup.add(employeeButton);

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

        // Radio Button
        RadioButtonListener radioButtonListener = new RadioButtonListener();
        c.gridx = 0;
        c.gridy = 3;
        memberButton.addItemListener(radioButtonListener);
        add(memberButton, c);
        c.gridx = 1;
        c.gridy = 3;
        employeeButton.addItemListener(radioButtonListener);
        add(employeeButton, c);

        //login button
        LoginListener loginListener = new LoginListener();
        c.anchor = GridBagConstraints.SOUTH;
        loginButton = new JButton("Connexion");
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 35 ,20, 0);
        loginButton.addActionListener(loginListener);
        add(loginButton, c);

        //register button
        RegisterListener listenerRegister = new RegisterListener();
        registerButton = new JButton("Inscription");
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0 ,20, 0);
        registerButton.addActionListener(listenerRegister);
        add(registerButton, c);
    }

    //click on register button
    private class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                RegisterWindow registerWindow = new RegisterWindow(loginWindow);
                loginWindow.setVisible(false);
            } catch (JTextFieldException | JTextFieldEmptyException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //click on login button
    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Register loginId = new Register();

            try {
                if (!Objects.equals(emailText.getText(), "")) {
                    loginId.addInsertList(emailText.getText());
                } else {
                    throw new JTextFieldEmptyException("Email");
                }
                if (!Objects.equals(passwordText.getText(), "")) {
                    loginId.addInsertList(passwordText.getText());
                } else {
                    throw new JTextFieldEmptyException("Mot de passe");
                }

                ApplicationController controller = new ApplicationController();
                controller.loginConnection(loginId, isMember);
            } catch (JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class RadioButtonListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == memberButton && event.getStateChange() == ItemEvent.SELECTED) {
                isMember = true;
            } else if (event.getSource() == employeeButton && event.getStateChange() == ItemEvent.SELECTED) {
                isMember = false;
            }
        }
    }
}
