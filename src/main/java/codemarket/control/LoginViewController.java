package codemarket.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    private boolean logged = false;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleButtonDBSettings() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DialogDatabaseSettingsViewController.class.getResource("/view/DialogDatabaseSettingsView.fxml"));
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
        
        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
        Scene scene = new Scene(root);
        
        //mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.setScene(scene);
        mainStage.setTitle("CodeMarket");
        mainStage.show();
        
    }
}
