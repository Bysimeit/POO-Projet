package UserInterface;

import javax.swing.*;
import java.awt.*;

public class InfrastructurePanel extends JPanel {
    private JLabel helloLabel, jobLabel, chiefLabel;
    private JButton disconnectButton;

    public InfrastructurePanel(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        //main area
        helloLabel = new JLabel("Recherche fiche de réparation : ");
        helloLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(15, 0, 10, 150);
        c.weighty = 1;
        add(helloLabel, c);

        jobLabel = new JLabel("Recherche d'un vélo : ");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 10, 150);
        jobLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(jobLabel, c);


    }
}
