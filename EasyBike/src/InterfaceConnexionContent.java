import javax.swing.*;
import java.awt.*;

public class InterfaceConnexionContent extends JPanel {
    private JLabel idLabel, passWordLabel;
    private JTextField idTxt;
    private JPasswordField passWordTxt;
    private JButton logButton, registerButton;

    public InterfaceConnexionContent(){
        //activer le estionnaire de tracé
        this.setLayout(new GridLayout(3,3));

        idLabel = new JLabel("Identifiant : ");

        passWordLabel = new JLabel("Mot de passe : ");

        idTxt = new JTextField();

        passWordTxt = new JPasswordField();

        logButton = new JButton("Connexion");

        registerButton = new JButton("S'inscrire");


        this.add(idLabel);
        this.add(idTxt);

        this.add(passWordLabel);
        this.add(passWordTxt);

        this.add(logButton);
        this.add(registerButton);
    }
}
