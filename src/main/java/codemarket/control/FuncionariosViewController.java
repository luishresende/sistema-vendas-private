/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.control.tableViewModel.FuncionarioModel;
import codemarket.model.rn.FornecedorRN;
import codemarket.model.rn.FuncionarioRN;
import codemarket.model.rn.TelefoneRN;
import codemarket.model.vo.TbFornecedor;
import codemarket.model.vo.TbFuncionario;
import codemarket.model.vo.TbTelefone;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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

/**
 * FXML Controller class
 *
 * @author Iuri Pereira
 */
public class FuncionariosViewController implements Initializable {

    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Button buttonVisualizar;
    
    @FXML
    private TableView<FuncionarioModel> tableViewFuncionario;
    @FXML
    private TableColumn<FuncionarioModel, String> colunaNome;
    @FXML
    private TableColumn<FuncionarioModel, String> colunaCPF;
    @FXML
    private TableColumn<FuncionarioModel, String> colunaUsuario;
    @FXML
    private TableColumn<FuncionarioModel, String> colunaTelefone;
    @FXML
    private TableColumn<FuncionarioModel, String> colunaVencimento;

    private ObservableList<FuncionarioModel> infoF = FXCollections.observableArrayList();

    private Stage dialogStage;
    private final FXMLLoader loader = new FXMLLoader();
    private static CadastroFuncionarioViewController cadastroController = new CadastroFuncionarioViewController();

    
    FuncionarioRN f = new FuncionarioRN();
    List<TbFuncionario> funcionarios = f.pesquisar("SELECT t FROM TbFuncionario t");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TelefoneRN tel = new TelefoneRN();
        for (TbFuncionario forne : funcionarios) {
            List fone = tel.pesquisar("SELECT t.ehtFoneId FROM TbEntidadeHasTelefone "
                    + "t WHERE t.ehtentcpfCnpj.tbFuncionario.funcentcpfCnpj = '" 
                    + forne.getFuncentcpfCnpj().getEntcpfCnpj() + "'");
            TbTelefone telefone;
            String userFone;
            if(fone.isEmpty())
                userFone = "";
            else {
                telefone = (TbTelefone) fone.get(0);
                userFone = telefone.getFoneDescricao();
            }
            String vencimento;
            if(dateFormat.format(forne.getFuncUsuario().getUsuValidade()) == null)
                vencimento = "";
            else
                vencimento = dateFormat.format(forne.getFuncUsuario().getUsuValidade());
                
            FuncionarioModel fm = new FuncionarioModel(forne.getFuncentcpfCnpj().getEntNome(), forne.getFuncentcpfCnpj().getEntcpfCnpj(),
                    forne.getFuncUsuario().getUsuUsuario(), userFone, vencimento);
            infoF.add(fm);
        }
        

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        colunaUsuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        colunaVencimento.setCellValueFactory(new PropertyValueFactory<>("Vencimento"));
        tableViewFuncionario.setItems(infoF);
    }    

    @FXML
    private void handleButtonCadastrar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroFuncionarioView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Funcionário");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        
        codemarket.control.CadastroFuncionarioViewController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Funcionário");
        controller.setDialogStage(dialogStage);
        
        dialogStage.showAndWait();
    }

@FXML
private void handleButtonEditar() throws IOException {
    FuncionarioModel selectedFunc = tableViewFuncionario.getSelectionModel().getSelectedItem();
    if (selectedFunc != null) {
        FuncionarioRN funcionariorn = new FuncionarioRN();
        TbFuncionario funcionarioParaEditar = funcionariorn.listaUm("funcentcpfCnpj.entcpfCnpj", selectedFunc.getCPF(), TbFuncionario.class);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroFuncionarioView.fxml"));
        
        AnchorPane page = (AnchorPane) loader.load();

        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Cadastrar Funcionário");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);
        codemarket.control.CadastroFuncionarioViewController controller = loader.getController();
        controller.setTituloJanela("Cadastrar Funcionário");
        controller.editarFuncionario(funcionarioParaEditar);
        controller.setDialogStage(dialogStage);
        
        
        dialogStage.showAndWait();
    } else {
        // Exiba uma mensagem de aviso caso nenhum funcionário seja selecionado
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, selecione um funcionário para editar.");
        alert.showAndWait();
    }
}

    @FXML
    private void handleButtonRemover(ActionEvent event) {
        // Obtém a linha selecionada da tabela
        FuncionarioModel selectedFunc = tableViewFuncionario.getSelectionModel().getSelectedItem();

        if (selectedFunc != null) {
            // Cria um alerta de confirmação
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de Remoção");
            alert.setHeaderText("Tem certeza que deseja remover o fornecedor?");
            alert.setContentText("Nome: " + selectedFunc.getNome() + "\nCNPJ: " + selectedFunc.getCPF());

            // Exibe o alerta e aguarda a resposta do usuário
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    FuncionarioRN funcionario = new FuncionarioRN();
                    TbFuncionario funcExcluir = funcionario.listaUm("funcentcpfCnpj.entcpfCnpj", selectedFunc.getCPF(), TbFuncionario.class);                        
                    funcionario.excluir(funcExcluir);
                    infoF.remove(selectedFunc);
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
    private void handleButtonVisualizar(ActionEvent event) {
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
        funcionarios = f.pesquisar("SELECT t FROM TbFuncionario t");
        
        for (TbFuncionario forne : funcionarios) {
            List fone = tel.pesquisar("SELECT t.ehtFoneId FROM TbEntidadeHasTelefone "
                    + "t WHERE t.ehtentcpfCnpj.tbFuncionario.funcentcpfCnpj = '" 
                    + forne.getFuncentcpfCnpj().getEntcpfCnpj() + "'");
            TbTelefone telefone;
            String userFone;
            if(fone.isEmpty())
                userFone = "";
            else {
                telefone = (TbTelefone) fone.get(0);
                userFone = telefone.getFoneDescricao();
            }
            String vencimento;
            if(dateFormat.format(forne.getFuncUsuario().getUsuValidade()) == null)
                vencimento = "";
            else
                vencimento = dateFormat.format(forne.getFuncUsuario().getUsuValidade());
                
            FuncionarioModel fm = new FuncionarioModel(forne.getFuncentcpfCnpj().getEntNome(), forne.getFuncentcpfCnpj().getEntcpfCnpj(),
                    forne.getFuncUsuario().getUsuUsuario(), userFone, vencimento);
            infoF.add(fm);
        }

        // Atualiza a tabela com os dados carregados
        tableViewFuncionario.setItems(infoF);
    }
}
