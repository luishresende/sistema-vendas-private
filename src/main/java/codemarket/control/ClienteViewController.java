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
import javafx.stage.StageStyle;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml")); // Aqui pode ser aberto várias vezes a tela
//        loader.setLocation(codemarket.control.CadastroEntidadeViewController.class.getResource("/view/CadastroEntidadeView.fxml")); // Aqui estava dando problema, só podia abrir uma vez
        AnchorPane page = (AnchorPane) loader.load();
        
        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Cliente");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
//        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Cliente");
        controller.setDialogStage(dialogStage);
        
        dialogStage.showAndWait();
    }
    
    @FXML
    void handleButtonEditar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Editar Cliente");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
//        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Editar Cadastro do Cliente");
        controller.setDialogStage(dialogStage);
    
        dialogStage.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}