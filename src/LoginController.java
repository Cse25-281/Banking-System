import javafx.scene.control.Alert;

public class LoginController {

    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        loginView.getLoginButton().setOnAction(event -> handleLogin());
    }

    private void handleLogin() {

        String username = loginView.getUsername();
        String password = loginView.getPassword();

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Please enter both username and password.");
        } else {
            showMessage("Login details received. Authentication is ready to be connected.");
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