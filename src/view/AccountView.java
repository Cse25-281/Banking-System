package view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AccountView extends VBox {

    private Label accountNumberLabel;
    private Label balanceLabel;
    private TextField amountField;
    private Button depositButton;
    private Button withdrawButton;
    private Button logoutButton;

    public AccountView() {

        Label title = new Label("CUSTOMER ACCOUNT");

        accountNumberLabel = new Label("Account Number: Not selected");
        balanceLabel = new Label("Balance: BWP 0.00");

        amountField = new TextField();
        amountField.setPromptText("Enter amount");

        depositButton = new Button("Deposit");
        withdrawButton = new Button("Withdraw");
        logoutButton = new Button("Logout");

        setSpacing(15);
        setPadding(new Insets(30));
        setAlignment(Pos.CENTER);

        getChildren().addAll(
            title,
            accountNumberLabel,
            balanceLabel,
            amountField,
            depositButton,
            withdrawButton,
            logoutButton
        );

        setMaxWidth(350);
    }

    public String getAmount() {
        return amountField.getText();
    }

    public Button getDepositButton() {
        return depositButton;
    }

    public Button getWithdrawButton() {
        return withdrawButton;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }

    public void setAccountNumber(String number) {
        accountNumberLabel.setText("Account Number: " + number);
    }

    public void setBalance(double balance) {
        balanceLabel.setText(
            String.format("Balance: BWP %.2f", balance)
        );
    }
}