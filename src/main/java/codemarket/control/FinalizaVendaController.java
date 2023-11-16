/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.model.rn.ClienteRN;
import codemarket.model.rn.TipoPagamentoRN;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iuri Pereira
 */
public class FinalizaVendaController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private Button buttonFinalizar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private CheckBox SemCadastro;
    @FXML
    private ComboBox<String> idCliente;
    @FXML
    private ComboBox<String> TipoPagamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClienteRN clientern = new ClienteRN();
        ArrayList clientes = (ArrayList) clientern.buscarTodos("clicpfCnpj.entNome");
        ObservableList<String> CL = FXCollections.observableArrayList(clientes);
        idCliente.setItems(CL);

        TipoPagamentoRN pagamentorn = new TipoPagamentoRN();
        ArrayList pagamentos = (ArrayList) pagamentorn.buscarTodos("tpDescricao");
        ObservableList<String> PG = FXCollections.observableArrayList(pagamentos);
        TipoPagamento.setItems(PG);

    }

    @FXML
    private void handleFinalizarButton(ActionEvent event) {
        if (TipoPagamento.getValue() != null) {
            if ((SemCadastro.isSelected() && idCliente.getValue() == null) || (!SemCadastro.isSelected() && idCliente.getValue() != null)) {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, Insira um Cliente ou selecione a CheckBox.");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, Insira um Pagamento.");

            alert.showAndWait();
        }

    }

    public CheckBox getSemCadastro() {
        return SemCadastro;
    }

    public ComboBox<String> getIdCliente() {
        return idCliente;
    }

    public ComboBox<String> getTipoPagamento() {
        return TipoPagamento;
    }

    @FXML
    private void handleCancelarbutton(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
