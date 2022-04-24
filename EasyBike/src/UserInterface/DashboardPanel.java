package UserInterface;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private JLabel helloLabel, jobLabel, chiefLabel;
    private JButton disconnectButton;

    public DashboardPanel(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        //main area
        helloLabel = new JLabel("Ravi de vous revoir : ...");
        helloLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(15, 0, 0, 10);
        c.weighty = 1;
        add(helloLabel, c);

        jobLabel = new JLabel("Votre fonction est : ...");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 0, 10);
        jobLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(jobLabel, c);

        chiefLabel = new JLabel("Votre résponsable est : ...");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(10, 0, 30, 10);
        chiefLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(chiefLabel, c);

        //disconnect button
        c.anchor = GridBagConstraints.SOUTH;
        disconnectButton = new JButton("se déconnecter");
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 0 ,25, 50);
        add(disconnectButton, c);
    }
}
