package shop.db_connector;

import java.sql.Connection;
import java.sql.*;

public class DataBaseConnector {
    private static String url = DataBaseProperties.get().getProperty("url");
    private static String user = DataBaseProperties.get().getProperty("user");
    private static String password = DataBaseProperties.get().getProperty("password");

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the database.");
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Disconnected from the database.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
