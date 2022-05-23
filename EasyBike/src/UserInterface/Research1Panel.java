package UserInterface;

import Controller.ApplicationController;
import Model.Locality;
import Model.ResearchInfos1;
import Exception.SubscriptionLocalityNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Objects;

public class Research1Panel extends JPanel{
    private JComboBox localityCombo;
    private JLabel localityLabel, nationalNumberLabel, firstNameLabel, nameLabel, streetLabel, houseNumberLabel, customerNumberLabel, priceLabel;
    private Container mainContainer;

    public Research1Panel(Container mainContainer){
        this.mainContainer = mainContainer;
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        localityLabel = new JLabel("Recherche les membres d'une localité : ");
        localityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(localityLabel, c);

        localityLabel = new JLabel("Sélectonner localité : ");
        localityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 150, 0);
        c.weighty = 1;
        add(localityLabel, c);

        ApplicationController controller = new ApplicationController();
        ArrayList<Locality> localities = controller.pickAllLocality();
        String[] locality = new String[2901];
        for (int i = 0; i < 2901; i++) {
            locality[i] = localities.get(i).getPostalCode() + " " + localities.get(i).getName();
        }

        localityCombo = new JComboBox(locality);
        localityCombo.setMaximumRowCount(10);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 150, 0);
        c.weighty = 0;
        ComboBoxListener listener = new ComboBoxListener();
        localityCombo.addItemListener(listener);
        add(localityCombo, c);
        setVisible(true);
    }

    private class ComboBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            ApplicationController controller = new ApplicationController();
            ArrayList<ResearchInfos1> result = controller.selectResearchInfos1(localityCombo.getSelectedIndex() + 1);
            if (!result.isEmpty()) {
                mainContainer.removeAll();
                mainContainer.setLayout(new BorderLayout());
                mainContainer.add(new ListResearch1(result));
                mainContainer.revalidate();
                mainContainer.repaint();
            }
        }
    }
}
