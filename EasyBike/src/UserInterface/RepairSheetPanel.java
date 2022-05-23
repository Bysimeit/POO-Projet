package UserInterface;

import Controller.ApplicationController;
import Model.Locality;
import Model.Register;

import Exception.JTextFieldException;
import Exception.JTextFieldEmptyException;
import Exception.AddRepairException;
import Model.Repair;

import javax.imageio.ImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RepairSheetPanel extends JPanel {
    private JLabel idLabel, earlyDateLabel, endDateLabel, emergencyLabel, remarkLabel, numberBikeLabel, stationLabel,informationLabel;
    private JTextField idText;
    private JComboBox numberBikeList, stationList;
    private Checkbox isUrgentCheck, haveFinishDate;
    private JTextArea remarkArea;
    private JButton backButton, modifyButton;
    private boolean createForAdd, isUrgent, finishDate;
    private JSpinner startDateSpinner, finishDateSpinner;
    private JSpinner.DateEditor startDateEditor, finishDateEditor;
    private String stationNameSelected;
    private int bikeNumberSelected;
    private Register loginID;
    private ArrayList<String> infosRepairSheet;
    private Container container;
    private EmployeeWindow employee;


    public RepairSheetPanel(boolean createForAdd, Register loginID, ArrayList<String> infosRepairSheet, EmployeeWindow employeeWindow, Container container) throws ParseException {
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

        endDateLabel = new JLabel("Date fin de la réparation : *");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        endDateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(endDateLabel, c);

        finishDateSpinner = new JSpinner(new SpinnerDateModel());
        finishDateEditor = new JSpinner.DateEditor(finishDateSpinner,"dd-MM-yyyy");
        finishDateSpinner.setEditor(finishDateEditor);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        finishDateSpinner.setEnabled(finishDate);
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(finishDateSpinner, c);

        if (infosRepairSheet == null || !infosRepairSheet.get(2).equals("null")) {
            finishDate = true;
        }
        haveFinishDate = new Checkbox("", finishDate);
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 50);
        c.weighty = 1;
        CheckBoxFinishDate finishDateListener = new CheckBoxFinishDate();
        haveFinishDate.addItemListener(finishDateListener);
        add(haveFinishDate, c);

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
        CheckBoxListener checked = new CheckBoxListener();
        isUrgentCheck.addItemListener(checked);
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

        numberBikeLabel = new JLabel("Numéro du vélo :");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        numberBikeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(numberBikeLabel, c);

        ApplicationController controller = new ApplicationController();
        ArrayList<Integer> numbers = controller.pickAllBike();
        String[] bikeNumber = new String[16];
        bikeNumber[0] = "";
        for (int i = 1; i <= 15; i++) {
            bikeNumber[i] = "" + numbers.get(i - 1);
        }

        numberBikeList = new JComboBox(bikeNumber);
        numberBikeList.setMaximumRowCount(4);
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        ListenerBikeNumberSelected listenerBikeNumberSelected = new ListenerBikeNumberSelected();
        numberBikeList.addItemListener(listenerBikeNumberSelected);
        add(new JScrollPane(numberBikeList), c);

        stationLabel = new JLabel("Station émétrice");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        stationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(stationLabel, c);

        String[] stationData = {"", "Bruxelles", "Namur", "Liège", "Charleroi"};
        stationList = new JComboBox(stationData);
        stationList.setMaximumRowCount(4);
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);
        ComboBoxListener comboBoxListener = new ComboBoxListener();
        stationList.addItemListener(comboBoxListener);
        add(new JScrollPane(stationList), c);

        informationLabel = new JLabel("* sont des champs facultatifs");
        c.gridx = 0;
        c.gridy = 7;
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
            c.gridy = 8;
            c.insets = new Insets(0, 0 ,0, 0);
            add(backButton, c);

            idText.setText(infosRepairSheet.get(0));

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date date = df.parse(infosRepairSheet.get(1));
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            startDateSpinner.setValue(date);

            if (!infosRepairSheet.get(2).equals("null")) {
                DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
                Date date2 = df2.parse(infosRepairSheet.get(2));
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(date2);
                finishDateSpinner.setValue(date2);
            }
            if (!infosRepairSheet.get(4).equals("null")) {
                remarkArea.setText(infosRepairSheet.get(4));
            }
            numberBikeList.setSelectedItem(infosRepairSheet.get(5));
            stationList.setSelectedItem(infosRepairSheet.get(6));
            modifyButton = new JButton("Modifier");
            ButtonListenerModify buttonListenerModify = new ButtonListenerModify();
            modifyButton.addActionListener(buttonListenerModify);
            ButtonListenerBack buttonListenerBack = new ButtonListenerBack();
            backButton.addActionListener(buttonListenerBack);
        }

        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(0, 0 ,0, 0);
        add(modifyButton, c);
    }

    public class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            isUrgent = event.getStateChange() == ItemEvent.SELECTED;
        }
    }

    public class CheckBoxFinishDate implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            finishDate = event.getStateChange() == ItemEvent.SELECTED;
            finishDateSpinner.setEnabled(finishDate);
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
                    stationNameSelected = null;
                    break;
            }
        }
    }

    public class ListenerBikeNumberSelected implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            bikeNumberSelected = numberBikeList.getSelectedIndex();
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

                String startDate = new SimpleDateFormat("yyyy-MM-dd").format(startDateSpinner.getValue());

                ArrayList<String> result = controller.searchEmployeeInfo(loginID);
                String stringIdEmployee = result.get(4);

                Integer idRepair = Integer.parseInt(idText.getText());
                Integer idEmployee = Integer.parseInt(stringIdEmployee);

                String finishDateConvert = null;
                if (finishDate) {
                    finishDateConvert = new SimpleDateFormat("yyyy-MM-dd").format(finishDateSpinner.getValue());
                }

                if (bikeNumberSelected == 0) {
                    throw new JTextFieldEmptyException("Numéro du vélo");
                }

                Repair repair = new Repair(idRepair, idEmployee, startDate, finishDateConvert, isUrgent, remarkArea.getText(), bikeNumberSelected, stationNameSelected);

                controller.addRepairSheet(repair);
            } catch (JTextFieldEmptyException | AddRepairException e) {
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

                String startDateConvert = new SimpleDateFormat("yyyy-MM-dd").format(startDateSpinner.getValue());

                ArrayList<String> result = controller.searchEmployeeInfo(loginID);
                String stringIdEmployee = result.get(4);

                Integer idRepair = Integer.parseInt(idText.getText());
                Integer idEmployee = Integer.parseInt(stringIdEmployee);

                String finishDateConvert = null;
                if (finishDate) {
                    finishDateConvert = new SimpleDateFormat("yyyy-MM-dd").format(finishDateSpinner.getValue());
                }

                if (bikeNumberSelected == 0) {
                    throw new JTextFieldEmptyException("Numéro du vélo");
                }

                Repair repair = new Repair(idRepair, idEmployee, startDateConvert, finishDateConvert, isUrgent, remarkArea.getText(), bikeNumberSelected, stationNameSelected);

                controller.modifyRepairSheet(repair);
            } catch (JTextFieldEmptyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}