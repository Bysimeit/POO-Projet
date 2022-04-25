package Exception;

public class JTextFieldEmptyException extends Exception {
    private String jTextFieldEmpty;

    public JTextFieldEmptyException(String jTextFieldEmpty) {
        this.jTextFieldEmpty = jTextFieldEmpty;
    }

    public String getMessage() {
        return "Le champ " + jTextFieldEmpty + " est vide !";
    }
}
