package UserInterface;

import javax.swing.*;
import java.awt.*;

public class Research3Panel extends JPanel {
    private JSpinner dateSpinner;
    private JLabel dateLabel;
    private JSpinner.DateEditor dateEditor;
    private JButton researchBouton;

    public Research3Panel(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        dateLabel = new JLabel("Souscriptions débutant après une date donnée : ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(dateLabel, c);

        dateLabel = new JLabel("Entrez la date de début des abonnements : ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(dateLabel, c);

        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateEditor = new JSpinner.DateEditor(dateSpinner,"dd-MM-yyyy");
        dateSpinner.setEditor(dateEditor);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(dateSpinner, c);

        researchBouton = new JButton("Recherche");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(researchBouton, c);
    }
}
