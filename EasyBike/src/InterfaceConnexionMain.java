import javax.swing.*;
import java.awt.*;

public class InterfaceConnexionMain extends JPanel {

    private JLabel idLabel, passWordLabel;
    private JTextField idTxt;
    private JPasswordField passWordTxt;

    public InterfaceConnexionMain(){

        //activer le estionnaire de tracé
        this.setLayout(new GridLayout(2,2,10,10));

        idLabel = new JLabel("Identifiant : ");
        idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(idLabel);

        idTxt = new JTextField();
        this.add(idTxt);

        passWordLabel = new JLabel("Mot de passe : ");
        passWordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(passWordLabel);

        passWordTxt = new JPasswordField();
        this.add(passWordTxt);
    }

}