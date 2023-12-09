package codemarket.control;

import codemarket.model.rn.*;
import codemarket.model.utils.DisplayDialogScreen;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
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
    private ComboBox<String> idUnidade, idFornecedor;

    private Stage dialogStage;
    
    TbFornecedor FORNECEDOR = null;
            
    Date dataAtual = new Date();
    Timestamp timestamp = new Timestamp(dataAtual.getTime());
    UnidadeMedidaRN UN = new UnidadeMedidaRN();
    EstoqueRN EST = new EstoqueRN();
    FornecedorRN FOR = new FornecedorRN();
    
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
    @FXML
    void valorAvista() {
        try {
            // Obter o texto do campo formatado como porcentagem
            String valorCompra = idCompra.getText();
            String valorMargem = idAvistaMargem.getText();
            // Remover caracteres não numéricos (deixar apenas dígitos e ponto)
            String valorNumCompra = valorCompra.replaceAll("[^\\d,]+", "");
            String valorNumMargem = valorMargem.replaceAll("[^\\d,]+", "");
            valorNumCompra = valorNumCompra.replace(',', '.');
            valorNumMargem = valorNumMargem.replace(',', '.');

            // Converte as strings para números
            double compra = Double.parseDouble(valorNumCompra);
            double lucro = Double.parseDouble(valorNumMargem);
            // Calcula o valor que vai ser avista
            double valorAvista = (compra + (compra * (lucro/100)));

            // Exibe o troco no TextField troco
            idAvistaValor.setText(String.valueOf(valorAvista + "0"));
        } catch (NumberFormatException e) {
            
        }
    }
    @FXML
    void margemAvista() {
        try {
            // Obter o texto do campo formatado como porcentagem
            String valorCompra = idCompra.getText();
            String valAvista = idAvistaValor.getText();
            // Remover caracteres não numéricos (deixar apenas dígitos e ponto)
            String valorNumCompra = valorCompra.replaceAll("[^\\d,]+", "");
            String valorNumAvista = valAvista.replaceAll("[^\\d,]+", "");
            valorNumCompra = valorNumCompra.replace(',', '.');
            valAvista = valAvista.replace(',', '.');
            // Converte as strings para números
            double compra = Double.parseDouble(valorNumCompra); 
            double valorAvista = Double.parseDouble(valorNumAvista);
            // Calcula o valor que vai ser avista
            double valorP = compra - valorAvista;
            double porcentagem = (valorP / compra) * 100;
            // Exibe o troco no TextField troco
            idAvistaMargem.setText(String.valueOf(porcentagem));
        } catch (NumberFormatException e) {
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EST.initializeCurrencyField(idCompra, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idAvistaValor, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idAvistaMargem, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idMinimo, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idQuantidade, Locale.getDefault(), 0.0);
        
        ArrayList medidas = (ArrayList) UN.buscarTodos("umSigla");
        ObservableList<String> UNI = FXCollections.observableArrayList(medidas);
        idUnidade.setItems(UNI);
        
        ArrayList fornecedores = (ArrayList) FOR.pesquisar("SELECT f.entNome FROM codemarket.model.vo.TbEntidade f JOIN f.tbFornecedor on ent_cpfCnpj = for_cpfCnpj");
        ObservableList<String> FORNE = FXCollections.observableArrayList(fornecedores);
        idFornecedor.setItems(FORNE);
        
        if(!idAvistaValor.getText().isEmpty()) {
            idAvistaMargem.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    valorAvista(); // Chama o método valorTroco() sempre que o texto em totalRecebido é alterado
                }
            });
        } else if(!idAvistaMargem.getText().isEmpty()) {
            idAvistaValor.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    margemAvista(); // Chama o método valorTroco() sempre que o texto em totalRecebido é alterado
                }
            });
        } 
        
        idAtualizacao.setValue(LocalDate.now());
        idAtualizacao.setDisable(true);
    }

    @FXML
    void handlerCadastrar(ActionEvent event) {
        if(verificaCampos()){
            String valorAvista = idAvistaValor.getText().replaceAll("[^\\d,]+", "");
            valorAvista = valorAvista.replace(',', '.');
            String valorCompra = idCompra.getText().replaceAll("[^\\d,]+", "");
            valorCompra = valorCompra.replace(',', '.');
            FORNECEDOR = (TbFornecedor) FOR.pesquisar("SELECT f FROM codemarket.model.vo.TbEntidade f "
                    + "JOIN f.tbFornecedor tf WHERE f.entNome = '" + idFornecedor.getValue() + "'");
            System.out.println(FORNECEDOR.getForcpfCnpj().getEntNome());


            
            UnidadeMedidaRN unidadern = new UnidadeMedidaRN();
            TbUnidadeMedida unidade = unidadern.listaUm("umSigla", idUnidade.getValue(), TbUnidadeMedida.class);

            CategoriaProdutoRN categoriarn = new CategoriaProdutoRN();
            TbCategoriaProduto categoria = categoriarn.listaUm("catpDescricao", idGrupo.getText(), TbCategoriaProduto.class);
            
            TbProduto produto = new TbProduto(idBarras.getText(), idDescricao.getText(), unidade, categoria, FORNECEDOR);

            EstoqueRN estoquern = new EstoqueRN();
            TbEstoque estoque = new TbEstoque(produto, Float.parseFloat(idQuantidade.getText()), Float.parseFloat(valorAvista),
                    Float.parseFloat(idMinimo.getText()),
                    (short) (idControle.isSelected() ? 1 : 0), (short) (idProibir.isSelected() ? 1 : 0), timestamp, Float.parseFloat(valorCompra));

            estoquern.salvar(estoque);
            
        } else {
            DisplayDialogScreen.getInstance().displayErrorScreen("Finalizar Cadastro", "Campos obrigatórios *", "Preencha todos os campos!");
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
        if (EST.validarTextField(idBarras)) { camposValidos = false;}
        if (EST.validarTextField(idDescricao)) { camposValidos = false;}
        if (EST.validarTextField(idMinimo)) { camposValidos = false;}
        if (EST.validarTextField(idQuantidade)) { camposValidos = false;}
        if (EST.validarTextField(idCompra)) { camposValidos = false;}
        if (EST.validarTextField(idAvistaValor)) { camposValidos = false;}
        if (EST.validarComboBox(idUnidade)) { camposValidos = false;}
        if (EST.validarComboBox(idFornecedor)) { camposValidos = false;}
        return camposValidos;
    }
}
