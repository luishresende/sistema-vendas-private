package codemarket.control;

import codemarket.control.tableViewModel.VendaModel;
import codemarket.model.rn.*;
import codemarket.model.vo.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PDVViewController implements Initializable {

    @FXML
    private TextField subtotal;

    @FXML
    private TextField totalRecebido;

    @FXML
    private TextField troco;
    @FXML
    private TextField idBarras;
    @FXML
    private TextField totaItem;

    @FXML
    private TextField quantidade;
    @FXML
    private TableView<VendaModel> tableVenda;

    @FXML
    private TableColumn<VendaModel, String> colunaAvista;
    @FXML
    private TableColumn<VendaModel, String> colunaUNI;
    @FXML
    private TableColumn<VendaModel, String> colunaCodigo;
    @FXML
    private TableColumn<VendaModel, String> colunaDescricao;
    @FXML
    private TableColumn<VendaModel, String> colunaCategoria;
    @FXML
    private TableColumn<VendaModel, Integer> colunaQuantidade;

    private ObservableList<VendaModel> venda = FXCollections.observableArrayList();

    private boolean isPesquisaProdutoViewOpen = false;
    private boolean isListenerAdded = false;

    @FXML
    void valorTroco() {
        try {
            // Converte as strings para números
            double subtotalValue = Double.parseDouble(subtotal.getText());
            double totalRecebidoValue = Double.parseDouble(totalRecebido.getText());

            // Calcula o troco
            double trocoValue = totalRecebidoValue - subtotalValue;

            // Exibe o troco no TextField troco
            troco.setText(String.valueOf(trocoValue));
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro de Formato");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, insira valores numéricos válidos.");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        colunaUNI.setCellValueFactory(new PropertyValueFactory<>("Uni"));
        colunaAvista.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));

        tableVenda.setItems(venda);
        System.out.println("Tela aberta");
        
        quantidade.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null && !isListenerAdded) {
                newScene.addEventFilter(KeyEvent.KEY_PRESSED, this::handleFunctionKeys);
                isListenerAdded = true;
            }
        });

        // Adiciona um listener para detectar mudanças na seleção da tabela
        tableVenda.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Atualiza o TextField idBarras com o código da linha selecionada
                idBarras.setText(newValue.getCodigo());

                // Calcula o valor total (valorAvista + quantidade)
                double valorAvista = Double.parseDouble(newValue.getValor());
                int quantidade = newValue.getQuantidade();
                double total = valorAvista * quantidade;

                // Atualiza o TextField totaItem com o valor total
                totaItem.setText(String.valueOf(total));
            } else {
                // Limpa os TextFields se nenhuma linha estiver selecionada
                idBarras.clear();
                totaItem.clear();
            }
        });
        totalRecebido.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                valorTroco(); // Chama o método valorTroco() sempre que o texto em totalRecebido é alterado
            }
        });

    }

    @FXML
    void handleFunctionKeyF1() {
        try {
            // Carrega o arquivo FXML da tela FinalizaVenda.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FinalizaVenda.fxml"));
            Parent root = loader.load();

            // Cria uma nova janela para a tela FinalizaVenda
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Finalizar Venda");
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            // Obtém o controlador da tela FinalizaVenda
            FinalizaVendaController finalizaVendaController = loader.getController();

            // Exibe a janela e aguarda até que ela seja fechada
            stage.showAndWait();

            // Após o fechamento da janela, obtém os valores selecionados nas ComboBoxes e CheckBox
            String clienteSelecionado = finalizaVendaController.getIdCliente().getValue();
            String tipoPagamentoSelecionado = finalizaVendaController.getTipoPagamento().getValue();
            boolean semCadastroSelecionado = finalizaVendaController.getSemCadastro().isSelected();

            TbCliente cliente = null;
            if (!semCadastroSelecionado) {
                ClienteRN clirn = new ClienteRN();
                cliente = clirn.listaUm("clicpfCnpj.entNome", clienteSelecionado, TbCliente.class);
            }

            Date dataAtual = new Date();
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            TipoPagamentoRN pagamentorn = new TipoPagamentoRN();
            TbTipoPagamento pagamento = pagamentorn.listaUm("tpDescricao", tipoPagamentoSelecionado, TbTipoPagamento.class);

            TbUsuario autg = AuthController.getInstance().getUser();
            TbVenda vendaAtual = new TbVenda(pagamento, cliente, timestamp, autg);
            PedidoRN pedidorn = new PedidoRN();
            EstoqueRN estoquern = new EstoqueRN();
            for (VendaModel v : venda) {
                TbEstoque estoque = estoquern.listaUm("estoProdutoCodigo.pdtCodigo", v.getCodigo(), TbEstoque.class);
                TbPedido pe = new TbPedido(v.getQuantidade(), 0.0f, vendaAtual, estoque);
                pedidorn.salvar(pe);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleFunctionKeyF2() {
        // Evite a abertura múltipla da janela
        if (!isPesquisaProdutoViewOpen) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PesquisaProdutoView.fxml"));
                Parent root = loader.load();

                // Obtenha o controlador da janela de pesquisa
                PesquisaProdutoController pesquisaProdutoController = loader.getController();

                // Exiba a janela de pesquisa
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.showAndWait(); // Aguarde até que a janela de pesquisa seja fechada

                // Defina a flag para indicar que a janela está aberta
                isPesquisaProdutoViewOpen = true;

                // Obtenha o valor retornado da janela de pesquisa
                String codigoProduto = pesquisaProdutoController.getCodigoProdutoSelecionado();
                EstoqueRN estoque = new EstoqueRN();
                TbEstoque est = estoque.listaUm("estoId", codigoProduto, TbEstoque.class);
                VendaModel v = new VendaModel(est.getEstoProdutoCodigo().getPdtCodigo(), est.getEstoProdutoCodigo().getPdtUmSigla().getUmSigla(), (float) est.getEstoValorFinal(),
                        est.getEstoProdutoCodigo().getPdtCategoria().getCatpDescricao(), est.getEstoProdutoCodigo().getPdtNome(), 0);

                venda.add(v);
                atualizarSubtotal();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Certifique-se de redefinir a flag quando a janela for fechada
                isPesquisaProdutoViewOpen = false;
            }
        }
    }

    @FXML
    void handleFunctionKeyF3() {
        // Obtém a linha selecionada na tabela
        VendaModel vendaSelecionada = tableVenda.getSelectionModel().getSelectedItem();

        // Verifica se há uma linha selecionada
        if (vendaSelecionada != null) {
            // Obtém a quantidade atual na linha selecionada
            int quantidadeAtual = vendaSelecionada.getQuantidade();

            // Obtém a quantidade do TextField quantidade
            String quantidadeTexto = quantidade.getText();
            int quantidadeNova = quantidadeAtual + Integer.parseInt(quantidadeTexto);

            // Atualiza a quantidade na linha selecionada
            vendaSelecionada.setQuantidade(quantidadeNova);

            // Atualiza o TextField totaItem com o novo valor
            double valorAvista = Double.parseDouble(vendaSelecionada.getValor());
            double total = valorAvista * quantidadeNova;
            totaItem.setText(String.valueOf(total));

            // Atualiza a tabela
            tableVenda.refresh();
            atualizarSubtotal();
        } else {
            // Caso não haja linha selecionada, exibe um aviso
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma Linha Selecionada");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione uma linha para realizar a soma de quantidade.");

            alert.showAndWait();
        }
    }

    @FXML
    void handleFunctionKeyF4() {
        // Obtém a linha selecionada na tabela
        VendaModel vendaSelecionada = tableVenda.getSelectionModel().getSelectedItem();

        // Verifica se há uma linha selecionada
        if (vendaSelecionada != null) {
            // Remove a linha da lista observável
            venda.remove(vendaSelecionada);
            atualizarSubtotal();

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma Linha Selecionada");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione uma linha para realizar a Exclusão.");

            alert.showAndWait();
        }
    }

    void handleFunctionKeyF5() {
        venda.clear();
        idBarras.clear();
        totalRecebido.clear();
        quantidade.setText(null);
        totaItem.clear();
        subtotal.clear();
        totalRecebido.clear();
        troco.clear();
        atualizarSubtotal();

    }

    @FXML
    void handleFunctionKeys(KeyEvent event) {
        switch (event.getCode()) {
            case F1:
                handleFunctionKeyF1();
                break;
            case F2:
                handleFunctionKeyF2();
                break;
            case F3:
                handleFunctionKeyF3();
                break;
            case F4:
                handleFunctionKeyF4();
                break;
            case F5:
                handleFunctionKeyF5();
                break;
            default:
                break;
        }
    }

    // Método para atualizar o subtotal
    private void atualizarSubtotal() {
        double subtotalCalculado = 0;

        // Percorre a lista de vendas e calcula o subtotal
        List<VendaModel> listaVendas = tableVenda.getItems();
        for (VendaModel venda : listaVendas) {
            double valor = Double.parseDouble(venda.getValor());
            int quantidade = venda.getQuantidade();
            subtotalCalculado += valor * quantidade;
        }

        // Atualiza o TextField subtotal
        subtotal.setText(String.valueOf(subtotalCalculado));
    }

}
