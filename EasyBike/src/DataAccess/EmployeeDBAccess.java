package DataAccess;

import Interfaces.EmployeeDataAccess;
import Exception.LoginConnectionException;
import Model.ResearchInfos2;

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

    public boolean loginConnection(String eMail, String password) {
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
            System.out.println("Employee found successfully ! ID number : " + idUser);

            preparedStatement.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, new LoginConnectionException().getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
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

    public ArrayList<String> getInfoEmployee(String eMail) {
        ArrayList<String> result = new ArrayList<String>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT * FROM employee WHERE email = \"" + eMail + "\"";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            data.next();
            result.add(data.getString("name"));
            result.add(data.getString("firstname"));
            result.add(String.valueOf(data.getInt("responsiblefor")));
            result.add(data.getString("function"));
            result.add(String.valueOf(data.getInt("id")));

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public ArrayList<String> getResponsibleInfo(int responsibleID) {
        ArrayList<String> result = new ArrayList<String>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT * FROM employee WHERE id = " + responsibleID;

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            data.next();
            result.add(data.getString("name"));
            result.add(data.getString("firstname"));

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public ArrayList<ResearchInfos2> selectResearchInfos2(String startDate, String finishDate) {
        ArrayList<ResearchInfos2> result = new ArrayList<ResearchInfos2>();
        singletonConnection = SingletonConnection.getInstance();

        String query = "SELECT m.id, m.name, r.date, o.number, o.id FROM employee m JOIN repair r ON (m.id = r.employee) JOIN repairorder o ON (r.id = o.number) WHERE r.date BETWEEN \" " + startDate + " \" AND \" " + finishDate + " \";";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                ResearchInfos2 infoFound = new ResearchInfos2(data.getInt(1), data.getString(2), data.getDate(3), data.getInt(4), data.getInt(5));
                result.add(infoFound);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
