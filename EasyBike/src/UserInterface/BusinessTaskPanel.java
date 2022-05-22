package UserInterface;

import Controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;
import Exception.JTextFieldEmptyException;

public class BusinessTaskPanel extends JPanel{
    private JSpinner startDateSpinner, finishDateSpinner;
    private JSpinner.DateEditor startDateEditor, finishDateEditor;
    private JLabel startDateLabel, finishDateLabel, firstNbSubscriptionsOrderLabel, secondNbSubscriptionsOrderLabel, discountLabel;
    private JButton researchButton, discountButton;
    private JTextField discountText;
    private ArrayList<Integer> nbSubscriptionsInOrder;
    private JFrame employeeWindow;
    private Container container;


    public BusinessTaskPanel(Container container, JFrame employeeWindow, Boolean isResearch, ArrayList<Integer> nbSubscriptionsInOrder){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        this.employeeWindow = employeeWindow;
        this.container = container;

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

        if (isResearch){
            firstNbSubscriptionsOrderLabel = new JLabel("Nombre d'abonnements en ordre à la première date : " + nbSubscriptionsInOrder.get(0));
        }else {
            firstNbSubscriptionsOrderLabel = new JLabel("Nombre d'abonnements en ordre à la première date : ...");
        }
        firstNbSubscriptionsOrderLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(firstNbSubscriptionsOrderLabel, c);

        if (isResearch){
            secondNbSubscriptionsOrderLabel = new JLabel("Nombre d'abonnements en ordre à la seconde date : " + nbSubscriptionsInOrder.get(1));
        }else {
            secondNbSubscriptionsOrderLabel = new JLabel("Nombre d'abonnements en ordre à la seconde date : ...");
        }
        secondNbSubscriptionsOrderLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 0, 0);
        c.weighty = 1;
        add(secondNbSubscriptionsOrderLabel, c);

        discountLabel = new JLabel("Montant de la réduction à appliquer (en pourcentage) : ");
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
        if (isResearch){
            discountButton.setEnabled(true);
        }else {
            discountButton.setEnabled(false);
        }
        add(discountButton, c);
        DiscountButtonListener discountButtonListener = new DiscountButtonListener();
        discountButton.addActionListener(discountButtonListener);


    }

    public class ResearchButtonListener implements ActionListener{
        private ApplicationController controller = new ApplicationController();

        @Override
        public void actionPerformed(ActionEvent e) {

            //changer l'exception par la suite
            try {
                nbSubscriptionsInOrder = controller.nbSubsritpionsInOrder((Date)startDateSpinner.getValue(),(Date)finishDateSpinner.getValue());
                container.removeAll();
                container.setLayout(new BorderLayout());
                container.add(new BusinessTaskPanel(container,employeeWindow, true, nbSubscriptionsInOrder), BorderLayout.CENTER);
                container.repaint();
                employeeWindow.setVisible(true);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    public class DiscountButtonListener implements ActionListener{
        private Double discount;

        @Override
        public void actionPerformed(ActionEvent e) {
            ApplicationController controller = new ApplicationController();

            try {
                if (Objects.equals(discountText.getText(), "")) {
                    throw new JTextFieldEmptyException("Identifiant fiche");
                }

                discount = Double.parseDouble(discountText.getText());
                if (discount <= 0) {
                    //lancer erreur de pourcenetage invalide
                }

                controller.activateDiscount(discount);

                System.out.println(discountText.getText());

            }catch (JTextFieldEmptyException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
