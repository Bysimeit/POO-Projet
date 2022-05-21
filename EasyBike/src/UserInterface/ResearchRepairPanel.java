package UserInterface;

import Controller.ApplicationController;
import Model.Register;

import Exception.JTextFieldEmptyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ResearchRepairPanel extends JPanel {
    private JTextField bikeText, repairText;
    private JLabel bikeLabel, repairLabel;
    private JButton searchBikeButton, searchRepairButton;
    private Container container;
    private EmployeeWindow employeeWindow;
    private Register loginID;

    public ResearchRepairPanel(Container container, EmployeeWindow employeeWindow, boolean createForDestroy, Register loginID) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        this.container = container;
        this.employeeWindow = employeeWindow;
        this.loginID = loginID;

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

        if (createForDestroy) {
            searchRepairButton = new JButton("Supprimer");
            ButtonListenerDel buttonListenerDel = new ButtonListenerDel();
            searchRepairButton.addActionListener(buttonListenerDel);
        } else {
            searchRepairButton = new JButton("Rechercher");
            ButtonListenerModify buttonListenerModify = new ButtonListenerModify();
            searchRepairButton.addActionListener(buttonListenerModify);
        }
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0 ,70, 0);

        add(searchRepairButton, c);
    }

    public class ButtonListenerModify implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                if (Objects.equals(repairText.getText(), "")) {
                    throw new JTextFieldEmptyException("ID fiche réparation");
                }

                ApplicationController applicationController = new ApplicationController();
                ArrayList<String> infosRepairSheet;

                int idRepairSheet = Integer.parseInt(repairText.getText());
                infosRepairSheet = applicationController.searchRepairSheet(idRepairSheet);

                container.removeAll();
                container.setLayout(new BorderLayout());
                container.add(new RepairSheetPanel(false, loginID, infosRepairSheet, employeeWindow, container), BorderLayout.CENTER);
                container.repaint();
                employeeWindow.setVisible(true);
            } catch (JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class ButtonListenerDel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                if (Objects.equals(repairText.getText(), "")) {
                    throw new JTextFieldEmptyException("ID fiche réparation");
                }

                ApplicationController applicationController = new ApplicationController();

                int idRepairSheet = Integer.parseInt(repairText.getText());

                applicationController.delRepairSheet(idRepairSheet);
            } catch (JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
