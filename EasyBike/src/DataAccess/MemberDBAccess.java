package DataAccess;

import Controller.MemberDataAccess;
import Exception.LoginConnectionException;
import Model.Register;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class MemberDBAccess implements MemberDataAccess {
    private static Connection singletonConnection;

    public void setMemberRegister(String nameText, String firstNameText, String birthdayText, String nationalNumberText, String emailText, String passwordText, String phoneText, String GSMText, String streetText, String numberStreetText, String postalCodeText, String signatureText) {
        singletonConnection = SingletonConnection.getInstance();

        streetText = streetText.replaceAll(" ", "_").toLowerCase();

        String searchLocality = "SELECT id FROM locality WHERE postalcode = " + postalCodeText;
        String insertAddress = "INSERT INTO address (locality, street, housenumber) VALUES (?, ?, ?)";
        String searchIdLocation = "SELECT id FROM address WHERE street = \"" + streetText + "\"";
        String insertMember = "INSERT INTO member (nationalnumber, location, name, firstname, dateofbirth, email, password, titulariat, phone, gsm, signature) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(searchLocality);
            ResultSet data = preparedStatement.executeQuery();
            data.next();
            int idLocality = data.getInt("id");

            preparedStatement = singletonConnection.prepareStatement(insertAddress);
            preparedStatement.setInt(1, idLocality);
            preparedStatement.setString(2, streetText);
            preparedStatement.setString(3, numberStreetText);
            int nbLinesChanged = preparedStatement.executeUpdate();

            preparedStatement = singletonConnection.prepareStatement(searchIdLocation);
            data = preparedStatement.executeQuery();
            data.next();
            int idAddress = data.getInt("id");

            preparedStatement = singletonConnection.prepareStatement(insertMember);
            preparedStatement.setInt(1, Integer.parseInt(nationalNumberText));
            preparedStatement.setInt(2, idAddress);
            preparedStatement.setString(3, nameText);
            preparedStatement.setString(4, firstNameText);

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date birthdayDate = format.parse(birthdayText);
            GregorianCalendar dateToSend = new GregorianCalendar();
            dateToSend.setTime(birthdayDate);
            preparedStatement.setDate(5, new java.sql.Date(dateToSend.getTimeInMillis()));

            preparedStatement.setString(6, emailText);

            MessageDigest hash256 = MessageDigest.getInstance("SHA-256");
            hash256.update(passwordText.getBytes());
            byte[] digest = hash256.digest();
            StringBuffer passwordHashed = new StringBuffer();
            for (byte d : digest) {
                passwordHashed.append(String.format("%02x", d & 0xff));
            }
            preparedStatement.setString(7, passwordHashed.toString());

            preparedStatement.setNull(8, Types.INTEGER);

            if (phoneText == null) {
                preparedStatement.setNull(9, Types.INTEGER);
            } else {
                preparedStatement.setInt(9, Integer.parseInt(phoneText));
            }
            if (GSMText == null) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, Integer.parseInt(GSMText));
            }
            if (signatureText == null) {
                preparedStatement.setNull(11, Types.INTEGER);
            } else {
                preparedStatement.setString(11, signatureText);
            }

            nbLinesChanged = preparedStatement.executeUpdate();
            System.out.println(nbLinesChanged + " line changed successfully !");

            singletonConnection.close();

            System.out.println("New member added successfully to the DB !");
        } catch (SQLException | NoSuchAlgorithmException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

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
            String checkEMail = "SELECT nationalnumber FROM member WHERE email = \"" + eMail + "\" AND password = \"" + passwordHashed.toString() + "\"";
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(checkEMail);

            ResultSet data = preparedStatement.executeQuery();
            data.next();
            int idUser = data.getInt("nationalnumber");
            System.out.println("User found successfully ! National Number : " + idUser);

            preparedStatement.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, new LoginConnectionException().getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
}
