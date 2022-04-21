package Exception;

import javax.swing.*;

public class JTextFieldException extends Exception {
    private JTextField jTextFieldWrong;

    public JTextFieldException(JTextField jTextFieldWrong) {
        this.jTextFieldWrong = jTextFieldWrong;
    }

    public String getMessage() {
        return "La valeur " + jTextFieldWrong.getText() + " est mauvaise !";
    }
}
