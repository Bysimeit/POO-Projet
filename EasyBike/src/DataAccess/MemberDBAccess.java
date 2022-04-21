package DataAccess;

import Controller.MemberDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDBAccess implements MemberDataAccess {
    private static Connection singletonConnection;

    public void setMemberRegister(String value, int numCol) {
        singletonConnection = SingletonConnection.getInstance();

        String query = "INSERT INTO member(nationalnumber, location, name, firstname, dateofbirth, email, password, titulariat, phone, gsm, signature) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = singletonConnection.prepareStatement(query);

            singletonConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
