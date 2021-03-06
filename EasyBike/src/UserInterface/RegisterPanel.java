package UserInterface;

import Controller.ApplicationController;
import Exception.FormatRegisterException;
import Exception.JTextFieldEmptyException;
import Exception.AddRegisterException;
import Model.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterPanel extends JPanel {
    private JLabel title, nameLabel, firstNameLabel, nationalNumberLabel, birthdayLabel, emailLabel, passwordLabel, phoneLabel, GSMLabel, streetLabel, numberStreetLabel, postalCodeLabel, signatureLabel;
    private JTextField nameText, firstNameText, birthdayText, nationalNumberText, emailText, passwordText, phoneText, GSMText, streetText, postalCodeText, numberStreetText, signatureText;
    private JButton backButton, registerButton;

    private JFrame registerWindow;
    private JFrame loginWindow;

    public RegisterPanel(JFrame registerWindow, JFrame loginWindow) {
        this.registerWindow = registerWindow;
        this.loginWindow = loginWindow;

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        // title
        title = new JLabel("Bienvenue chez EasyBike");
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(25, 0, 0, 0);
        c.weighty = 1;
        add(title, c);

        //main area

        //nom area
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        nameLabel = new JLabel("Nom : ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(nameLabel, c);

        nameText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 20, 0);
        add(nameText, c);

        //firstName area
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        firstNameLabel = new JLabel("Pr??nom : ");
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(firstNameLabel, c);

        firstNameText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 20, 0);
        add(firstNameText, c);

        //birthday area
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        birthdayLabel = new JLabel("Date de naissance : ");
        birthdayLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(birthdayLabel, c);

        birthdayText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 20, 0);
        add(birthdayText, c);

        //national number
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        nationalNumberLabel = new JLabel("N?? registre national : ");
        nationalNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(nationalNumberLabel, c);

        nationalNumberText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        add(nationalNumberText, c);

        //email area
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        emailLabel = new JLabel("Email : ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(emailLabel, c);

        emailText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 20, 0);
        add(emailText, c);

        //password area
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        passwordLabel = new JLabel("Mot de passe : ");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(passwordLabel, c);

        passwordText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 20, 0);
        add(passwordText, c);

        //phone area
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        phoneLabel = new JLabel("Num??ro de t??l??phone : ");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(phoneLabel, c);

        phoneText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(0, 0, 20, 0);
        add(phoneText, c);

        //GSM area
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        GSMLabel = new JLabel("Num??ro de GSM : ");
        GSMLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(GSMLabel, c);

        GSMText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(0, 0, 20, 0);
        add(GSMText, c);

        //street area
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        streetLabel = new JLabel("Nom de rue : ");
        streetLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(streetLabel, c);

        streetText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 9;
        c.insets = new Insets(0, 0, 20, 0);
        add(streetText, c);

        //numberStreet area
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        numberStreetLabel = new JLabel("Num??ro de rue : ");
        numberStreetLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(numberStreetLabel, c);

        numberStreetText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0, 0, 20, 0);
        add(numberStreetText, c);

        //postalCode area
        c.gridx = 0;
        c.gridy = 11;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        postalCodeLabel = new JLabel("Code Postal : ");
        postalCodeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(postalCodeLabel, c);

        postalCodeText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 11;
        c.insets = new Insets(0, 0, 20, 0);
        add(postalCodeText, c);

        //signature area
        c.gridx = 0;
        c.gridy = 12;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        signatureLabel = new JLabel("Signature : ");
        signatureLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(signatureLabel, c);

        signatureText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 12;
        c.insets = new Insets(0, 0, 20, 0);
        add(signatureText, c);

        //button area
        c.anchor = GridBagConstraints.SOUTH;
        backButton = new JButton("Retour");
        c.gridx = 0;
        c.gridy = 13;
        c.insets = new Insets(0, 35 ,20, 0);
        BackListener backListener = new BackListener();
        backButton.addActionListener(backListener);
        add(backButton, c);

        registerButton = new JButton("Inscription");
        c.gridx = 1;
        c.gridy = 13;
        c.insets = new Insets(0, 0 ,20, 0);
        ButtonListener registerListener = new ButtonListener();
        registerButton.addActionListener(registerListener);
        add(registerButton, c);
    }

    // Action click on Back Button
    private class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            registerWindow.setVisible(false);
            loginWindow.setVisible(true);
        }
    }

    // Action click on Register Button
    private class ButtonListener implements ActionListener {
        private ApplicationController controller = new ApplicationController();
        public void actionPerformed(ActionEvent event) {
            try {
                if (Objects.equals(nameText.getText(), "")) {
                    throw new JTextFieldEmptyException("Nom");
                }

                if (Objects.equals(firstNameText.getText(), "")) {
                    throw new JTextFieldEmptyException("Pr??nom");
                }

                if (Objects.equals(birthdayText.getText(), "")) {
                    throw new JTextFieldEmptyException("Date de naissance");
                }

                if (Objects.equals(nationalNumberText.getText(), "")) {
                    throw new JTextFieldEmptyException("N?? registre national");
                }

                if (Objects.equals(emailText.getText(), "")) {
                    throw new JTextFieldEmptyException("Email");
                }

                if (Objects.equals(passwordText.getText(), "")) {
                    throw new JTextFieldEmptyException("Mot de passe");
                }

                if (Objects.equals(streetText.getText(), "")) {
                    throw new JTextFieldEmptyException("Nom de rue");
                }

                if (Objects.equals(numberStreetText.getText(), "")) {
                    throw new JTextFieldEmptyException("Num??ro de rue");
                }

                if (Objects.equals(postalCodeText.getText(), "")) {
                    throw new JTextFieldEmptyException("Code postal");
                }

                if (!Pattern.matches("[0-9]*", phoneText.getText())) {
                    throw new FormatRegisterException("Num??ro de t??l??phone");
                }

                if (!Pattern.matches("[0-9]*", GSMText.getText())) {
                    throw new FormatRegisterException("Num??ro de GSM");
                }

                if (!Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", emailText.getText())) {
                    throw new FormatRegisterException("Email");
                }

                if (!Pattern.matches("^\\d{2}-\\d{2}-\\d{4}$", birthdayText.getText())) {
                    throw new FormatRegisterException("Date de naissance (dd-MM-yyyy)");
                }

                if (!Pattern.matches("[a-zA-z????????????]+([ -][a-z????????A-Z????????]+)*", firstNameText.getText())) {
                    throw new FormatRegisterException("Pr??nom");
                }

                if (!Pattern.matches("[a-zA-z????????????]+([ -][a-z????????A-Z????????]+)*", nameText.getText())) {
                    throw new FormatRegisterException("Nom");
                }

                if (!Pattern.matches("[0-9]*", postalCodeText.getText()) && postalCodeText.getText().length() == 4) {
                    throw new FormatRegisterException("Code postal");
                }

                if (!Pattern.matches("[0-9]*", numberStreetText.getText())) {
                    throw new FormatRegisterException("Num??ro de rue");
                }

                Register registerInfos = new Register(nameText.getText(), firstNameText.getText(), birthdayText.getText(), nationalNumberText.getText(), emailText.getText(), passwordText.getText(), phoneText.getText(), GSMText.getText(), streetText.getText(), numberStreetText.getText(), postalCodeText.getText(), signatureText.getText());

                controller.addRegister(registerInfos);
            } catch (FormatRegisterException | AddRegisterException | JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
