package DataAccess;

import java.sql.Connection;

public class SingletonConnection {
    private static Connection connect;

    private SingletonConnection() {
        connect = new ConnectDB().getConnect();
    }

    public static Connection getInstance() {
        if (connect == null) {
            new SingletonConnection();
        }
        return connect;
    }
}
