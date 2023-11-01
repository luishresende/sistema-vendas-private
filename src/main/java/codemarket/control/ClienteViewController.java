package codemarket.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClienteViewController implements Initializable {
    
    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonEditar;
    
    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();
    
    @FXML
    void handleButtonCadastrar() throws IOException {
        loader.setLocation(codemarket.control.CadastroEntidadeViewController.class.getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Cliente");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setDialogStage(dialogStage);
    
        dialogStage.showAndWait();
    }
    
    @FXML
    void handleButtonEditar() throws IOException {
        loader.setLocation(codemarket.control.CadastroEntidadeViewController.class.getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Editar Cliente");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setDialogStage(dialogStage);
    
        dialogStage.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}