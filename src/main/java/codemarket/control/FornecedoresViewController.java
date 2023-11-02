/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FornecedoresViewController implements Initializable {

    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonRemover;
    
    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonCadastrar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Fornecedor");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Fornecedor");
        controller.setDialogStage(dialogStage);
    
        dialogStage.showAndWait();
    }

    @FXML
    private void handleButtonEditar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Editar Fornecedor");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Editar Cadastro do Fornecedor");
        controller.setDialogStage(dialogStage);
    
        dialogStage.showAndWait();
    }

    @FXML
    private void handleButtonRemover() {
    }
    
}
