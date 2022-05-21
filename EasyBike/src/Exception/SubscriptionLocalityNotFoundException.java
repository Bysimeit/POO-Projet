package Exception;

import javax.swing.*;

public class SubscriptionLocalityNotFoundException extends Exception {
    public SubscriptionLocalityNotFoundException() {
        JOptionPane.showMessageDialog(null, getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public String getMessage() {
        return "Pas d'abonnement actif dans cette localité !";
    }
}
