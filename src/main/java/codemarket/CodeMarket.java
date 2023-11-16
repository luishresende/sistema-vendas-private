package codemarket;

import codemarket.model.utils.SettingsFile;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CodeMarket extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        SettingsFile settings = SettingsFile.getInstance();
        settings.updateCSSFile();
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CodeMarket");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
