package codemarket.control;

import codemarket.model.vo.TbUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

    @FXML
    private AnchorPane anchorPaneLogin;
    @FXML
    private Button buttonBDSettings;
    @FXML
    private Button buttonEntrar;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private TextField textFieldSenha;

    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();
    ;
    private final boolean logged = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleButtonDBSettings() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DialogDatabaseSettingsView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Configurações de banco de dados");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        DialogDatabaseSettingsViewController controller = loader.getController();
        controller.setDialogStage(dialogStage);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();
    }

    @FXML
    public void handleButtonEntrar() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            dialogStage = new Stage();
            dialogStage.setTitle("Main");
            dialogStage.setScene(scene);

            Stage stage = (Stage) buttonEntrar.getScene().getWindow(); // Obtém o palco atual (primaryStage)
            stage.close();

            dialogStage.show();
        } catch (Exception e) {

        }
        buttonEntrar.setDisable(true);
        AuthController auth = new AuthController(textFieldUsuario.getText(), textFieldSenha.getText());
        Thread thread = new Thread(() -> {
            TbUsuario user = auth.authenticate();
            if (user != null) {

            } else {
                buttonEntrar.setDisable(false);
            }
        });
        thread.start();

    }
}
