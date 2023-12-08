package codemarket.control;

import codemarket.model.rn.*;
import codemarket.model.vo.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Timestamp;
import java.util.Locale;
import javafx.scene.input.KeyEvent;

public class InserirProdutoController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private TextField idQuantidade, idAvistaMargem, idAvistaValor, idPrazoValor, idCompra, idBarras,
            idDescricao, idPrazoMargem, idCodigo, idMinimo, idGrupo;
    @FXML
    private CheckBox idControle, idProibir;
    @FXML
    private Button idAdicionarGrupo, buttonCadastrar, buttonCancelar;
    @FXML
    private DatePicker idAtualizacao;
    @FXML
    private ComboBox<String> idUnidade;

    private Stage dialogStage;
    Date dataAtual = new Date();
    Timestamp timestamp = new Timestamp(dataAtual.getTime());
    UnidadeMedidaRN UN = new UnidadeMedidaRN();
    EstoqueRN EST = new EstoqueRN();
    
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTituloJanela(String titulo) {
        this.tituloJanela.setText(titulo);
    }
    
    @FXML
    void validaValorCompra(KeyEvent event) {
        EST.aceitaNumero(event, idCompra);
    }
    @FXML
    void validaValorAvista(KeyEvent event) {
        EST.aceitaNumero(event, idAvistaValor);
    }
    @FXML
    void validaMargem(KeyEvent event) {
        EST.aceitaNumero(event, idAvistaMargem);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EST.initializeCurrencyField(idCompra, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idAvistaValor, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idAvistaMargem, Locale.getDefault(), 0.0);
        UnidadeMedidaRN medidarn = new UnidadeMedidaRN();
        ArrayList medidas = (ArrayList) medidarn.buscarTodos("umSigla");
        ObservableList<String> UN = FXCollections.observableArrayList(medidas);
        idUnidade.setItems(UN);
        
        idAtualizacao.setValue(LocalDate.now());
        idAtualizacao.setDisable(true);
 
    }

    @FXML
    void handlerCadastrar(ActionEvent event) {
        UnidadeMedidaRN unidadern = new UnidadeMedidaRN();
        TbUnidadeMedida unidade = unidadern.listaUm("umSigla", idUnidade.getValue(), TbUnidadeMedida.class);

        CategoriaProdutoRN categoriarn = new CategoriaProdutoRN();
        TbCategoriaProduto categoria = categoriarn.listaUm("catpDescricao", idGrupo.getText(), TbCategoriaProduto.class);

        TbProduto produto = new TbProduto(idBarras.getText(), idDescricao.getText(), unidade, categoria);

        EstoqueRN estoquern = new EstoqueRN();
        TbEstoque estoque = new TbEstoque(produto, Float.parseFloat(idQuantidade.getText()), Float.parseFloat(idAvistaValor.getText()),
                Float.parseFloat(idMinimo.getText()),
                (short) (idControle.isSelected() ? 1 : 0), (short) (idProibir.isSelected() ? 1 : 0), timestamp);

        estoquern.salvar(estoque);
    }

    @FXML
    void handlerCancelar(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    void handlerAdicionarGrupo(ActionEvent event) {
        CategoriaProdutoRN categoriarn = new CategoriaProdutoRN();
        TbCategoriaProduto categoria = new TbCategoriaProduto(idGrupo.getText());
        categoriarn.salvar(categoria);
    }
    
    boolean verificaCampos() {
        boolean camposValidos = true;
        if (UN.validarCampoTipoCliente(idUnidade)){ camposValidos = false;}
        return camposValidos;
    }
}
