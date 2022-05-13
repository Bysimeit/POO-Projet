package UserInterface;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.*;
import java.awt.*;

public class Research2Panel extends JPanel{
    private JSpinner startDateSpinner, finishDateSpinner;
    private JLabel startDateLabel, finishDateLabel;
    private JSpinner.DateEditor startDateEditor, finishDateEditor;
    private JButton researchBouton;

    public Research2Panel(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        startDateLabel = new JLabel("Entrez la date de début de la recherche : ");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(startDateLabel, c);

        startDateSpinner = new JSpinner(new SpinnerDateModel());
        startDateEditor = new JSpinner.DateEditor(startDateSpinner,"dd-MM-yyyy");
        startDateSpinner.setEditor(startDateEditor);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(startDateSpinner, c);

        finishDateLabel = new JLabel("Entrez la date de fin de la recherche : ");

        finishDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(finishDateLabel, c);

        finishDateSpinner = new JSpinner(new SpinnerDateModel());
        finishDateEditor = new JSpinner.DateEditor(finishDateSpinner,"dd-MM-yyyy");
        finishDateSpinner.setEditor(finishDateEditor);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(finishDateSpinner, c);

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
