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
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Locale;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
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
    private ComboBox<String> idUnidade;
    @FXML
    private ComboBox<TbFornecedor> idFornecedor;
    private TbEstoque estoque;
    private boolean editar = false;

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
    void validaCodigoBarras(KeyEvent event) {
        EST.aceitaNumero(event, idBarras);
    }

    @FXML
    void valorAvista() {
        try {
            String valorCompra = idCompra.getText().replaceAll("[^\\d,]+", "").replace(',', '.');
            String valorMargem = idAvistaMargem.getText().replaceAll("[^\\d,]+", "").replace(',', '.');

            double compra = Double.parseDouble(valorCompra);
            double lucro = Double.parseDouble(valorMargem);
            double valorAvista = Math.round((compra + (compra * (lucro / 100))) * 100.0) / 100.0;

            idAvistaValor.setText(String.valueOf(valorAvista * 10));
        } catch (NumberFormatException e) {}
    }

    ArrayList<TbFornecedor> fornecedores = null;
    ObservableList<TbFornecedor> listaFornecedores = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EST.initializeCurrencyField(idCompra, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idAvistaValor, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idAvistaMargem, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idMinimo, Locale.getDefault(), 0.0);
        EST.initializeCurrencyField(idQuantidade, Locale.getDefault(), 0.0);

        UnidadeMedidaRN medidarn = new UnidadeMedidaRN();
        ArrayList medidas = (ArrayList) medidarn.buscarTodos("umSigla");
        ObservableList<String> UN = FXCollections.observableArrayList(medidas);
        idUnidade.setItems(UN);

        fornecedores = (ArrayList<TbFornecedor>) FOR.pesquisar("SELECT f.tbFornecedor FROM codemarket.model.vo.TbEntidade f JOIN f.tbFornecedor on ent_cpfCnpj = for_cpfCnpj");
        listaFornecedores = FXCollections.observableArrayList(fornecedores);

        // Configurar um StringConverter para exibir o nome do fornecedor na ComboBox
        idFornecedor.setConverter(new StringConverter<TbFornecedor>() {
            @Override
            public String toString(TbFornecedor fornecedor) {
                return (fornecedor != null) ? fornecedor.getForcpfCnpj().getEntNome() : "";
            }

            @Override
            public TbFornecedor fromString(String string) {
                return null;
            }
        });

        idFornecedor.setItems(listaFornecedores);

        if (!idAvistaValor.getText().isEmpty()) {
            idAvistaMargem.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    valorAvista(); // Chama o método valorTroco() sempre que o texto em totalRecebido é alterado
                }
            });
        }

        idAtualizacao.setValue(LocalDate.now());
        idAtualizacao.setDisable(true);

    }

    @FXML
    void handlerCadastrar(ActionEvent event) {
        if (verificaCampos()) {
            TbFornecedor fornecedorSelecionado = idFornecedor.getSelectionModel().getSelectedItem();
            FORNECEDOR = (fornecedorSelecionado != null) ? (TbFornecedor) FOR.listaUm("forcpfCnpj", idFornecedor.getValue().getForcpfCnpj().getEntcpfCnpj(), TbFornecedor.class) : null;

            UnidadeMedidaRN unidadern = new UnidadeMedidaRN();
            TbUnidadeMedida unidade = unidadern.listaUm("umSigla", idUnidade.getValue(), TbUnidadeMedida.class);

            CategoriaProdutoRN categoriarn = new CategoriaProdutoRN();
            TbCategoriaProduto categoria = categoriarn.listaUm("catpDescricao", idGrupo.getText(), TbCategoriaProduto.class);

            if (editar) {
                ProdutoRN prorn = new ProdutoRN();
                TbProduto produto = estoque.getEstoProdutoCodigo();
                produto.setPdtCategoria(categoria);
                produto.setPdtUmSigla(unidade);
                produto.setPdtForIf(FORNECEDOR);
                produto.setPdtNome(idDescricao.getText());
                prorn.atualizar(produto);

                estoque.setEstoProdutoCodigo(produto);
                estoque.setEstoDataAtualizacao(dataAtual);
                estoque.setEstoValorBase(parseCurrency(idCompra.getText()));
                estoque.setEstoValorFinal(parseCurrency(idAvistaValor.getText()));
                estoque.setEstoLimiteMin(parseCurrency(idMinimo.getText()));
                estoque.setEstoQuantidade(parseCurrency(idQuantidade.getText()));
                estoque.setEstoLimiteMin((short) (idControle.isSelected() ? 1 : 0));
                estoque.setEstoProibirVendaLimMin((short) (idProibir.isSelected() ? 1 : 0));

                EstoqueRN estorn = new EstoqueRN();
                estorn.atualizar(estoque);
                JOptionPane.showMessageDialog(null, "Edição concluída com sucesso!");
                dialogStage.close();

            } else {
                TbProduto produto = new TbProduto(idBarras.getText(), idDescricao.getText(), unidade, categoria, FORNECEDOR);
                EstoqueRN estoquern = new EstoqueRN();
                TbEstoque estoque = new TbEstoque(produto,
                        parseCurrency(idQuantidade.getText()), parseCurrency(idAvistaValor.getText()),
                        parseCurrency(idMinimo.getText()),
                        (short) (idControle.isSelected() ? 1 : 0),
                        (short) (idProibir.isSelected() ? 1 : 0), timestamp,
                        parseCurrency(idCompra.getText()));

                estoquern.salvar(estoque);
                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
                dialogStage.close();
            }
        } else {
            DisplayDialogScreen.getInstance().displayErrorScreen("Finalizar Cadastro", "Campos obrigatórios *", "Preencha todos os campos!");
        }
    }

// Função para tratar pontos decimais e converter para float
    private float parseCurrency(String value) {
        String cleanedValue = value.replaceAll("[^\\d,]+", "").replace(',', '.');
        return Float.parseFloat(cleanedValue);
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

    public void editarEstoque(TbEstoque estoque) {
        this.estoque = estoque;
        editar = true;

        idBarras.setText(estoque.getEstoProdutoCodigo().getPdtCodigo());
        idUnidade.setValue(estoque.getEstoProdutoCodigo().getPdtUmSigla().getUmSigla());
        idDescricao.setText(estoque.getEstoProdutoCodigo().getPdtNome());

        if (estoque.getEstoAtualizarCustoNoPedido() == 1) {
            idControle.setSelected(true);
        }
        if (estoque.getEstoProibirVendaLimMin() == 1) {
            idProibir.setSelected(true);
        }

        idMinimo.setText(String.valueOf(estoque.getEstoLimiteMin()));
        idQuantidade.setText(String.valueOf(estoque.getEstoQuantidade()));
        idCompra.setText(String.valueOf(estoque.getEstoValorBase()));
        idAvistaValor.setText(String.valueOf(estoque.getEstoValorFinal()));
        idGrupo.setText(estoque.getEstoProdutoCodigo().getPdtCategoria().getCatpDescricao());
        idFornecedor.setValue(estoque.getEstoProdutoCodigo().getPdtForIf().getForcpfCnpj().getTbFornecedor());
        Date dateAtualizacao = estoque.getEstoDataAtualizacao();
        java.util.Date utilDate = new java.util.Date(dateAtualizacao.getTime());
        Instant instant = utilDate.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        idAtualizacao.setValue(localDate);

        idBarras.setEditable(false);
    }

    boolean verificaCampos() {
        boolean camposValidos = true;
        if (UN.validarCampoTipoCliente(idUnidade)) {
            camposValidos = false;
        }
        if (EST.validarTextField(idBarras)) {
            camposValidos = false;
        }
        if (EST.validarTextField(idDescricao)) {
            camposValidos = false;
        }
        if (EST.validarTextField(idMinimo)) {
            camposValidos = false;
        }
        if (EST.validarTextField(idQuantidade)) {
            camposValidos = false;
        }
        if (EST.validarTextField(idCompra)) {
            camposValidos = false;
        }
        if (EST.validarTextField(idAvistaValor)) {
            camposValidos = false;
        }
        if (EST.validarComboBox(idUnidade)) {
            camposValidos = false;
        }
        if (EST.validarComboFornecedor(idFornecedor)) {
            camposValidos = false;
        }
        return camposValidos;
    }
}
