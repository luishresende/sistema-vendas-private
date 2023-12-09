/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.control.tableViewModel.EstoqueModel;
import codemarket.model.rn.EstoqueRN;
import codemarket.model.vo.TbEstoque;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iuri Pereira
 */
public class PesquisaProdutoController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private TableView<EstoqueModel> tableEstoque;
    @FXML
    private TableColumn<EstoqueModel, String> colunaCodigo;
    @FXML
    private TableColumn<EstoqueModel, String> colunaDescricao;
    @FXML
    private TableColumn<EstoqueModel, String> colunaUN;
    @FXML
    private TableColumn<EstoqueModel, String> colunaAvista;
    @FXML
    private TableColumn<EstoqueModel, String> colunaAtual;
    @FXML
    private TableColumn<EstoqueModel, String> colunaCategoria;

    private ObservableList<EstoqueModel> produto = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EstoqueRN produtorn = new EstoqueRN();
        List<TbEstoque> produtos = produtorn.pesquisar("SELECT t FROM TbEstoque t");
        for (TbEstoque pro : produtos) {
            EstoqueModel pros = new EstoqueModel(pro.getEstoId(), pro.getEstoProdutoCodigo().getPdtNome(),
                    pro.getEstoProdutoCodigo().getPdtUmSigla().getUmSigla(),
                    pro.getEstoValorFinal(), pro.getEstoQuantidade(),
                    pro.getEstoProdutoCodigo().getPdtCategoria().getCatpDescricao());

            produto.add(pros);
        }

        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("DescProduto"));
        colunaUN.setCellValueFactory(new PropertyValueFactory<>("UN"));
        colunaAvista.setCellValueFactory(new PropertyValueFactory<>("Avista"));
        colunaAtual.setCellValueFactory(new PropertyValueFactory<>("Atual"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));

        tableEstoque.setItems(produto);
        
            tableEstoque.setRowFactory(tv -> {
        TableRow<EstoqueModel> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                handleDoubleClickOnTable(event);
            }
        });
        return row;
    });
    }

    private String codigoProdutoSelecionado;

    @FXML
    void handleDoubleClickOnTable(MouseEvent event) {
        if (event.getClickCount() == 2) {
            // Obtém o item selecionado na tabela de pesquisa
            EstoqueModel estoqueModel = tableEstoque.getSelectionModel().getSelectedItem();

            // Verifique se algum item foi selecionado
            if (estoqueModel != null) {
                // Obtém o valor da primeira coluna (código) e fecha a janela
                codigoProdutoSelecionado = estoqueModel.getCodigo();
                fecharJanela();
            }
        }
    }

    public String getCodigoProdutoSelecionado() {
        return codigoProdutoSelecionado;
    }

    private void fecharJanela() {
        // Fecha a janela de pesquisa
        Stage stage = (Stage) tableEstoque.getScene().getWindow();
        stage.close();
    }

}
