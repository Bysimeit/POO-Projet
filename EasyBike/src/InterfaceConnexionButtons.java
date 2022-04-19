import javax.swing.*;

public class InterfaceConnexionButtons extends JPanel {
    private JButton logButton, registerButton;


    public InterfaceConnexionButtons(){

        logButton = new JButton("Connexion");
        this.add(logButton);

        registerButton = new JButton("S'inscrire");
        this.add(registerButton);
    }
}

