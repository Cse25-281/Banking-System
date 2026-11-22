package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public int saveAccount(int customerId, String accountType, double balance) {
        String sql = "INSERT INTO accounts(customer_id, account_type, balance) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);
            statement.setString(2, accountType);
            statement.setDouble(3, balance);
            statement.executeUpdate();

            try (PreparedStatement idStatement =
                     connection.prepareStatement("SELECT last_insert_rowid()");
                 ResultSet result = idStatement.executeQuery()) {

                if (result.next()) {
                    return result.getInt(1);
                }
            }

        } catch (SQLException e) {
            System.out.println("Could not save account: " + e.getMessage());
        }

        return 0;
    }

    public void updateBalance(int accountId, double newBalance) {
        String sql = "UPDATE accounts SET balance = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, newBalance);
            statement.setInt(2, accountId);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not update balance: " + e.getMessage());
        }
    }
}