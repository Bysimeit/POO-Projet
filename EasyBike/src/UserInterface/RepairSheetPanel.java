package UserInterface;

import Controller.ApplicationController;
import Model.Register;

import Exception.JTextFieldException;
import Exception.JTextFieldEmptyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Objects;

public class RepairSheetPanel extends JPanel {
    private JLabel idLabel, earlyDateLabel, endDateLabel, emergencyLabel, remarkLabel, stationLabel,informationLabel;
    private JTextField idText, earlyDateText, endDateText, problemText;
    private JComboBox stationList;
    private Checkbox isUrgentCheck;
    private JTextArea remarkArea;
    private JButton backButton, modifyButton;
    private boolean createForAdd, isUrgent;
    private String stationNameSelected;
    private Register loginID;


    public RepairSheetPanel(boolean createForAdd, Register loginID) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        this.createForAdd = createForAdd;
        this.loginID = loginID;

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
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        isUrgentCheck.addItemListener(checkBoxListener);
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

        String[] stationData = {"", "Bruxelles", "Namur", "Liège", "Charleroi"};
        stationList = new JComboBox(stationData);
        stationList.setMaximumRowCount(4);
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        ComboBoxListener comboBoxListener = new ComboBoxListener();
        stationList.addItemListener(comboBoxListener);
        add(new JScrollPane(stationList), c);

        informationLabel = new JLabel("* sont des champs facultatifs");
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

        if(createForAdd) {
            modifyButton = new JButton("Créer");
            ButtonListener buttonListener = new ButtonListener();
            modifyButton.addActionListener(buttonListener);
        } else {
            modifyButton = new JButton("Modifier");
        }
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(0, 0 ,0, 0);
        add(modifyButton, c);
    }

    public class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            isUrgent = event.getStateChange() == ItemEvent.SELECTED;
        }
    }

    public class ComboBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            switch (stationList.getSelectedIndex()) {
                case 1:
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        stationNameSelected = "Bruxelles";
                    }
                    break;
                case 2:
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        stationNameSelected = "Namur";
                    }
                    break;
                case 3:
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        stationNameSelected = "Liège";
                    }
                    break;
                case 4:
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        stationNameSelected = "Charleroi";
                    }
                    break;
                default:
                    stationNameSelected = "";
                    break;
            }
        }
    }

    public class ButtonListener implements ActionListener {
        private ApplicationController controller = new ApplicationController();
        @Override
        public void actionPerformed(ActionEvent event) {
            ArrayList<Register> repairInfos = new ArrayList<Register>();

            try {
                if (!Objects.equals(idText.getText(), "")) {
                    Register jIdText = new Register(idText);
                    repairInfos.add(jIdText);
                } else {
                    throw new JTextFieldEmptyException("Identifiant fiche");
                }

                if (!Objects.equals(earlyDateText.getText(), "")) {
                    Register jEarlyDateText = new Register(earlyDateText);
                    repairInfos.add(jEarlyDateText);
                } else {
                    throw new JTextFieldEmptyException("Date début réparation");
                }

                Register jEndDateText = new Register(endDateText);
                repairInfos.add(jEndDateText);

                Register jRemarkArea = new Register(remarkArea.getText());
                repairInfos.add(jRemarkArea);

                Register jStationNameSelected = new Register(stationNameSelected);
                System.out.println(stationNameSelected);
                repairInfos.add(jStationNameSelected);

                ArrayList<String> result = controller.searchEmployeeInfo(loginID);
                String stringIdEmployee = result.get(4);
                int intIdEmployee = Integer.parseInt(stringIdEmployee);

                controller.addRepairSheet(repairInfos, intIdEmployee, isUrgent);
            } catch (JTextFieldException | JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
