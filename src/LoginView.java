import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public LoginView() {

        Label title = new Label("BANKING SYSTEM");
        Label subtitle = new Label("Please Login");

        usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        loginButton = new Button("Login");

        setSpacing(15);
        setPadding(new Insets(30));
        setAlignment(Pos.CENTER);

        getChildren().addAll(
            title,
            subtitle,
            usernameField,
            passwordField,
            loginButton
        );

        setMaxWidth(350);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public Button getLoginButton() {
        return loginButton;
    }
}