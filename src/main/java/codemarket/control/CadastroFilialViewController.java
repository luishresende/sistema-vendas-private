package codemarket.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CadastroFilialViewController implements Initializable {

    @FXML
    private Label tituloJanela;    
    @FXML
    private TextField cnpj;
    @FXML
    private CheckBox checkIE;
    @FXML
    private TextField ie;
    @FXML
    private CheckBox checkIM;
    @FXML
    private TextField im;
    @FXML
    private TextField numero;
    @FXML
    private TextField cep;
    @FXML
    private TextField ddd;
    @FXML
    private TextField fone;

    private Stage dialogStage;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setTituloJanela(String titulo) {
        this.tituloJanela.setText(titulo);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void validarCNPJ(KeyEvent event) {
        String texto = cnpj.getText();
        if (!texto.matches("[0-9]*")) {
            cnpj.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 14) {
            // Formatação para "9 9999-9999"
            cnpj.setText(texto.substring(0, 2) + "." + texto.substring(2, 5) + "." + texto.substring(5, 8) + "/" + texto.substring(8, 12) + "-" + texto.substring(12));
        }
        if (texto.length() >= 14) {
            event.consume();
        }
    }

    @FXML
    private void isentoIE(ActionEvent event) {
        if (checkIE.isSelected()) {
            ie.setDisable(true);
        } else {
            ie.setDisable(false);
        }
    }

    @FXML
    private void validarIE(KeyEvent event) {
        String texto = ie.getText();
        if (!texto.matches("[0-9]*")) {
            ie.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    @FXML
    private void isentoIM(ActionEvent event) {
        if (checkIM.isSelected()) {
            im.setDisable(true);
        } else {
            im.setDisable(false);
        }
    }

    @FXML
    private void validarIM(KeyEvent event) {
        String texto = im.getText();
        if (!texto.matches("[0-9]*")) {
            im.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    @FXML
    private void validarNUM(KeyEvent event) {
        String texto = numero.getText();
        if (!texto.matches("[0-9]*")) {
            numero.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

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
        if (texto.length() >= 2) {
            event.consume(); // Impede que mais de 2 caracteres sejam inseridos
        }
    }

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
    
}
