package codemarket.control;

import codemarket.model.rn.*;
import codemarket.model.vo.*;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private ComboBox<String> idUnidade, idFornecedor;
    private TbEstoque estoque;
    private boolean editar = false;

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
        
        FornecedorRN fore = new FornecedorRN();
        ArrayList fornecedores = (ArrayList) fore.buscarTodos("forcpfCnpj.entnomeFantasia");
        ObservableList<String> FO = FXCollections.observableArrayList(fornecedores);
        idFornecedor.setItems(FO);
        idAtualizacao.setValue(LocalDate.now());
        idAtualizacao.setDisable(true);
 
    }

    @FXML
    void handlerCadastrar(ActionEvent event) {
        
        UnidadeMedidaRN unidadern = new UnidadeMedidaRN();
        TbUnidadeMedida unidade = unidadern.listaUm("umSigla", idUnidade.getValue(), TbUnidadeMedida.class);

        CategoriaProdutoRN categoriarn = new CategoriaProdutoRN();
        TbCategoriaProduto categoria = categoriarn.listaUm("catpDescricao", idGrupo.getText(), TbCategoriaProduto.class);
        
        FornecedorRN forne = new FornecedorRN();
        TbFornecedor fo = forne.listaUm("forcpfCnpj.entnomeFantasia",idFornecedor.getValue(), TbFornecedor.class);

        if(editar){
            ProdutoRN prorn = new ProdutoRN();
            TbProduto produto = estoque.getEstoProdutoCodigo();
            produto.setPdtCategoria(categoria);
            produto.setPdtUmSigla(unidade);
            produto.setPdtForIf(fo);
            produto.setPdtNome(idDescricao.getText());
            prorn.atualizar(produto);
            
            estoque.setEstoProdutoCodigo(produto);
            estoque.setEstoDataAtualizacao(dataAtual);
            estoque.setEstoValorBase(Float.parseFloat(idCompra.getText().replace(",", ".")));
            estoque.setEstoValorFinal(Float.parseFloat(idAvistaValor.getText().replace(",", ".")));
            estoque.setEstoLimiteMin(Float.parseFloat(idMinimo.getText().replace(",", ".")));
            estoque.setEstoQuantidade(Float.parseFloat(idQuantidade.getText().replace(",", ".")));
            estoque.setEstoLimiteMin((short) (idControle.isSelected() ? 1 : 0));
            estoque.setEstoProibirVendaLimMin((short) (idProibir.isSelected() ? 1 : 0));
            
            EstoqueRN estorn = new EstoqueRN();
            estorn.atualizar(estoque);
            JOptionPane.showMessageDialog(null, "Edição concluido com sucesso!");
            dialogStage.close();
            
        }else{
            TbProduto produto = new TbProduto(idBarras.getText(), idDescricao.getText(), unidade, categoria, fo);

            EstoqueRN estoquern = new EstoqueRN();
            TbEstoque estoque = new TbEstoque(
                produto,
                Float.parseFloat(idQuantidade.getText().replace(",", ".")),
                Float.parseFloat(idAvistaValor.getText().replace(",", ".")),
                Float.parseFloat(idMinimo.getText().replace(",", ".")),
                (short) (idControle.isSelected() ? 1 : 0),
                (short) (idProibir.isSelected() ? 1 : 0),
                timestamp,
                Float.parseFloat(idCompra.getText().replace(",", "."))
            );

            estoquern.salvar(estoque);     
            JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
            dialogStage.close();
        }

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
    
    public void editarEstoque(TbEstoque estoque){
        this.estoque = estoque;
        editar =  true;
        
        idCodigo.setText(String.valueOf(estoque.getEstoId()));
        idBarras.setText(estoque.getEstoProdutoCodigo().getPdtCodigo());
        idUnidade.setValue(estoque.getEstoProdutoCodigo().getPdtUmSigla().getUmSigla());
        idDescricao.setText(estoque.getEstoProdutoCodigo().getPdtNome());
        
        if(estoque.getEstoAtualizarCustoNoPedido() == 1){
            idControle.setSelected(true);
        }
        if(estoque.getEstoProibirVendaLimMin() == 1){
            idProibir.setSelected(true);
        }
        
        idMinimo.setText(String.valueOf(estoque.getEstoLimiteMin()));
        idQuantidade.setText(String.valueOf(estoque.getEstoQuantidade()));
        idCompra.setText(String.valueOf(estoque.getEstoValorBase()));
        idAvistaValor.setText(String.valueOf(estoque.getEstoValorFinal()));
        idGrupo.setText(estoque.getEstoProdutoCodigo().getPdtCategoria().getCatpDescricao());
        idFornecedor.setValue(estoque.getEstoProdutoCodigo().getPdtForIf().getForcpfCnpj().getEntnomeFantasia());
        
        Date dateAtualizacao = estoque.getEstoDataAtualizacao();
        java.util.Date utilDate = new java.util.Date(dateAtualizacao.getTime());
        Instant instant = utilDate.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        idAtualizacao.setValue(localDate);   
        
        idBarras.setEditable(false);
    }
}