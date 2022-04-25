package DataAccess;

import Controller.EmployeeDataAccess;
import Exception.LoginConnectionException;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDBAccess implements EmployeeDataAccess {
    private static Connection singletonConnection;

    public void loginConnection(String eMail, String password) {
        try {
            MessageDigest hash256 = MessageDigest.getInstance("SHA-256");
            hash256.update(password.getBytes());
            byte[] digest = hash256.digest();
            StringBuffer passwordHashed = new StringBuffer();
            for (byte d : digest) {
                passwordHashed.append(String.format("%02x", d & 0xff));
            }

            singletonConnection = SingletonConnection.getInstance();
            String checkEMail = "SELECT id FROM employee WHERE email = \"" + eMail + "\" AND password = \"" + passwordHashed.toString() + "\"";
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(checkEMail);

            ResultSet data = preparedStatement.executeQuery();
            data.next();
            int idUser = data.getInt("id");
            System.out.println("User found successfully ! ID number : " + idUser);

            preparedStatement.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, new LoginConnectionException().getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getEmployeeEMail() {
        singletonConnection = SingletonConnection.getInstance();

        ArrayList<String> eMails = new ArrayList<String>();

        String query = "SELECT email FROM employee";
        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                String eMail = data.getString("email");
                eMails.add(eMail);
            }

            singletonConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eMails;
    }
}
