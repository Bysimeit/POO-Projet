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

        localityLabel = new JLabel("Recherche fiche de réparation : ");
        localityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(localityLabel, c);

        String[] values = {"à remplir","a remplir","a remplir","a remplir"};
        localityCombo = new JComboBox(values);
        localityCombo.setSelectedItem("à remplir");
        localityCombo.setMaximumRowCount(10);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(localityCombo, c);

        nationalNumberLabel = new JLabel("Numéro national : ...");
        nationalNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(nationalNumberLabel, c);

        firstNameLabel = new JLabel("Prénom : ...");
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(firstNameLabel, c);

        nameLabel = new JLabel("Nom : ...");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(nameLabel, c);

        streetLabel = new JLabel("Rue : ...");
        streetLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(streetLabel, c);

        houseNumberLabel = new JLabel("Numéro de maison : ...");
        houseNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(houseNumberLabel, c);

        customerNumberLabel = new JLabel("Numéro de client : ...");
        customerNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(customerNumberLabel, c);

        priceLabel = new JLabel("Prix : ...");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(priceLabel, c);
    }
}
