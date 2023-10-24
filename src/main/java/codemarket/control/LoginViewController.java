package codemarket.control;

import codemarket.model.dao.BairroDAOImpl;
import codemarket.model.dao.EstadoDAOImpl;
import codemarket.model.pojo.TbBairro;
import codemarket.model.pojo.TbEstado;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

        TbEstado bairro = new TbEstado("IB", "Ibitira");
        EstadoDAOImpl bai = new EstadoDAOImpl();
        bai.salvar(bairro);
        
    }
}
