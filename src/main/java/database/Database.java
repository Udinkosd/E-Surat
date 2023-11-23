package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public final Connection connection;

    public Database() {
        this.connection = openConnection();
    }

    public Connection openConnection() {
        Connection conn = null;
        try {
            String dbHost = "localhost";
            String dbName = "database_e_surat";
            String dbUser = "root";
            String dbPass = "";

            String url = "jdbc:mysql://" + dbHost + "/" + dbName;
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            System.out.println("Database Connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database Closed");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to close the database.");
        }
    }
}
