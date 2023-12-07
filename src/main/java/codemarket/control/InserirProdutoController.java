package codemarket.control;

import codemarket.model.rn.*;
import codemarket.model.vo.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
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

public class InserirProdutoController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private TextField idQuantidade;
    @FXML
    private TextField idAvistaMargem;
    @FXML
    private CheckBox idControle;
    @FXML
    private Button idAdicionarGrupo;
    @FXML
    private TextField idAvistaValor;
    @FXML
    private DatePicker idAtualizacao;
    @FXML
    private TextField idPrazoValor;
    @FXML
    private Button buttonCancelar;
    @FXML
    private ComboBox<String> idUnidade;
    @FXML
    private TextField idCompra;
    @FXML
    private Button buttonCadastrar;
    @FXML
    private TextField idBarras;
    @FXML
    private CheckBox idProibir;
    @FXML
    private TextField idDescricao;
    @FXML
    private TextField idPrazoMargem;
    @FXML
    private CheckBox idAtualizar;
    @FXML
    private TextField idCodigo;
    @FXML
    private TextField idMinimo;
    @FXML
    private TextField idGrupo;
    @FXML
    private DatePicker idValidade;

    private Stage dialogStage;
    Date dataAtual = new Date();
    Timestamp timestamp = new Timestamp(dataAtual.getTime());

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
}
