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
        SettingsFile settings = new SettingsFile();
        settings.updateCSSFile();
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
        Scene scene = new Scene(root);

        scene.widthProperty().addListener((obervable, oldValue, newValue) -> {
            double width = newValue.doubleValue();
            double height = scene.getHeight();

        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("CodeMarket");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
