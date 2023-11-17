/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.control.tableViewModel.DetalhesVendaModel;
import codemarket.control.tableViewModel.VendasModel;
import codemarket.model.rn.PedidoRN;
import codemarket.model.vo.TbPedido;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author Luis Resende
 */
public class SaleDetailsViewController implements Initializable {

    @FXML
    private TextField textFieldFuncionario;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldData;

    @FXML
    private TextField textFieldPagamento;

    @FXML
    private TableColumn<?, ?> tableColumnQuantidade;

    @FXML
    private TextField textFieldTotal;

    @FXML
    private TableColumn<?, ?> tableColumnCodigo;

    @FXML
    private TableColumn<?, ?> tableColumnTotal;

    @FXML
    private TextField textFieldCliente;

    @FXML
    private TableColumn<?, ?> tableColumnProduto;

    @FXML
    private TableView<DetalhesVendaModel> tableViewDetalhes;

    @FXML
    private TableColumn<?, ?> tableColumnValorUN;

    private ObservableList<DetalhesVendaModel> infoPedidos = FXCollections.observableArrayList();
    PedidoRN prn = new PedidoRN();
    List<TbPedido> pedidos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void updateDetails(VendasModel vendasModel) {
        // Limpando a lista
        infoPedidos.clear();

        // Buscando todos os pedidos com o id da venda passada por parâmetro
        pedidos = prn.pesquisar("SELECT p FROM TbPedido p WHERE p.pedVenda.venId = " + vendasModel.getID());
        for (TbPedido ped : pedidos) {
            // Adiciono cada pedido e suas informações na lista de informações
            float valorTotal = ped.getPedQuantidade() * ped.getPedEstoProduto().getEstoValorFinal();
            DetalhesVendaModel info = new DetalhesVendaModel(ped.getPedEstoProduto().getEstoProdutoCodigo().getPdtCodigo(), ped.getPedEstoProduto().getEstoProdutoCodigo().getPdtNome(),
                    ped.getPedQuantidade(), ped.getPedEstoProduto().getEstoValorFinal(), valorTotal);

            infoPedidos.add(info);
        }

        // Seto as propriedades das células da table view
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tableColumnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tableColumnValorUN.setCellValueFactory(new PropertyValueFactory<>("valorUN"));
        tableColumnTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        
        // Seto os itens na tableView
        tableViewDetalhes.setItems(infoPedidos);
        
        // Seto as informações nos text fields referente a venda
        textFieldCliente.setText(vendasModel.getClienteNome());
        textFieldFuncionario.setText(vendasModel.getFuncionarioResponsavel());
        textFieldData.setText(vendasModel.getData());
        textFieldID.setText("" + vendasModel.getID());
        textFieldPagamento.setText(vendasModel.getTipoPagamento());
        textFieldTotal.setText("" + vendasModel.getValorTotal());
    }

}
