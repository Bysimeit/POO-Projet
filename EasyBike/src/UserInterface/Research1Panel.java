package UserInterface;

import javax.swing.*;
import java.awt.*;

public class Research1Panel extends JPanel{
    private JComboBox localityCombo;
    private JLabel localityLabel, nationalNumberLabel, firstNameLabel, nameLabel, streetLabel, houseNumberLabel, customerNumberLabel, priceLabel;

    public Research1Panel(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        localityLabel = new JLabel("Recherche les membres d'une localité : ");
        localityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(localityLabel, c);

        localityLabel = new JLabel("Sélectonner localité : ");
        localityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 150, 0);
        c.weighty = 1;
        add(localityLabel, c);

        String[] values = {"à remplir","a remplir","a remplir","a remplir"};
        localityCombo = new JComboBox(values);
        localityCombo.setSelectedItem("à remplir");
        localityCombo.setMaximumRowCount(10);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 150, 0);
        c.weighty = 1;
        add(localityCombo, c);

    }
}
