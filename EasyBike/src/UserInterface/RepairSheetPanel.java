package UserInterface;

import Controller.ApplicationController;
import Model.Register;

import Exception.JTextFieldException;
import Exception.JTextFieldEmptyException;
import Model.Repair;

import javax.imageio.ImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class RepairSheetPanel extends JPanel {
    private JLabel idLabel, earlyDateLabel, endDateLabel, emergencyLabel, remarkLabel, stationLabel,informationLabel;
    private JTextField idText, earlyDateText, endDateText;
    private JComboBox stationList;
    private Checkbox isUrgentCheck;
    private JTextArea remarkArea;
    private JButton backButton, modifyButton;
    private boolean createForAdd, isUrgent;
    private String stationNameSelected;
    private Register loginID;
    private ArrayList<String> infosRepairSheet;
    private Container container;
    private EmployeeWindow employee;


    public RepairSheetPanel(boolean createForAdd, Register loginID, ArrayList<String> infosRepairSheet, EmployeeWindow employeeWindow, Container container) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        this.createForAdd = createForAdd;
        this.loginID = loginID;
        this.infosRepairSheet = infosRepairSheet;
        this.employee = employeeWindow;
        this.container = container;

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
        idText.setEditable(createForAdd);
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

        boolean isUrgentChecked = false;
        if (infosRepairSheet == null) {
            isUrgentChecked = false;
        } else if (infosRepairSheet.get(3).equals("true")) {
            isUrgentChecked = true;
        }

        isUrgentCheck = new Checkbox("", isUrgentChecked);
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

        if(createForAdd) {
            modifyButton = new JButton("Créer");
            ButtonListenerAdd buttonListenerAdd = new ButtonListenerAdd();
            modifyButton.addActionListener(buttonListenerAdd);

        } else {
            backButton = new JButton("  Retour ");
            c.gridx = 0;
            c.gridy = 7;
            c.insets = new Insets(0, 0 ,0, 0);
            add(backButton, c);

            idText.setText(infosRepairSheet.get(0));
            earlyDateText.setText(infosRepairSheet.get(1));
            if (!infosRepairSheet.get(2).equals("null")) {
                endDateText.setText(infosRepairSheet.get(2));
            }
            remarkArea.setText(infosRepairSheet.get(4));
            stationList.setSelectedItem(infosRepairSheet.get(5));
            modifyButton = new JButton("Modifier");
            ButtonListenerModify buttonListenerModify = new ButtonListenerModify();
            modifyButton.addActionListener(buttonListenerModify);
            ButtonListenerBack buttonListenerBack = new ButtonListenerBack();
            backButton.addActionListener(buttonListenerBack);
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

    public class ButtonListenerBack implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            container.removeAll();
            container.setLayout(new BorderLayout());
            container.add(new ResearchRepairPanel(container, employee, false, loginID), BorderLayout.CENTER);
            container.repaint();
            employee.setVisible(true);
        }
    }

    public class ButtonListenerAdd implements ActionListener {
        private ApplicationController controller = new ApplicationController();

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                if (Objects.equals(idText.getText(), "")) {
                    throw new JTextFieldEmptyException("Identifiant fiche");
                }

                if (Objects.equals(earlyDateText.getText(), "")) {
                    throw new JTextFieldEmptyException("Date début réparation");
                }

                ArrayList<String> result = controller.searchEmployeeInfo(loginID);
                String stringIdEmployee = result.get(4);

                Integer idRepair = Integer.parseInt(idText.getText());
                Integer idEmployee = Integer.parseInt(stringIdEmployee);

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date1 = format.parse(earlyDateText.getText());
                GregorianCalendar dateToConvert1 = new GregorianCalendar();
                dateToConvert1.setTime(date1);
                java.sql.Date startDateSQL = new java.sql.Date(dateToConvert1.getTimeInMillis());

                java.sql.Date endDateSQL = null;
                if (!endDateText.getText().equals("")) {
                    format = new SimpleDateFormat("dd-MM-yyyy");
                    Date date2 = format.parse(earlyDateText.getText());
                    GregorianCalendar dateToConvert2 = new GregorianCalendar();
                    dateToConvert1.setTime(date1);
                    endDateSQL = new java.sql.Date(dateToConvert1.getTimeInMillis());
                }

                Repair repair = new Repair(idRepair, idEmployee, startDateSQL, endDateSQL, isUrgent, remarkArea.getText(), stationNameSelected);

                controller.addRepairSheet(repair);
            } catch (ParseException | JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class ButtonListenerModify implements ActionListener {
        private ApplicationController controller = new ApplicationController();
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                if (Objects.equals(idText.getText(), "")) {
                    throw new JTextFieldEmptyException("Identifiant fiche");
                }

                if (Objects.equals(earlyDateText.getText(), "")) {
                    throw new JTextFieldEmptyException("Date début réparation");
                }

                ArrayList<String> result = controller.searchEmployeeInfo(loginID);
                String stringIdEmployee = result.get(4);

                Integer idRepair = Integer.parseInt(idText.getText());
                Integer idEmployee = Integer.parseInt(stringIdEmployee);

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date1 = format.parse(earlyDateText.getText());
                GregorianCalendar dateToConvert1 = new GregorianCalendar();
                dateToConvert1.setTime(date1);
                java.sql.Date startDateSQL = new java.sql.Date(dateToConvert1.getTimeInMillis());

                java.sql.Date endDateSQL = null;
                if (!endDateText.getText().equals("")) {
                    format = new SimpleDateFormat("dd-MM-yyyy");
                    Date date2 = format.parse(earlyDateText.getText());
                    GregorianCalendar dateToConvert2 = new GregorianCalendar();
                    dateToConvert1.setTime(date1);
                    endDateSQL = new java.sql.Date(dateToConvert1.getTimeInMillis());
                }

                Repair repair = new Repair(idRepair, idEmployee, startDateSQL, endDateSQL, isUrgent, remarkArea.getText(), stationNameSelected);

                controller.modifyRepairSheet(repair);
            } catch (ParseException | JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
