package codemarket.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PDVViewController implements Initializable {

    @FXML
    private TextField subtotal;

    @FXML
    private TextField totalRecebido;

    @FXML
    private TextField troco;

    @FXML
    private TextField quantidade;

    @FXML
    void valorTroco(ActionEvent event) {
        // Converte as strings para números (supondo que os valores sejam números válidos)
        double totalRecebidoValue = Double.parseDouble(totalRecebido.getText());
        double subtotalValue = Double.parseDouble(subtotal.getText());
        // Informa o valor do troco a ser devolvido
        troco.setText(String.valueOf(totalRecebidoValue - subtotalValue));
    }

    @FXML
    private void intRecebido(KeyEvent event) {
        String texto = totalRecebido.getText();

        // Verifique se o evento é um caractere válido
        if (event.getCharacter().matches("[0-9,]")) {
            // Remova todos os caracteres não numéricos, exceto a vírgula
            texto = texto.replaceAll("[^0-9,]", "");
            // Defina o texto formatado de volta no campo de texto
            totalRecebido.setText(texto);
        } else if (event.getCode() == KeyCode.ENTER) {
            // Trate o Enter como confirmação do texto
            // Se o texto não terminar com uma vírgula, adicione vírgula e dois zeros
            if (texto.matches(".*,[0-9]{2}$")) {
                // Não faça nada, pois a formatação já está correta
            } else if (!texto.endsWith(",")) {
                // Se o texto não terminar com uma vírgula, adicione vírgula e dois zeros
                texto = formatarMilhar(texto) + ",00";
            }
            totalRecebido.setText(texto);
            troco.requestFocus();
        } else {
            // Consuma o evento para evitar que outros caracteres inválidos sejam digitados
            event.consume();
        }
    }

    // Função para formatar milhares com ponto
    private String formatarMilhar(String texto) {
        int length = texto.length();
        if (length >= 4) {
            int insertIndex = length - 3;
            texto = texto.substring(0, insertIndex) + "." + texto.substring(insertIndex);
        }
        return texto;
    }

    @FXML
    private void validarQTD(KeyEvent event) {
        String texto = quantidade.getText();
        if (!texto.matches("[0-9]*")) {
            quantidade.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (event.getCode() == KeyCode.ENTER) {
            totalRecebido.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
