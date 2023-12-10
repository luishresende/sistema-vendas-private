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
            double valorAvista = Math.round((compra + (compra * (lucro / 100))) * 100.0) / 100.0;
            // Exibe o troco no TextField troco
            idAvistaValor.setText(String.valueOf(valorAvista * 10));
        } catch (NumberFormatException e) {

        }
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
                // Método necessário para conversões bidirecionais
                // Se necessário, você pode implementar esta parte para converter de volta de uma string para um objeto TbFornecedor
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
            if (fornecedorSelecionado != null) {
                FORNECEDOR = (TbFornecedor) FOR.listaUm("forcpfCnpj", idFornecedor.getValue().getForcpfCnpj().getEntcpfCnpj(), TbFornecedor.class);
            }
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

            } else {
                TbProduto produto = new TbProduto(idBarras.getText(), idDescricao.getText(), unidade, categoria, FORNECEDOR);
                String valorAvista = idAvistaValor.getText();
                String valorCompra = idCompra.getText();

                String valorNumAvista = valorAvista.replaceAll("[^\\d,]+", "");
                String valorNumCompra = valorCompra.replaceAll("[^\\d,]+", "");

                float avista = Float.parseFloat(valorNumAvista.replace(',', '.'));
                float compra = Float.parseFloat(valorNumCompra.replace(',', '.'));
                EstoqueRN estoquern = new EstoqueRN();
                TbEstoque estoque = new TbEstoque(produto, 
                        Float.parseFloat(idQuantidade.getText().replace(',', '.')), avista,
                        Float.parseFloat(idMinimo.getText().replace(',', '.')),
                        (short) (idControle.isSelected() ? 1 : 0), 
                        (short) (idProibir.isSelected() ? 1 : 0), timestamp, 
                        compra);

                estoquern.salvar(estoque);
                JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                dialogStage.close();
            }
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

    public void editarEstoque(TbEstoque estoque) {
        this.estoque = estoque;
        editar = true;

        idCodigo.setText(String.valueOf(estoque.getEstoId()));
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
