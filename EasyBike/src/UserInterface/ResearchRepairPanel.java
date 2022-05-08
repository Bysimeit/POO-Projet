package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchRepairPanel extends JPanel {
    private JTextField bikeText, repairText;
    private JLabel bikeLabel, repairLabel;
    private JButton searchBikeButton, searchRepairButton;
    private Container container;
    private EmployeeWindow employeeWindow;

    public ResearchRepairPanel(Container container, EmployeeWindow employeeWindow) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        this.container = container;
        this.employeeWindow = employeeWindow;

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

        searchRepairButton = new JButton("Recherche");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0 ,70, 0);
        ButtonListener buttonListener = new ButtonListener();
        searchRepairButton.addActionListener(buttonListener);
        add(searchRepairButton, c);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            container.removeAll();
            container.setLayout(new BorderLayout());
            container.add(new RepairSheetPanel(), BorderLayout.CENTER);
            container.repaint();
            employeeWindow.setVisible(true);
        }
    }
}
