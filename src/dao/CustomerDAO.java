package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public boolean saveCustomer(String name, String username, String password) {

        String sql = "INSERT INTO Customer (name, username, password) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, password);

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Could not save customer: " + e.getMessage());
            return false;
        }
    }

    public boolean authenticate(String username, String password) {

        String sql = "SELECT * FROM Customer WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            return result.next();

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }
}