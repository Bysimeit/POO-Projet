package DataAccess;

import Controller.EmployeeDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDBAccess implements EmployeeDataAccess {
    private static Connection singletonConnection;

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
