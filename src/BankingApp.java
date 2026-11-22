import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankingApp extends Application {

    @Override
    public void start(Stage stage) {

        LoginView loginView = new LoginView();

        LoginController loginController =
                new LoginController(loginView);

        Scene scene = new Scene(loginView, 500, 400);

        stage.setTitle("Banking System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}