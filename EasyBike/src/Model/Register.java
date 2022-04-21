package Model;

import Exception.JTextFieldException;

import javax.swing.*;

public class Register {
    private String textField;

    public Register(JTextField jTextField) throws JTextFieldException {
        setTextField(jTextField);
    }

    public void setTextField(JTextField jTextField) throws JTextFieldException {
        if (jTextField == null) {
            throw new JTextFieldException(null);
        } else {
            this.textField = jTextField.getText();
        }
    }

    public String getTextField() {
        return textField;
    }
}
