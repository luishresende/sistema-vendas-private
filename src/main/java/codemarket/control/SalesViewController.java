package codemarket.control;

import codemarket.control.tableViewModel.VendasModel;
import codemarket.model.rn.PedidoRN;
import codemarket.model.rn.VendaRN;
import codemarket.model.vo.TbPedido;
import codemarket.model.vo.TbUsuario;
import codemarket.model.vo.TbVenda;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SalesViewController implements Initializable {

    @FXML
    private RadioButton radioButtonVendasGerais;

    @FXML
    private TableView<VendasModel> tableViewSales;

    @FXML
    private TableColumn<?, ?> tableColumnCliente;

    @FXML
    private Button buttonDetalhes;

    @FXML
    private Button buttonAtualizar;

    @FXML
    private RadioButton radioButtonVendasUsuario;

    @FXML
    private TableColumn<?, ?> tableColumnID;

    @FXML
    private TableColumn<?, ?> tableColumnUsuario;

    @FXML
    private TableColumn<?, ?> tableColumnValorTotal;

    @FXML
    private TableColumn<?, ?> tableColumnData;

    @FXML
    private TableColumn<?, ?> tableColumnPagamento;

    private ObservableList<VendasModel> infoGeral = FXCollections.observableArrayList();
    private ObservableList<VendasModel> infoUsuario = FXCollections.observableArrayList();

    private VendaRN v = new VendaRN();
    private List<TbVenda> vendas;
    private TbUsuario user = AuthController.getInstance().getUser();

    private SaleDetailsViewController detailsController;
    private Scene detailsScene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup toggleGroup = new ToggleGroup();
        // Adicionar os RadioButtons ao ToggleGroup
        radioButtonVendasGerais.setToggleGroup(toggleGroup);
        radioButtonVendasUsuario.setToggleGroup(toggleGroup);

        // Carrego a tela de detalhes
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SaleDetailsView.fxml"));
        AnchorPane detailsView = null;
        try {
            detailsView = (AnchorPane) loader.load();
        } catch (IOException ex) {
            System.out.println("Deu merda");
            Logger.getLogger(SalesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Defino a cena da tela de telhes
        detailsScene = new Scene(detailsView);
        detailsController = loader.getController();
        Platform.runLater(() -> {
            // Atualizo a tabela de vendas
            updateTable();
        });
    }

    public float calcularValorCompra(List<TbPedido> pedidos) {
        float valorTotal = (float) 0.0;
        for (TbPedido ped : pedidos) {
            // Para cada pedido na lista, calculo o valor total multiplicando a quantidade pelo valor final do produto
            float valorPedido = ped.getPedQuantidade() * ped.getPedEstoProduto().getEstoValorFinal();
            valorTotal += valorPedido;
        }

        return valorTotal;
    }

    @FXML
    public void updateTable() {
        // Limpo as listas de informações
        infoUsuario.clear();
        infoGeral.clear();
        
        // Busco todas as vendas
        vendas = v.pesquisar("SELECT t FROM TbVenda t");
        PedidoRN ped = new PedidoRN();
        for (TbVenda venda : vendas) {
            // Busco todos os pedidos relacionados a venda
            List<TbPedido> pedidos = ped.pesquisar("SELECT p FROM TbPedido p WHERE p.pedVenda.venId = " + venda.getVenId());

            // Busco as informações necessárias para o modelo da tabela com base na venda
            float valorTotal = calcularValorCompra(pedidos);

            String cliente = "";
            if (venda.getVenCliId() != null) {
                cliente = venda.getVenCliId().getClicpfCnpj().getEntNome();
            }

            String tipoPagamento = venda.getVenTpId().getTpDescricao();
            String funcionarioResponsavel = venda.getVenUsuario().getTbFuncionario().getFuncentcpfCnpj().getEntNome();
            String data = venda.getVenData().toString();

            VendasModel vm = new VendasModel(venda.getVenId(), valorTotal, cliente, tipoPagamento, funcionarioResponsavel, data);

            // Se a venda foi realizada pelo usuário logado, adiciono as informações na tabela de usuário
            if (venda.getVenUsuario().getUsuUsuario() == user.getUsuUsuario()) {
                infoUsuario.add(vm);
            }
            // Adiciono as informações na tabela de vendas gerais
            infoGeral.add(vm);
        }

        // Adicionando as propriedades da célula
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tableColumnValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<>("clienteNome"));
        tableColumnPagamento.setCellValueFactory(new PropertyValueFactory<>("tipoPagamento"));
        tableColumnUsuario.setCellValueFactory(new PropertyValueFactory<>("funcionarioResponsavel"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));

        // Selecionando os itens na tableView com base no radioButton selecionado
        if (radioButtonVendasGerais.isSelected()) {
            tableViewSales.setItems(infoGeral);
        } else {
            tableViewSales.setItems(infoUsuario);
        }
    }

    @FXML
    private void handleRadioButtonAction() {
        // Método que atualiza as informações da tableView com base no radioButton selecionado
        if (radioButtonVendasGerais.isSelected()) {
            tableViewSales.setItems(infoGeral);
        } else if (radioButtonVendasUsuario.isSelected()) {
            tableViewSales.setItems(infoUsuario);
        }
    }

    @FXML
    public void showDetails() {
        if (!tableViewSales.getSelectionModel().isEmpty()) {
            // Obtém a linha selecionada na tabela
            VendasModel selectedModel = tableViewSales.getSelectionModel().getSelectedItem();
            
            // Chama o método do controlador da tela de detalhes para atualizar as informações, passando a venda selecionada como parâmetro
            detailsController.updateDetails(selectedModel);
            
            // Crio um novo Stage, definindo os atributos com base nos carregamentos feitos na inicialização
            Stage detailsStage = new Stage();
            detailsStage.setScene(detailsScene);
            detailsStage.setTitle("Detalhes");
            detailsStage.initModality(Modality.APPLICATION_MODAL);
            detailsStage.setResizable(false);

            detailsStage.showAndWait();

        } else {
            // Caso não tenha nenhuma célula selecionada, informo erro
            codemarket.model.utils.DisplayDialogScreen.getInstance().displayErrorScreen("Erro", "", "É necessário selecionar uma célula");
        }
    }

}
