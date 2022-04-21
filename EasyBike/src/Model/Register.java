package Model;

import Exception.JTextFieldException;

import javax.swing.*;

public class Register {
    private JTextField jTextField;

    public Register(JTextField jTextField) throws JTextFieldException {
        setTextField(jTextField);
    }

    public void setTextField(JTextField jTextField) throws JTextFieldException {
        if (jTextField == null) {
            throw new JTextFieldException(null);
        } else {
            this.jTextField = jTextField;
        }
    }

    public JTextField getJTextField() {
        return jTextField;
    }
}
