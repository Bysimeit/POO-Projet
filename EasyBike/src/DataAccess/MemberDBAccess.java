package DataAccess;

import Interfaces.MemberDataAccess;
import Exception.LoginConnectionException;
import Model.Locality;
import Model.ResearchInfos1;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class MemberDBAccess implements MemberDataAccess {
    private static Connection singletonConnection;

    public void setMemberRegister(String nameText, String firstNameText, String birthdayText, String nationalNumberText, String emailText, String passwordText, String phoneText, String GSMText, String streetText, String numberStreetText, String postalCodeText, String signatureText) {
        singletonConnection = SingletonConnection.getInstance();

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

            if (Objects.equals(phoneText, "")) {
                preparedStatement.setNull(9, Types.INTEGER);
            } else {
                preparedStatement.setInt(9, Integer.parseInt(phoneText));
            }
            if (Objects.equals(GSMText, "")) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, Integer.parseInt(GSMText));
            }
            if (Objects.equals(signatureText, "")) {
                preparedStatement.setNull(11, Types.INTEGER);
            } else {
                preparedStatement.setString(11, signatureText);
            }

            nbLinesChanged = preparedStatement.executeUpdate();
            System.out.println(nbLinesChanged + " line changed successfully !");

            preparedStatement.close();

            System.out.println("New member added successfully to the DB !");
            JOptionPane.showMessageDialog(null, "Inscription enregistrée !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | NoSuchAlgorithmException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

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
            String checkEMail = "SELECT nationalnumber FROM member WHERE email = \"" + eMail + "\" AND password = \"" + passwordHashed.toString() + "\"";
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(checkEMail);

            ResultSet data = preparedStatement.executeQuery();
            data.next();
            int idUser = data.getInt("nationalnumber");
            System.out.println("Member found successfully ! National Number : " + idUser);

            preparedStatement.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, new LoginConnectionException().getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public ArrayList<Locality> pickAllLocality() {
        ArrayList<Locality> result = new ArrayList<Locality>();

        try {
            singletonConnection = SingletonConnection.getInstance();

            String query = "SELECT * FROM locality";

            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                result.add(new Locality(data.getInt(1), data.getInt(2), data.getString(3)));
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return result;
    }

    public ArrayList<ResearchInfos1> selectResearchInfos1(int idLocality) {
        ArrayList<ResearchInfos1> result = new ArrayList<ResearchInfos1>();

        try {
            singletonConnection = SingletonConnection.getInstance();

            String query1 = "SELECT m.nationalnumber, m.firstname, m.name, a.street, a.housenumber, c.customernumber, s.price FROM member m JOIN address a ON (m.location = a.id) JOIN card c ON (m.nationalnumber = c.member) JOIN subscription s ON (c.correspondence = s.id) WHERE m.location = ANY (SELECT id FROM EasyBike.address WHERE locality = " + idLocality + ")";

            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query1);
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                result.add(new ResearchInfos1(data.getInt(1), data.getString(2), data.getString(3), data.getString(4), data.getInt(5), data.getInt(6), data.getDouble(7)));
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return result;
    }

    public ArrayList<Integer> selectNbSoucriptionsInOrder(Date date1, Date date2) {
        ArrayList<Integer> nbSubscriptionsInOrder = new ArrayList<Integer>();

        //voir si on fait une boucle pour regrouper les deux requêtes
        try {
            singletonConnection = SingletonConnection.getInstance();

            String query1 = "SELECT COUNT(r.suscription) FROM repetition r WHERE r.isorder is not null AND r.startdate = " + date1;

            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query1);
            ResultSetMetaData data = preparedStatement.getMetaData();
            System.out.println(data.getColumnCount());
            nbSubscriptionsInOrder.add(data.getColumnCount());


            String query2 = "SELECT COUNT(r.suscription) FROM repetition r WHERE r.isorder is not null AND r.startdate = " + date2;

            preparedStatement = singletonConnection.prepareStatement(query2);
            data = preparedStatement.getMetaData();
            System.out.println(data.getColumnCount());
            nbSubscriptionsInOrder.add(data.getColumnCount());

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return nbSubscriptionsInOrder;
    }
}
