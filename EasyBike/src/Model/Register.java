package Model;

import Exception.JTextFieldException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Register {
    private String textField;
    private String insertion;
    private ArrayList<String> stringList;

    public Register(JTextField jTextField) throws JTextFieldException {
        setTextField(jTextField);
    }

    public Register(String insert) {
        setInsert(insert);
    }

    public Register() {
        this.stringList = new ArrayList<String>();
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

    public void setInsert(String newInsert) {
        if (Objects.equals(newInsert, "")) {
            this.insertion = null;
        } else {
            this.insertion = newInsert;
        }
    }

    public String getInsert() {
        return this.insertion;
    }

    public void addInsertList(String newAdd) {
        this.stringList.add(newAdd);
    }

    public ArrayList<String> getStringList() {
        return this.stringList;
    }
}
