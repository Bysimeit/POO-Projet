package DataAccess;

import Controller.MemberDataAccess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberDBAccess implements MemberDataAccess {
    private static Connection singletonConnection;

    public void setMemberRegister(String nameText, String firstNameText, String birthdayText, String nationalNumberText, String emailText, String passwordText, String phoneText, String GSMText, String streetText, String numberStreetText, String postalCodeText, String signatureText) {
        singletonConnection = SingletonConnection.getInstance();

        String searchLocality = "SELECT id FROM locality WHERE postalcode = " + postalCodeText;
        String insertAddress = "INSERT INTO address (locality, street, housenumber) VALUES (?, ?, ?)";
        String searchIdLocation = "SELECT id address FROM address WHERE street = " + streetText + " AND housenumber = " + numberStreetText;
        String insertMember = "INSERT INTO member (nationalnumber, location, name, firstname, dateofbirth, email, password, titulariat, phone, gsm, signature) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(searchLocality);
            ResultSet data = preparedStatement.executeQuery();
            int idLocality = data.getInt("id");
            System.out.println(idLocality + " searched successfully !");

            preparedStatement = singletonConnection.prepareStatement(insertAddress);
            preparedStatement.setInt(1, idLocality);
            preparedStatement.setString(2, streetText);
            preparedStatement.setString(3, numberStreetText);
            int nbLinesChanged = preparedStatement.executeUpdate();
            System.out.println(nbLinesChanged + " changed successfully !");

            preparedStatement = singletonConnection.prepareStatement(searchIdLocation);
            data = preparedStatement.executeQuery();
            int idAddress = data.getInt("id");

            preparedStatement = singletonConnection.prepareStatement(insertMember);
            preparedStatement.setInt(1, Integer.parseInt(nationalNumberText));
            preparedStatement.setInt(2, idAddress);
            preparedStatement.setString(3, nameText);
            preparedStatement.setString(4, firstNameText);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date birthDate = format.parse(birthdayText);
            preparedStatement.setDate(5, (java.sql.Date) birthDate);
            preparedStatement.setString(6, emailText);

            MessageDigest hash256 = MessageDigest.getInstance("SHA-256");
            hash256.update(passwordText.getBytes());
            byte[] bytes = hash256.digest();
            StringBuilder passwordHashed = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                passwordHashed.append(String.format("%02x", i));
            }
            preparedStatement.setString(7, passwordHashed.toString());
            preparedStatement.setNull(8, Types.INTEGER);
            preparedStatement.setInt(9, Integer.parseInt(phoneText));
            preparedStatement.setInt(10, Integer.parseInt(GSMText));
            preparedStatement.setString(11, signatureText);
            preparedStatement.executeQuery();

            singletonConnection.close();
        } catch (SQLException | ParseException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
