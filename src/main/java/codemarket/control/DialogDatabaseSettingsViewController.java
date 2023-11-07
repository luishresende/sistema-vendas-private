package codemarket.control;

import codemarket.model.conexao.PersistenceManipulation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DialogDatabaseSettingsViewController implements Initializable {
    @FXML
    private TextField textFieldEnderecoDB;
    @FXML
    private TextField textFieldNomeDB;
    @FXML
    private TextField textFieldUsuarioDB;
    @FXML
    private PasswordField passwordFieldSenhaDB;
    @FXML
    private AnchorPane anchorPaneDBSettings;
    @FXML
    private Button buttonSalvar;

    private Stage dialogStage;
    private boolean buttonSalvarClicked = false;
    private PersistenceManipulation persistenceManipulation;

    
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonSalvarClicked() {
        return buttonSalvarClicked;
    }

    public void setButtonSalvarClicked(boolean buttonSalvarClicked) {
        this.buttonSalvarClicked = buttonSalvarClicked;
    }

    private void displayErrorScreen() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Ocorreu um erro");
        alert.setContentText("Verifique as credenciais informadas e tente novamente!");

        alert.showAndWait();
    }

    @FXML
    public void handlerButtonSalvar() {
        if(persistenceManipulation.updatePersistence(textFieldEnderecoDB.getText(), textFieldUsuarioDB.getText(), passwordFieldSenhaDB.getText(), textFieldNomeDB.getText())){
            getDialogStage().close();
        }else {
            displayErrorScreen();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.persistenceManipulation = new PersistenceManipulation();
        } catch (Exception ex) {
            System.out.println("nao funfou");
        }
    }
}
