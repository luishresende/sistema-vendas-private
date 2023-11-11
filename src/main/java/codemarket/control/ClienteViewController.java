package codemarket.control;

import codemarket.control.tableViewModel.FornecedorClienteModel;
import codemarket.model.rn.ClienteRN;
import codemarket.model.rn.TelefoneRN;
import codemarket.model.vo.TbCliente;
import codemarket.model.vo.TbTelefone;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClienteViewController implements Initializable {
    
    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonEditar;
    
    @FXML
    private TableView<FornecedorClienteModel> tableViewCliente;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaEmail;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaFone;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaNomeF;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaNome;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaCPFCNPJ;

    private ObservableList<FornecedorClienteModel> infoF = FXCollections.observableArrayList();
    
    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();
    ClienteRN c = new ClienteRN();
    List<TbCliente> clientes = c.pesquisar("SELECT t FROM TbCliente t");
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TelefoneRN tel = new TelefoneRN();
        for (TbCliente cliente : clientes) {
            TbTelefone fone = (TbTelefone) tel.pesquisar("SELECT t.ehtFoneId FROM TbEntidadeHasTelefone t WHERE"
                    + " t.ehtentcpfCnpj.tbCliente.clicpfCnpj = '" 
                    + cliente.getClicpfCnpj().getEntcpfCnpj() + "'").get(0);
            FornecedorClienteModel fm = new FornecedorClienteModel(cliente.getClicpfCnpj().getEntNome(), cliente.getClicpfCnpj().getEntnomeFantasia(),
                    cliente.getClicpfCnpj().getEntcpfCnpj(), cliente.getClicpfCnpj().getEntEmail(),
                    fone.getFoneDescricao());
            infoF.add(fm);
        }

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colunaNomeF.setCellValueFactory(new PropertyValueFactory<>("NomeFantasia"));
        colunaCPFCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colunaFone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        tableViewCliente.setItems(infoF);
    } 
    
    @FXML
    void handleButtonCadastrar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml")); // Aqui pode ser aberto várias vezes a tela
//        loader.setLocation(codemarket.control.CadastroEntidadeViewController.class.getResource("/view/CadastroEntidadeView.fxml")); // Aqui estava dando problema, só podia abrir uma vez
        AnchorPane page = (AnchorPane) loader.load();
        
        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Cliente");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
//        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Cliente");
        controller.setDialogStage(dialogStage);
        
        dialogStage.showAndWait();
    }
    
    @FXML
    void handleButtonEditar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Editar Cliente");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
//        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Editar Cadastro do Cliente");
        controller.setDialogStage(dialogStage);
    
        dialogStage.showAndWait();
    }
    
    @FXML
    private void handleButtonAtualizar() {
        atualizarTabela();
    }
    
    private void atualizarTabela() {
        // Limpa os dados existentes na tabela
        infoF.clear();

        // Carrega os dados atualizados
        TelefoneRN tel = new TelefoneRN();
        clientes = c.pesquisar("SELECT t FROM TbCliente t");
        
        for (TbCliente cliente : clientes) {
            TbTelefone fone = (TbTelefone) tel.pesquisar("SELECT t.ehtFoneId FROM TbEntidadeHasTelefone t WHERE"
                    + " t.ehtentcpfCnpj.tbCliente.clicpfCnpj = '" 
                    + cliente.getClicpfCnpj().getEntcpfCnpj() + "'").get(0);
            FornecedorClienteModel fm = new FornecedorClienteModel(cliente.getClicpfCnpj().getEntNome(), cliente.getClicpfCnpj().getEntnomeFantasia(),
                    cliente.getClicpfCnpj().getEntcpfCnpj(), cliente.getClicpfCnpj().getEntEmail(),
                    fone.getFoneDescricao());
            infoF.add(fm);
        }

        // Atualiza a tabela com os dados carregados
        tableViewCliente.setItems(infoF);
    }
}