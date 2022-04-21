package Exception;

import javax.swing.*;

public class AddRegisterException extends Exception {
    private JTextField fieldWrong;

    public AddRegisterException(JTextField fieldWrong) {
        this.fieldWrong = fieldWrong;
    }

    public String getMessage() {
        return "The value " + fieldWrong.getText() + " is wrong !";
    }
}
