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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    }

    @FXML
    private void handleCancelarbutton(ActionEvent event) {
    }
    
}
