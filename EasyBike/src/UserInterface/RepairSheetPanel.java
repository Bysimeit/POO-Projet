package UserInterface;

import javax.swing.*;
import java.awt.*;

public class RepairSheetPanel extends JPanel {
    private JLabel idLabel, earlyDateLabel, endDateLabel, emergencyLabel, remarkLabel, stationLabel,informationLabel;
    private JTextField idText, earlyDateText, endDateText, problemText;
    private JComboBox stationList;
    private Checkbox isUrgentCheck;
    private JTextArea remarkArea;
    private JButton backButton, modifyButton;


    public RepairSheetPanel() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        idLabel = new JLabel("Identifiant de la fiche de réparation : ");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(idLabel, c);

        idText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(idText, c);

        earlyDateLabel = new JLabel("Date début de la réparation : ");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        earlyDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(earlyDateLabel, c);

        earlyDateText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(earlyDateText, c);

        endDateLabel = new JLabel("Date fin de la réparation : *");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        endDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(endDateLabel, c);

        endDateText = new JTextField(15);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(endDateText, c);

        emergencyLabel = new JLabel("Réparation urgente ? ");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        emergencyLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(emergencyLabel, c);

        isUrgentCheck = new Checkbox();
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(isUrgentCheck, c);

        remarkLabel = new JLabel("Remarque : *");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        remarkLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(remarkLabel, c);

        remarkArea = new JTextArea(5,15);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(new JScrollPane(remarkArea), c);

        stationLabel = new JLabel("Station émétrice");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        stationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(stationLabel, c);

        String[] stationData = {"à remplir 1","à remplir","à remplir","à remplir"};
        stationList = new JComboBox(stationData);
        stationList.setMaximumRowCount(3);
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        add(new JScrollPane(stationList), c);

        informationLabel = new JLabel("* sont des champs facultatif");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        informationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(informationLabel, c);

        backButton = new JButton("  Retour ");
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0, 0 ,0, 0);
        add(backButton, c);

        modifyButton = new JButton("Modifier");
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(0, 0 ,0, 0);
        add(modifyButton, c);
    }
}
