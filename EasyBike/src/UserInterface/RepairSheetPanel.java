package UserInterface;

import javax.swing.*;
import java.awt.*;

public class RepairSheetPanel extends JPanel {
    private JLabel idLabel, earlyDateLabel, endDateLabel, emergencyLabel, problemLabel, stationLabel;
    private JButton backButton, modifyButton;


    public RepairSheetPanel(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        idLabel = new JLabel("Identifiant de la fiche de réparation : <IdFiche> ");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(idLabel, c);

        earlyDateLabel = new JLabel("Date début de la réparation : <Date> ");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        earlyDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(earlyDateLabel, c);

        endDateLabel = new JLabel("Date fin de la réparation : <DateFin> ");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        endDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(endDateLabel, c);

        emergencyLabel = new JLabel("Réparation urgente ? <Oui/Non> ");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        emergencyLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(emergencyLabel, c);

        problemLabel = new JLabel("Description du problème : <Description> ");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        problemLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(problemLabel, c);

        stationLabel = new JLabel("Station émétrice : <NomStation> ");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        stationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(stationLabel, c);

        backButton = new JButton("  Retour ");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 0 ,0, 0);
        add(backButton, c);

        modifyButton = new JButton("Modifier");
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(0, 0 ,0, 0);
        add(modifyButton, c);

    }
}
