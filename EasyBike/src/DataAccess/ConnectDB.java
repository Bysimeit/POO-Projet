package DataAccess;

import java.sql.*;

public class ConnectDB {
    private final String url = "jdbc:mysql://82.165.120.162:3306/EasyBike";
    private final String userName = "program";
    private final String password = "SaucissonPower";

    private Connection connect;

    public ConnectDB() {
        try {
            this.connect = (Connection) DriverManager.getConnection(url, userName, password);
            System.out.println("Database connected !");
        } catch (SQLException e) {
            throw new IllegalStateException("Error to connect :", e);
        }
    }

    public Connection getConnect() {
        return this.connect;
    }
}
