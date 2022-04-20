package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private JLabel title, nameLabel, firstNameLabel, birthdayLabel, emailLabel, passwordLabel, phoneLabel, GSMLabel, streetLabel, numberStreetLabel, postalCodeLabel, signatureLabel;
    private JTextField nameText, firstNameText, birthdayText, emailText, passwordText, phoneText, GSMText, streetText, postalCodeText, numberStreetText, signatureText;
    private JButton backButton, registerButton;

    public RegisterPanel(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);


        //title
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
        firstNameLabel = new JLabel("Prénom : ");
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

        //email area
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        emailLabel = new JLabel("Email : ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(emailLabel, c);

        emailText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        add(emailText, c);

        //password area
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        passwordLabel = new JLabel("Mot de passe : ");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(passwordLabel, c);

        passwordText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 20, 0);
        add(passwordText, c);

        //phone area
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        phoneLabel = new JLabel("Numéro de téléphone : ");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(phoneLabel, c);

        phoneText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 20, 0);
        add(phoneText, c);

        //GSM area
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        GSMLabel = new JLabel("Numéro de GSM : ");
        GSMLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(GSMLabel, c);

        GSMText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(0, 0, 20, 0);
        add(GSMText, c);

        //street area
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        streetLabel = new JLabel("Nom de rue : ");
        streetLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(streetLabel, c);

        streetText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(0, 0, 20, 0);
        add(streetText, c);

        //numberStreet area
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        numberStreetLabel = new JLabel("Numéro de rue : ");
        numberStreetLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(numberStreetLabel, c);

        numberStreetText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 9;
        c.insets = new Insets(0, 0, 20, 0);
        add(numberStreetText, c);

        //postalCode area
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        postalCodeLabel = new JLabel("Code Postal : ");
        postalCodeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(postalCodeLabel, c);

        postalCodeText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0, 0, 20, 0);
        add(postalCodeText, c);

        //signature area
        c.gridx = 0;
        c.gridy = 11;
        c.insets = new Insets(0, 0, 20, 0);
        c.gridwidth = 1;
        signatureLabel = new JLabel("Signature : ");
        signatureLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(signatureLabel, c);

        signatureText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 11;
        c.insets = new Insets(0, 0, 20, 0);
        add(signatureText, c);

        //button area
        c.anchor = GridBagConstraints.SOUTH;
        backButton = new JButton("Retour");
        c.gridx = 0;
        c.gridy = 12;
        c.insets = new Insets(0, 35 ,20, 0);
        add(backButton, c);

        registerButton = new JButton("Inscritpion");
        c.gridx = 1;
        c.gridy = 12;
        c.insets = new Insets(0, 0 ,20, 0);
        //ButtonListener listener = new ButtonListener(this.nameText, this.firstNameText, this.birthdayText, this.emailText, this.passwordText, this.phoneText, this.GSMText, this.streetText, this.postalCodeText, this.numberStreetText, this.signatureText);
        add(registerButton, c);
    }

    /*
    private class ButtonListener implements ActionListener {
        private JTextField nameText, firstNameText, birthdayText, emailText, passwordText, phoneText, GSMText, streetText, postalCodeText, numberStreetText, signatureText;
        public ButtonListener (JTextField nameText, JTextField firstNameText, JTextField birthdayText, JTextField emailText, JTextField passwordText, JTextField phoneText, JTextField GSMText, JTextField streetText, JTextField postalCodeText, JTextField numberStreetText, JTextField signatureText) {
            this.nameText = nameText;
            this.firstNameText = firstNameText;
            this.birthdayText = birthdayText;
            this.emailText = emailText;
            this.passwordText = passwordText;
            this.phoneText = phoneText;
            this.GSMText = GSMText;
            this.streetText = streetText;
            this.postalCodeText = postalCodeText;
            this.numberStreetText = numberStreetText;
            this.signatureText = signatureText;
        }
        public void actionPerformed(ActionEvent event) {
            // Envoyer vers la couche Controller puis, vers la couche Business pour traitement
        }
    }
    */
}
