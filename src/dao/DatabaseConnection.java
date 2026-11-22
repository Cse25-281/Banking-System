package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:data/banking.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Customer (" +
                "customerId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "username TEXT UNIQUE NOT NULL, " +
                "password TEXT NOT NULL)"
            );

            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Account (" +
                "accountId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "customerId INTEGER, " +
                "accountType TEXT NOT NULL, " +
                "balance REAL NOT NULL, " +
                "FOREIGN KEY(customerId) REFERENCES Customer(customerId))"
            );

            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS TransactionRecord (" +
                "transactionId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "accountId INTEGER, " +
                "transactionType TEXT NOT NULL, " +
                "amount REAL NOT NULL, " +
                "transactionDate TEXT, " +
                "FOREIGN KEY(accountId) REFERENCES Account(accountId))"
            );

            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}