package UserInterface;

import javax.swing.*;
import java.awt.*;

public class InfrastructurePanel extends JPanel {
    private JTextField bikeText, repairText;
    private JLabel bikeLabel, repairLabel;
    private JButton searchBikeButton, searchRepairButton;

    public InfrastructurePanel(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        //main area
        repairLabel = new JLabel("Recherche fiche de réparation : ");
        repairLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(repairLabel, c);

        repairText = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(repairText, c);

        searchRepairButton = new JButton("Recherche");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0 ,70, 0);
        add(searchRepairButton, c);

        bikeLabel = new JLabel("Recherche d'un vélo : ");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 50, 0, 0);
        bikeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(bikeLabel, c);

        bikeText = new JTextField(10);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(bikeText, c);

        searchBikeButton = new JButton("Recherche");
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 0 ,70, 0);
        add(searchBikeButton, c);


    }
}
