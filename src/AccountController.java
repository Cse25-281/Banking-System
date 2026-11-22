import javafx.scene.control.Alert;

public class AccountController {

    private AccountView accountView;
    private Account account;

    public AccountController(AccountView accountView, Account account) {

        this.accountView = accountView;
        this.account = account;

        accountView.getDepositButton().setOnAction(event -> handleDeposit());
        accountView.getWithdrawButton().setOnAction(event -> handleWithdraw());

        accountView.setBalance(account.getBalance());
    }

    private void handleDeposit() {

        try {
            double amount = Double.parseDouble(accountView.getAmount());

            if (amount <= 0) {
                showMessage("Enter an amount greater than zero.");
                return;
            }

            account.deposit(amount);
            accountView.setBalance(account.getBalance());
            showMessage("Deposit successful!");

        } catch (NumberFormatException e) {
            showMessage("Please enter a valid amount.");
        }
    }

    private void handleWithdraw() {

        try {
            double amount = Double.parseDouble(accountView.getAmount());

            if (amount <= 0) {
                showMessage("Enter an amount greater than zero.");
                return;
            }

            if (account.withdraw(amount)) {
                accountView.setBalance(account.getBalance());
                showMessage("Withdrawal successful!");
            } else {
                showMessage("Withdrawal was unsuccessful.");
            }

        } catch (NumberFormatException e) {
            showMessage("Please enter a valid amount.");
        }
    }

    private void showMessage(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Banking System");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}