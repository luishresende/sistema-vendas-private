/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.control.tableViewModel.FornecedorClienteModel;
import codemarket.model.rn.ClienteRN;
import codemarket.model.rn.FornecedorRN;
import codemarket.model.rn.TelefoneRN;
import codemarket.model.vo.TbCliente;
import codemarket.model.vo.TbFornecedor;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FornecedoresViewController implements Initializable {

    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonRemover;

    @FXML
    private TableView<FornecedorClienteModel> tableViewFornecedor;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaEmail;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaFone;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaNomeF;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaNome;
    @FXML
    private TableColumn<FornecedorClienteModel, String> colunaCNPJ;

    private ObservableList<FornecedorClienteModel> infoF = FXCollections.observableArrayList();

    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();
    
    FornecedorRN f = new FornecedorRN();
    List<TbFornecedor> fornecedores = f.pesquisar("SELECT t FROM TbFornecedor t");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TelefoneRN tel = new TelefoneRN();
        for (TbFornecedor forne : fornecedores) {
            TbTelefone fone = (TbTelefone) tel.pesquisar("SELECT t.ehtFoneId FROM TbEntidadeHasTelefone t WHERE"
                    + " t.ehtentcpfCnpj.tbFornecedor.forcpfCnpj = '" 
                    + forne.getForcpfCnpj().getEntcpfCnpj() + "'").get(0);
            FornecedorClienteModel fm = new FornecedorClienteModel(forne.getForcpfCnpj().getEntNome(), forne.getForcpfCnpj().getEntnomeFantasia(),
                    forne.getForcpfCnpj().getEntcpfCnpj(), forne.getForcpfCnpj().getEntEmail(),
                    fone.getFoneDescricao());
            infoF.add(fm);
        }

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colunaNomeF.setCellValueFactory(new PropertyValueFactory<>("NomeFantasia"));
        colunaCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colunaFone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        tableViewFornecedor.setItems(infoF);
    }

    @FXML
    private void handleButtonCadastrar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Fornecedor");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        boolean verdadeiro = true;
        codemarket.control.CadastroEntidadeViewController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Fornecedor");
        controller.setTipoEntidade2(verdadeiro);
        controller.setDialogStage(dialogStage);

        dialogStage.showAndWait();
    }

    @FXML
    private void handleButtonEditar() throws IOException {
        FornecedorClienteModel selectedFunc = tableViewFornecedor.getSelectionModel().getSelectedItem();
        if (selectedFunc != null) {
            FornecedorRN forrn = new FornecedorRN();
            TbFornecedor fornecedorParaEditar = forrn.listaUm("forcpfCnpj.entcpfCnpj", selectedFunc.getCNPJ(), TbFornecedor.class);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEntidadeView.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            

            Scene scene = new Scene(page);
            dialogStage = new Stage();
            dialogStage.setTitle("Editar Cliente");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            dialogStage.setScene(scene);
            codemarket.control.CadastroEntidadeViewController controller = loader.getController();
            controller.setTituloJanela("Editar Cadastro do Fornecedor");
            controller.editarClienteFornecedor(null, fornecedorParaEditar);
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
    private void handleButtonRemover() {
        // Obtém a linha selecionada da tabela
        FornecedorClienteModel selectedFornecedor = tableViewFornecedor.getSelectionModel().getSelectedItem();

        if (selectedFornecedor != null) {
            // Cria um alerta de confirmação
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de Remoção");
            alert.setHeaderText("Tem certeza que deseja remover o fornecedor?");
            alert.setContentText("Nome: " + selectedFornecedor.getNome() + "\nCNPJ: " + selectedFornecedor.getCNPJ());

            // Exibe o alerta e aguarda a resposta do usuário
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    FornecedorRN fornecedor = new FornecedorRN();
                    TbFornecedor fornecedorExcluir = fornecedor.listaUm("forcpfCnpj.entcpfCnpj", selectedFornecedor.getCNPJ(), TbFornecedor.class);                        
                    fornecedor.excluir(fornecedorExcluir);
                    infoF.remove(selectedFornecedor);
                } else {
                    // O usuário clicou em Cancelar ou fechou o alerta
                    System.out.println("Operação de remoção cancelada.");
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
        atualizarTabela();
    }
    
    private void atualizarTabela() {
        // Limpa os dados existentes na tabela
        infoF.clear();

        // Carrega os dados atualizados
        TelefoneRN tel = new TelefoneRN();
        fornecedores = f.pesquisar("SELECT t FROM TbFornecedor t");

        for (TbFornecedor forne : fornecedores) {
            TbTelefone fone = (TbTelefone) tel.pesquisar("SELECT t.ehtFoneId FROM TbEntidadeHasTelefone t WHERE"
                    + " t.ehtentcpfCnpj.tbFornecedor.forcpfCnpj = '"
                    + forne.getForcpfCnpj().getEntcpfCnpj() + "'").get(0);
            FornecedorClienteModel fm = new FornecedorClienteModel(forne.getForcpfCnpj().getEntNome(), forne.getForcpfCnpj().getEntnomeFantasia(),
                    forne.getForcpfCnpj().getEntcpfCnpj(), forne.getForcpfCnpj().getEntEmail(),
                    fone.getFoneDescricao());
            infoF.add(fm);
        }

        // Atualiza a tabela com os dados carregados
        tableViewFornecedor.setItems(infoF);
    }
}
