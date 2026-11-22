package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    public boolean saveTransaction(int accountId, String transactionType, double amount) {

        String sql = "INSERT INTO transactions " +
                "(account_id, transaction_type, amount) " +
                "VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, accountId);
            statement.setString(2, transactionType);
            statement.setDouble(3, amount);

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Could not save transaction: " + e.getMessage());
            return false;
        }
    }
}