package Exception;

import javax.swing.*;

public class SubscriptionLocalityNotFoundException extends Exception {
    private String error;

    public SubscriptionLocalityNotFoundException(String error) {
        this.error = error;
    }
    public String getMessage() {
        return "Pas d'abonnement actif dans cette localité !";
    }
}
