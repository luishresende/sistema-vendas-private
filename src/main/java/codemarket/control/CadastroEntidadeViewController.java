package codemarket.control;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CadastroEntidadeViewController implements Initializable {

    @FXML
    private ComboBox<String> tipoCliente;

    @FXML
    private ComboBox<String> tipoSexo;

    @FXML
    private Label labelCPFCNPJ;

    @FXML
    private DatePicker dataNASC;

    @FXML
    private TextField cpfcnpj;

    @FXML
    private TextField ddd;

    @FXML
    private TextField fone;

    @FXML
    private TextField numero;

    @FXML
    private TextField cep;
    
    private Stage dialogStage;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    // Função para limpara o campo e ativar e desativar campos de pessoa Fisica 
    @FXML
    void onTipoClienteChanged(ActionEvent event) {
        String tipoSelecionado = tipoCliente.getValue(); // Obtém o tipo selecionado na ComboBox
        if ("Jurídico".equals(tipoSelecionado)) {
            // Formatação para CNPJ
            labelCPFCNPJ.setText("CNPJ");
            tipoSexo.setDisable(true);
            dataNASC.setDisable(true);
        } else if ("Físico".equals(tipoSelecionado)) {
            // Formatação para CPF
            labelCPFCNPJ.setText("CPF");
            tipoSexo.setDisable(false);
            dataNASC.setDisable(false);
        } else {
            labelCPFCNPJ.setText("CPF / CNPJ");
            tipoSexo.setDisable(true);
            dataNASC.setDisable(true);
        }
        cpfcnpj.clear();
        tipoSexo.setValue("Selecione...");
    }

    // Só valida a entrada de valores numéricos e formata de acordo o tipo de cliente
    @FXML
    void validarCPFCNPJ(KeyEvent event) {
        String texto = cpfcnpj.getText();
        if (!texto.matches("[0-9]*")) {
            // Só aceita valores numéricos
            cpfcnpj.setText(texto.replaceAll("[^0-9]", ""));
        }
        String tipoSelecionado = tipoCliente.getValue(); // Obtém o tipo selecionado na ComboBox 
        if (texto.length() == 14 && "Jurídico".equals(tipoSelecionado)) {
            // Formatação para CNPJ "99.999/9999-99"
            cpfcnpj.setText(texto.substring(0, 2) + "." + texto.substring(2, 5) + "." + texto.substring(5, 8) + "/" + texto.substring(8, 12) + "-" + texto.substring(12));
        } else if (texto.length() == 11 && "Físico".equals(tipoSelecionado)) {
            // Formatação para CPF "999.999.999-99"
            cpfcnpj.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
        } 
    }

    // DDD
    @FXML
    private void validarDDD(KeyEvent event) {
        String texto = ddd.getText();
        if (!texto.matches("[0-9]*")) {
            ddd.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 2) {
            // Formatação para "(DD)"
            ddd.setText("(" + texto + ")");
        }
    }

    // Telefone
    @FXML
    private void validarFONE(KeyEvent event) {
        String texto = fone.getText();
        if (!texto.matches("[0-9]*")) {
            fone.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 9) {
            // Formatação para "(DD)"
            fone.setText(texto.substring(0, 1) + " " + texto.substring(1, 5) + "-" + texto.substring(5, 9));
        }
        if (texto.length() >= 9) {
            event.consume(); // Impede que mais de 2 caracteres sejam inseridos
        }
    }

    // Numero
    @FXML
    private void validarNUM(KeyEvent event) {
        String texto = numero.getText();
        if (!texto.matches("[0-9]*")) {
            numero.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    // CEP
    @FXML
    private void validarCEP(KeyEvent event) {
        String texto = cep.getText();
        if (!texto.matches("[0-9]*")) {
            cep.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 8) {
            cep.setText(texto.substring(0, 5) + " - " + texto.substring(5, 8));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* --------------- Combo Box - Tipo de Cliente ---------------------- */
        // Adicionando dados do Tipo de Cliente
        ObservableList<String> tipo = FXCollections.observableArrayList(
                "Selecione...",
                "Físico",
                "Jurídico"
        );
        tipoCliente.setItems(tipo);
        /* ------------------------------------------------------------------ */

        /* ----------------- Combo Box - Tipo de Sexo ----------------------- */
        // Adicionando dados do Tipo de Sexo
        ObservableList<String> sexo = FXCollections.observableArrayList(
                "Selecione...",
                "Masculino",
                "Feminino",
                "Outro"
        );
        tipoSexo.setItems(sexo);
        /* ------------------------------------------------------------------ */
    }

}
