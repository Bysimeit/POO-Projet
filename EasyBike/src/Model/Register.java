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

    public Register(String name, String firstName, String birthdayDate, String nationalNumber, String eMail, String password, String phone, String GSM, String streetName, String numberStreet, String postalCode, String signature) {
        this.stringList = new ArrayList<String>();
        this.stringList.add(name);
        this.stringList.add(firstName);
        this.stringList.add(birthdayDate);
        this.stringList.add(nationalNumber);
        this.stringList.add(eMail);
        this.stringList.add(password);
        this.stringList.add(phone);
        this.stringList.add(GSM);
        this.stringList.add(streetName);
        this.stringList.add(numberStreet);
        this.stringList.add(postalCode);
        this.stringList.add(signature);
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
