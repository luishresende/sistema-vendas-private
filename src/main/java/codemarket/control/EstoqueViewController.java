package codemarket.control;

import codemarket.control.tableViewModel.EstoqueModel;
import codemarket.model.rn.EstoqueRN;
import codemarket.model.vo.TbEstoque;
import codemarket.model.vo.TbFornecedor;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EstoqueViewController implements Initializable {

    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonRemover;

    @FXML
    private TableColumn<EstoqueModel, String> colunaCategoria;
    @FXML
    private TableView<EstoqueModel> tableEstoque;
    @FXML
    private TableColumn<EstoqueModel, String> colunaUN;
    @FXML
    private TableColumn<EstoqueModel, String> counaAtual;
    @FXML
    private TableColumn<EstoqueModel, String> colunaCodigo;
    @FXML
    private TableColumn<EstoqueModel, String> colunaDescricao;
    @FXML
    private TableColumn<EstoqueModel, String> colunaAvista;

    private ObservableList<EstoqueModel> estoque = FXCollections.observableArrayList();

    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();
    EstoqueRN e = new EstoqueRN();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<TbEstoque> estoques = e.pesquisar("SELECT t FROM TbEstoque t");
        for (TbEstoque est : estoques) {
            EstoqueModel esto = new EstoqueModel(est.getEstoProdutoCodigo().getPdtCodigo(), est.getEstoProdutoCodigo().getPdtNome(),
                    est.getEstoProdutoCodigo().getPdtUmSigla().getUmSigla(),
                    est.getEstoValorFinal(), est.getEstoQuantidade(),
                    est.getEstoProdutoCodigo().getPdtCategoria().getCatpDescricao());

            estoque.add(esto);
        }

        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("DescProduto"));
        colunaUN.setCellValueFactory(new PropertyValueFactory<>("UN"));
        colunaAvista.setCellValueFactory(new PropertyValueFactory<>("Avista"));
        counaAtual.setCellValueFactory(new PropertyValueFactory<>("Atual"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));

        tableEstoque.setItems(estoque);
    }

    @FXML
    private void handleButtonCadastrar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InserirProdutoView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Produto");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);

        codemarket.control.InserirProdutoController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Novo Produto");
        controller.setDialogStage(dialogStage);

        dialogStage.showAndWait();
    }

    @FXML
    private void handleButtonEditar() throws IOException {        
        EstoqueModel selectedFunc = tableEstoque.getSelectionModel().getSelectedItem();
        if (selectedFunc != null) {
            EstoqueRN estorn = new EstoqueRN();
            TbEstoque etoqueParaEditar = estorn.listaUm("estoProdutoCodigo.pdtCodigo", selectedFunc.getCodigo(), TbEstoque.class);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InserirProdutoView.fxml"));

            AnchorPane page = (AnchorPane) loader.load();
            

            Scene scene = new Scene(page);
            dialogStage = new Stage();
            dialogStage.setTitle("Editar Estoque");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            dialogStage.setScene(scene);
            codemarket.control.InserirProdutoController controller = loader.getController();
            controller.setTituloJanela("Editar Cadastro do Estoque");
            controller.editarEstoque(etoqueParaEditar);
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
        } else {
            // Exiba uma mensagem de aviso caso nenhum funcionário seja selecionado
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um Fornecedor para editar.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handlebuttonRemover(ActionEvent event) {
        // Obtém a linha selecionada da tabela
        EstoqueModel selectedEstoque = tableEstoque.getSelectionModel().getSelectedItem();

        if (selectedEstoque != null) {
            // Cria um alerta de confirmação
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de Remoção");
            alert.setHeaderText("Tem certeza que deseja remover o Produto?");
            alert.setContentText("Descrição: " + selectedEstoque.getDescProduto());

            // Exibe o alerta e aguarda a resposta do usuário
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    EstoqueRN estoquern = new EstoqueRN();
                    TbEstoque estoqueExcluir = estoquern.listaUm("estoProdutoCodigo.pdtNome", selectedEstoque.getDescProduto(), TbEstoque.class);
                    estoquern.excluir(estoqueExcluir);
                    estoque.remove(selectedEstoque);
                } else {
                }
            });
        } else {
            // Caso nenhum fornecedor seja selecionado, exibe um alerta de aviso
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um fornecedor para remover.");
            alert.showAndWait();
        }
    }
    @FXML
        private void handleButtonAtualizar() {
        estoque.clear();
        List<TbEstoque> estoques = e.pesquisar("SELECT t FROM TbEstoque t");
        for (TbEstoque est : estoques) {
            EstoqueModel esto = new EstoqueModel(est.getEstoProdutoCodigo().getPdtCodigo(), est.getEstoProdutoCodigo().getPdtNome(),
                    est.getEstoProdutoCodigo().getPdtUmSigla().getUmSigla(),
                    est.getEstoValorFinal(), est.getEstoQuantidade(),
                    est.getEstoProdutoCodigo().getPdtCategoria().getCatpDescricao());

            estoque.add(esto);
        }

        tableEstoque.setItems(estoque);
    }
}

