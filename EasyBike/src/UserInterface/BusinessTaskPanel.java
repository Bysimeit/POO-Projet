package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusinessTaskPanel extends JPanel{
    private JSpinner startDateSpinner, finishDateSpinner;
    private JSpinner.DateEditor startDateEditor, finishDateEditor;
    private JLabel startDateLabel, finishDateLabel, firstNbSubscriptionsOrderLabel, secondNbSubscriptionsOrderLabel, discountLabel;
    private JButton researchButton, discountButton;
    private JTextField discountText;


    public BusinessTaskPanel(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

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
        add(researchButton, c);
        ResearchButtonListener researchButtonListener = new ResearchButtonListener();
        researchButton.addActionListener(researchButtonListener);

        firstNbSubscriptionsOrderLabel = new JLabel("Nombre d'abonnements en ordre à la première date : ...");
        firstNbSubscriptionsOrderLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(firstNbSubscriptionsOrderLabel, c);

        secondNbSubscriptionsOrderLabel = new JLabel("Nombre d'abonnements en ordre à la seconde date : ...");
        secondNbSubscriptionsOrderLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(secondNbSubscriptionsOrderLabel, c);

        discountLabel = new JLabel("Montant de la réduction à appliquer : ");
        discountLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(discountLabel, c);

        discountText = new JTextField(8);
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 0, 0);
        add(discountText, c);

        discountButton = new JButton("Appliquer une réduction");
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(discountButton, c);
        DiscountButtonListener discountButtonListener = new DiscountButtonListener();
        discountButton.addActionListener(discountButtonListener);


    }

    public class ResearchButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class DiscountButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
