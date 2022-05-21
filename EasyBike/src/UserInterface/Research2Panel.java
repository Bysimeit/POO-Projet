package UserInterface;

import Controller.ApplicationController;
import Model.ResearchInfos2;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Research2Panel extends JPanel{
    private JSpinner startDateSpinner, finishDateSpinner;
    private JLabel startDateLabel, finishDateLabel;
    private JSpinner.DateEditor startDateEditor, finishDateEditor;
    private JButton researchButton;
    private Container mainContainer;

    public Research2Panel(Container mainContainer) {
        this.mainContainer = mainContainer;
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        startDateLabel = new JLabel("Réparation entre 2 dates données : ");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(startDateLabel, c);

        startDateLabel = new JLabel("Entrez la date de début de la recherche : ");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(startDateLabel, c);

        startDateSpinner = new JSpinner(new SpinnerDateModel());
        startDateEditor = new JSpinner.DateEditor(startDateSpinner,"dd-MM-yyyy");
        startDateSpinner.setEditor(startDateEditor);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(startDateSpinner, c);

        finishDateLabel = new JLabel("Entrez la date de fin de la recherche : ");
        finishDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(finishDateLabel, c);

        finishDateSpinner = new JSpinner(new SpinnerDateModel());
        finishDateEditor = new JSpinner.DateEditor(finishDateSpinner,"dd-MM-yyyy");
        finishDateSpinner.setEditor(finishDateEditor);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(finishDateSpinner, c);

        researchButton = new JButton("Recherche");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        ButtonListener buttonListener = new ButtonListener();
        researchButton.addActionListener(buttonListener);
        add(researchButton, c);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String startDate = new SimpleDateFormat("yyyy-MM-dd").format(startDateSpinner.getValue());
            String finishDate = new SimpleDateFormat("yyyy-MM-dd").format(finishDateSpinner.getValue());
            ApplicationController controller = new ApplicationController();
            ArrayList<ResearchInfos2> result = controller.selectResearchInfos2(startDate, finishDate);

            mainContainer.removeAll();
            mainContainer.setLayout(new BorderLayout());
            mainContainer.add(new ListResearch2(result));
            mainContainer.revalidate();
            mainContainer.repaint();
        }
    }
}
