package codemarket.control;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CadastroFuncionarioViewController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private Label labelCPFCNPJ;
    @FXML
    private TextField cpfcnpj;
    @FXML
    private DatePicker dataNASC;
    @FXML
    private TextField ddd;
    @FXML
    private TextField fone;
    @FXML
    private TextField numero;
    @FXML
    private TextField cep;
    @FXML
    private Button imgButton;
    @FXML
    private ImageView img;
    
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
        imgButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            // Abrir o diálogo de seleção de arquivo
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            
            if (selectedFile != null) {
                // Carregar a imagem selecionada
                Image image = new Image(selectedFile.toURI().toString());
                
                // Definir a imagem no ImageView
                img.setImage(image);
            }
        });
    }    

    @FXML
    private void validarCPFCNPJ(KeyEvent event) {
        String texto = cpfcnpj.getText();
        if (!texto.matches("[0-9]*")) {
            // Só aceita valores numéricos
            cpfcnpj.setText(texto.replaceAll("[^0-9]", ""));
        }
        // Formatação para CPF "999.999.999-99"
        cpfcnpj.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
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
    
}
