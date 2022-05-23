package UserInterface;

import Controller.ApplicationController;
import Model.ResearchInfos2;
import Model.ResearchInfos3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Research3Panel extends JPanel {
    private JSpinner dateSpinner;
    private JLabel dateLabel;
    private JSpinner.DateEditor dateEditor;
    private JButton researchButton;
    private Container mainContainer;

    public Research3Panel(Container mainContainer) {
        this.mainContainer = mainContainer;
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

        researchButton = new JButton("Recherche");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        ButtonListener buttonListener = new ButtonListener();
        researchButton.addActionListener(buttonListener);
        add(researchButton, c);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String startDate = new SimpleDateFormat("yyyy-MM-dd").format(dateSpinner.getValue());

            ApplicationController controller = new ApplicationController();
            ArrayList<ResearchInfos3> result = controller.selectResearchInfos3(startDate);

            mainContainer.removeAll();
            mainContainer.setLayout(new BorderLayout());
            mainContainer.add(new ListResearch3(result));
            mainContainer.revalidate();
            mainContainer.repaint();
        }
    }
}
