package UserInterface;

import Controller.ApplicationController;
import Model.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DashboardPanel extends JPanel {
    private JLabel helloLabel, jobLabel, chiefLabel;
    private JFrame employeeWindow, loginWindow;

    public DashboardPanel(JFrame employeeWindow, JFrame loginWindow, Register loginID){
        this.employeeWindow = employeeWindow;
        this.loginWindow = loginWindow;

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        ApplicationController controller = new ApplicationController();
        ArrayList<String> infosUser = controller.searchEmployeeInfo(loginID);

        //main area
        helloLabel = new JLabel("Ravi de vous revoir : " + infosUser.get(0) + " " + infosUser.get(1));
        helloLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(15, 0, 0, 10);
        c.weighty = 1;
        add(helloLabel, c);

        jobLabel = new JLabel("Votre fonction est : " + infosUser.get(3));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 0, 10);
        jobLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(jobLabel, c);

        String responsiblefor = "Votre resonsable est : ";
        if (infosUser.get(2).equals("0")) {
            responsiblefor = "Vous êtes le responsable.";
        } else {
            ArrayList<String> responsible = controller.searchResponsibleInfo(Integer.parseInt(infosUser.get(2)));
            responsiblefor += responsible.get(0) + " " + responsible.get(1);
        }
        chiefLabel = new JLabel(responsiblefor);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 30, 10);
        chiefLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(chiefLabel, c);
    }

}
