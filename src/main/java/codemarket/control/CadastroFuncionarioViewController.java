package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.*;
import codemarket.model.utils.ImageManipulation;
import codemarket.model.vo.*;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import static javafx.scene.paint.Color.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CadastroFuncionarioViewController implements Initializable {

    @FXML
    private Label labelNome, labelNomeFantasia, labelSexo, labelDtNasc, labelEmail, 
                  labelTipoContato, labelNomeContato, labelDDD, labelFone, labelEndereco, 
                  labelLogradouro, labelTipoEndereco, labelBairro, labelCEP, labelPais, 
                  labelEstado, labelCidade, labelCPF, labelRG, tituloJanela, labelUsuario, 
                  labelSenha, labelConfirmaSenha, labelCargo, labelStatus;
    @FXML
    private ImageView img;
    @FXML
    private Button imgButton;
    @FXML
    private ComboBox<String> cidade, estado, pais, tipoSexo, tipoStatus, tipoContato, logradouro, tipoEndereco, tipoCargo;
    @FXML
    private TextField nomerua, salario, fone, nome, bairro, confirmaSenha, senha, usuario,
            ddd, email, cpf, rg, cep, nomeFantasia, complemento, numero, nomeContato;
    @FXML
    private RadioButton brasileiro;
    @FXML
    private DatePicker dataNASC, validade;
    @FXML
    private TableView<EnderecoModel> tableEnd;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndtipo, tbEndcidade, tbEndest, tbEndpais, tbEndcep;
    @FXML
    private TableView<FoneModel> tableFone;
    @FXML
    private TableColumn<FoneModel, String> tbFoneddd, tbFonetipo, tbFonefone, tbFonenome;

    private ObservableList<FoneModel> telefones = FXCollections.observableArrayList();
    private ObservableList<EnderecoModel> enderecos = FXCollections.observableArrayList();
    private TbEndereco endPrincipal;
    private TbEntidadeHasEndereco e[] = new TbEntidadeHasEndereco[10];
    private TbEntidadeHasTelefone t[] = new TbEntidadeHasTelefone[10];
    private String filePathImageUser;
    
    private Stage dialogStage;
    UsuarioRN USU = new UsuarioRN();
    FuncionarioRN FUNC = new FuncionarioRN();
    EntidadeRN ENT = new EntidadeRN();
    TelefoneRN TEL = new TelefoneRN();
    TelefoneTipoRN TTEL = new TelefoneTipoRN();
    SexoRN SEX = new SexoRN();
    BairroRN BAI = new BairroRN();
    CidEstPaiRN CEP = new CidEstPaiRN();
    LogradouroRN LOG = new LogradouroRN();
    EndPostalRN END = new EndPostalRN();
    TipoEnderecoRN TEND = new TipoEnderecoRN();

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
    void validarCPF(KeyEvent event) {
        FUNC.validarCPF(event, cpf);
    }
    
    @FXML
    void validarRG(KeyEvent event) {
        ENT.validarRGIE(event, rg);
    }
    
    @FXML
    void validarDDD(KeyEvent event) {
        TEL.validarDDD(event, ddd);
    }

    @FXML
    void validarFONE(KeyEvent event) {
        TEL.validarFONE(event, fone);
    }

    @FXML
    void validarNUM(KeyEvent event) {
        ENT.validarNUM(event, numero);
    }
    
    @FXML
    void validarCEP(KeyEvent event) {
        ENT.validarCEP(event, cep);
    }
    
    @FXML
    void onTipoCargoSelecionado(ActionEvent event) {
        USU.onTipoCargoSelecionado(event, salario, tipoCargo);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validade.setDayCellFactory(USU.getDataPosterior());   // Só seleciona datas posteriores ao dia atual
        dataNASC.setDayCellFactory(USU.getDataAnterior());    // Só seleciona datas anteriores ao dia atual
        imgButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            // Abrir o diálogo de seleção de arquivo
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            
            if (selectedFile != null) {
                // Carregar a imagem selecionada
                filePathImageUser = selectedFile.getPath();
                Image image = new Image(selectedFile.toURI().toString());
                
                // Definir a imagem no ImageView
                img.setImage(image);
            }
        });
        
        tbEndtipo.setCellValueFactory(new PropertyValueFactory<>("tipoEndereco"));
        tbEndcep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        tbEndcidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        tbEndpais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        tbEndest.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableEnd.setItems(enderecos);

        tbFonenome.setCellValueFactory(new PropertyValueFactory<>("nomeContato"));
        tbFoneddd.setCellValueFactory(new PropertyValueFactory<>("ddd"));
        tbFonefone.setCellValueFactory(new PropertyValueFactory<>("Fone"));
        tbFonetipo.setCellValueFactory(new PropertyValueFactory<>("tipoContato"));
        tableFone.setItems(telefones);

        /* ----------------- Combo Box - Tipo de Sexo ----------------------- */
        // Adicionando dados do Tipo de Sexo
        SexoRN sexo = new SexoRN();
        ArrayList tiposSexo = (ArrayList) sexo.buscarTodos("sexDescricao");
        ObservableList<String> TS = FXCollections.observableArrayList(tiposSexo);
        tipoSexo.setItems(TS);

        /* ------------------------------------------------------------------ */
        /* ----------------- Combo Box - Tipo de Endereço ------------------- */
        // Adicionando dados do Tipo de Sexo
        TipoEnderecoRN tendRN = new TipoEnderecoRN();
        ArrayList ends = (ArrayList) tendRN.buscarTodos("teDescricao");
        ObservableList<String> ENDS = FXCollections.observableArrayList(ends);
        tipoEndereco.setItems(ENDS);
        /* ------------------------------------------------------------------ */
        /* ----------------- Combo Box - Tipo de Estado ------------------- */
        // Adicionando dados do Tipo de Estado
        EstadoRN es = new EstadoRN();
        ArrayList listEstados = (ArrayList) es.buscarTodos("estSigla");
        ObservableList<String> ET = FXCollections.observableArrayList(listEstados);
        estado.setItems(ET);
        /* ------------------------------------------------------------------ */
        /* ------------------ Combo Box - Tipo de Cidade -------------------- */
        // Adicionando dados do Tipo de Cidade
        CidadeRN cd = new CidadeRN();
        estado.setOnAction(event -> {
            String jpql = " SELECT t.tbCidade.cidDescricao FROM TbCidEstPai t WHERE t.tbCidEstPaiPK.cepEstSigla = '" + estado.getValue() + "'";
            List<String> listCidades = cd.pesquisar(jpql);
            ObservableList<String> CI = FXCollections.observableArrayList(listCidades);
            cidade.setItems(CI);
        });
        /* ------------------------------------------------------------------ */

        TelefoneTipoRN telRN = new TelefoneTipoRN();
        ArrayList tipotelefones = (ArrayList) telRN.buscarTodos("ttDescricao");
        ObservableList<String> TT = FXCollections.observableArrayList(tipotelefones);
        tipoContato.setItems(TT);

        PaisRN paiRN = new PaisRN();
        ArrayList paises = (ArrayList) paiRN.buscarTodos("paiDescricao");
        ObservableList<String> P = FXCollections.observableArrayList(paises);
        pais.setItems(P);
        
        brasileiro.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {
                brasileiro.setSelected(true); // Impede que o RadioButton seja desmarcado
            }
        });
        
        LogradouroRN logRN = new LogradouroRN();
        ArrayList loges = (ArrayList) logRN.buscarTodos("logDescricao");
        ObservableList<String> looo = FXCollections.observableArrayList(loges);
        logradouro.setItems(looo);
        
        StatusRN statusRN = new StatusRN();
        ArrayList status = (ArrayList) statusRN.buscarTodos("staDescricao");
        ObservableList<String> sta = FXCollections.observableArrayList(status);
        tipoStatus.setItems(sta);
        
        CargoRN carRN = new CargoRN();
        ArrayList carg = (ArrayList) carRN.buscarTodos("carDescricao");
        ObservableList<String> caR = FXCollections.observableArrayList(carg);
        tipoCargo.setItems(caR);
        
        ENT.ficaVerificandoCampos(nome, labelNome, nomeFantasia, labelNomeFantasia, cpf, labelCPF, 
                                  rg, labelRG, email, labelEmail, nomeContato, labelNomeContato, 
                                  ddd, labelDDD, fone, labelFone, nomerua, labelEndereco, bairro, labelBairro, 
                                  cep, labelCEP);
        USU.ficaVerificandoCampos(usuario, labelUsuario, senha, labelSenha, confirmaSenha, labelConfirmaSenha);
        
        Platform.runLater(() -> {
            setLabelColor(labelNome); setLabelColor(labelUsuario); setLabelColor(labelSexo); setLabelColor(labelSenha);
            setLabelColor(labelDtNasc); setLabelColor(labelEmail); setLabelColor(labelCPF); setLabelColor(labelRG);
            setLabelColor(labelTipoContato); setLabelColor(labelNomeContato); setLabelColor(labelDDD); setLabelColor(labelFone);
            setLabelColor(labelEndereco); setLabelColor(labelLogradouro); setLabelColor(labelTipoEndereco); setLabelColor(labelBairro); setLabelColor(labelCEP);
            setLabelColor(labelPais); setLabelColor(labelEstado); setLabelColor(labelCidade); setLabelColor(labelCargo);
            setLabelColor(labelStatus); setComboBoxColor(pais); setComboBoxColor(estado);
            setComboBoxColor(cidade); setComboBoxColor(logradouro); setComboBoxColor(tipoStatus); setComboBoxColor(tipoContato);
            setComboBoxColor(tipoEndereco); setComboBoxColor(tipoSexo); setComboBoxColor(tipoCargo);
        });
    }    
    
    @FXML
    void handleFinalizarButton() {
        if (verificaCampos() && verificaTabela(tableEnd) && verificaTabela(tableFone)) {
            SexoRN sexorn = new SexoRN();
            TbSexo sexo = null;
            if (tipoSexo.getValue().isEmpty() == false) {
                sexo = sexorn.listaUm("sexDescricao", tipoSexo.getValue(), TbSexo.class);
            }

            LocalDate dtNASC = dataNASC.getValue();  // Obter a data do DatePicker
            Date dateNASC = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());

            TbEntidade ENTIDADE = new TbEntidade(cpf.getText(), nome.getText(), nomeFantasia.getText(), 
                                                rg.getText(), email.getText(), "Fisico", dateNASC, sexo);

            int i = 0;
            for (FoneModel fones : telefones) {
                TelefoneTipoRN tipoTRN = new TelefoneTipoRN();
                TbTipoTelefone tipo = tipoTRN.listaUm("ttDescricao", fones.getTipoContato(), TbTipoTelefone.class);
                TbTelefone tell = new TbTelefone(fones.getDdd() + fones.getFone(), tipo);

                t[i] = new TbEntidadeHasTelefone(tell, ENTIDADE);
                i++;
            }

            i = 0;
            for (EnderecoModel endereco : enderecos) {
                TbBairro bairroSalvar = new TbBairro(endereco.getBairro());

                TbLogradouro lougradouroSalvar = new TbLogradouro(endereco.getLogradouro());

                CidadeRN cid = new CidadeRN();
                String jpql = "SELECT t.tbCidade FROM TbCidEstPai t WHERE "
                        + "t.tbEstado.estSigla = '" + endereco.getEstado() + "' "
                        + "AND t.tbCidade.cidDescricao = '" + endereco.getCidade() + "'";
                TbCidade new_cid = (TbCidade) cid.pesquisar(jpql).get(0);

                CidEstPaiRN CEP = new CidEstPaiRN();
                TbCidEstPai ceps = (TbCidEstPai) CEP.pesquisar("SELECT t FROM TbCidEstPai t "
                        + "WHERE t.tbEstado.estSigla = '" + endereco.getEstado() + "' AND t.tbCidade.cidId = '"
                        + new_cid.getCidId() + "'").get(0);

                TbEndPostal postal = new TbEndPostal(endereco.getNomerua(), endereco.getCep(), lougradouroSalvar, bairroSalvar, ceps);

                TipoEnderecoRN te = new TipoEnderecoRN();
                TbTipoEndereco tende = te.listaUm("teDescricao", endereco.getTipoEndereco(), TbTipoEndereco.class);

                TbEndereco ende = new TbEndereco(Integer.parseInt(endereco.getNumero()), endereco.getComplemento(), postal, tende);

                e[i] = new TbEntidadeHasEndereco(ENTIDADE, ende);

                i++;
                this.endPrincipal = ende;
            }

            ENTIDADE.setEntEnderecoPrincipal(endPrincipal);

            StatusRN staRN = new StatusRN();
            TbStatus staValor = staRN.listaUm("staDescricao", tipoStatus.getValue(), TbStatus.class);

            LocalDate dtValidade = validade.getValue();  // Obter a data do DatePicker
            Date dataValidade = Date.from(dtValidade.atStartOfDay(ZoneId.systemDefault()).toInstant());

            TbUsuario Usuario = null;
            if(senha.getText().equals(confirmaSenha.getText())) {
                ImageManipulation imageMan = new ImageManipulation();
                byte[] imageByte = null;
                if(filePathImageUser != null){
                    imageByte = imageMan.convertToBytes(filePathImageUser);
                }
                Usuario = new TbUsuario(usuario.getText(), senha.getText(), dataValidade, staValor, imageByte);
                CargoRN carRN = new CargoRN();
                TbCargo cargo = carRN.listaUm("carDescricao", tipoCargo.getValue(), TbCargo.class);

                EntidadeHasTelefoneRN eht = new EntidadeHasTelefoneRN();
                for (TbEntidadeHasTelefone tel : t) {
                    if (tel == null) {
                        break;
                    }
                    eht.salvar(tel);
                }
                EntidadeHasEnderecoRN ehe = new EntidadeHasEnderecoRN();
                for (TbEntidadeHasEndereco end : e) {
                    if (end == null) {
                        break;
                    }
                    ehe.salvar(end);
                }

                TbFuncionario funcionario = new TbFuncionario(ENTIDADE, Usuario, cargo, staValor);
                FUNC.salvar(funcionario);
                JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                dialogStage.close();
            } else {
                displayErrorScreen();
            }
        } else {
            exibirAlerta("Preencha todos os campos marcados antes de finalizar.");
        }
    }

    @FXML
    void handleCancelarbutton() {
        dialogStage.close();
    }

    @FXML
    void handleSalvarFonebutton() {
        if (verificaCamposTableFone()) {
            FoneModel novoFone = new FoneModel(nomeContato.getText(), ddd.getText(), fone.getText(), tipoContato.getValue());
            telefones.add(novoFone);

            nomeContato.clear();
            ddd.clear();
            fone.clear();
            tipoContato.setPromptText("Selecione...");
        } else {
            exibirAlerta("Preencha todos os campos para inserir na tabela telefone.");
        }
    }

    @FXML
    void handleSalvarEndbutton() {
        if(verificaCamposTableEndereco()){
            EnderecoModel novoEndereco = new EnderecoModel(tipoEndereco.getValue(), cep.getText(),
                    cidade.getValue(), estado.getValue(),
                    pais.getValue(), nomerua.getText(),
                    bairro.getText(), complemento.getText(), numero.getText(), logradouro.getValue());
            enderecos.add(novoEndereco);

            tipoEndereco.setPromptText("Selecione...");
            cep.clear();
            cidade.setPromptText("Selecione...");
            estado.setPromptText("Selecione...");
            pais.setPromptText("Selecione...");
            nomerua.clear();
            logradouro.setPromptText("Selecione...");
            bairro.clear();
            complemento.clear();
            numero.clear();
        } else {
            exibirAlerta("Preencha todos os campos para inserir na tabela endereco.");
        }
    }

    @FXML
    void handlerAlterarEndButton() {
        EnderecoModel selectedEndereco = tableEnd.getSelectionModel().getSelectedItem();
        if (selectedEndereco != null) {
            tipoEndereco.setValue(selectedEndereco.getTipoEndereco());
            cep.setText(selectedEndereco.getCep());
            cidade.setValue(selectedEndereco.getCidade());
            estado.setValue(selectedEndereco.getEstado());
            pais.setValue(selectedEndereco.getPais());
            logradouro.setValue(selectedEndereco.getLogradouro());
            nomerua.setText(selectedEndereco.getNomerua());
            bairro.setText(selectedEndereco.getBairro());
            complemento.setText(selectedEndereco.getComplemento());
            numero.setText(selectedEndereco.getNumero());

            // Remova o item da lista de endereços
            enderecos.remove(selectedEndereco);
        }
    }

    @FXML
    void handlerAlterarFoneButton() {
        FoneModel selectedFone = tableFone.getSelectionModel().getSelectedItem();
        if (selectedFone != null) {
            nomeContato.setText(selectedFone.getNomeContato());
            ddd.setText(selectedFone.getDdd());
            fone.setText(selectedFone.getFone());
            tipoContato.setValue(selectedFone.getTipoContato());

            // Remova o item da lista de telefones
            telefones.remove(selectedFone);
        }
    }
    
    @FXML
    void handlerCancelarFone() {
        FoneModel selectedFone = tableFone.getSelectionModel().getSelectedItem();
        telefones.remove(selectedFone);
    }
    
    @FXML
    void handlerCancelarEnd() {
        EnderecoModel selectedEndereco = tableEnd.getSelectionModel().getSelectedItem();
        enderecos.remove(selectedEndereco);
    }
    
    boolean verificaCampos() {
        boolean camposValidos = true;
        if (ENT.validarNome(nome)){ labelNome.setTextFill(RED); nome.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarCPFCNPJ(cpf)) { labelCPF.setTextFill(RED); cpf.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarRGIE(rg)) { labelRG.setTextFill(RED); rg.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarNomeFantasia(nomeFantasia)) { labelNomeFantasia.setTextFill(RED); nomeFantasia.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarEmail(email)) { labelEmail.setTextFill(RED); email.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarCampoData(dataNASC)) { labelDtNasc.setTextFill(RED); dataNASC.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (SEX.validarCampo(tipoSexo)) { labelSexo.setTextFill(RED); tipoSexo.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (USU.validarCampoUsuario(usuario)) { labelUsuario.setTextFill(RED); usuario.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (USU.validarCampoSenha(senha)) { labelSenha.setTextFill(RED); senha.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (USU.validarCampoConfirmaSenha(confirmaSenha)) { labelConfirmaSenha.setTextFill(RED); confirmaSenha.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (USU.validarComboBoxCargo(tipoCargo)) { labelCargo.setTextFill(RED); tipoCargo.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (USU.validarComboBoxStatus(tipoStatus)) { labelStatus.setTextFill(RED); tipoStatus.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        return camposValidos;
    }
    boolean verificaCamposTableFone() {
        boolean camposValidos = true;
        if (TTEL.validarCampoTipoContato(tipoContato)) { labelTipoContato.setTextFill(RED); tipoContato.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (TTEL.validarCampoNomeContato(nomeContato)) { labelNomeContato.setTextFill(RED); nomeContato.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (TEL.validarCampoDDD(ddd)) { labelDDD.setTextFill(RED); ddd.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (TEL.validarCampoFone(fone)) { labelFone.setTextFill(RED); fone.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        return camposValidos;
    }
    
    boolean verificaCamposTableEndereco() {
        boolean camposValidos = true;
        if (BAI.validarCampo(bairro)) { labelBairro.setTextFill(RED); bairro.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (LOG.validarCampo(logradouro)) { labelLogradouro.setTextFill(RED); logradouro.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (TEND.validarCampo(tipoEndereco)) { labelTipoEndereco.setTextFill(RED); tipoEndereco.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (END.validarCampoCEP(cep)) { labelCEP.setTextFill(RED); cep.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (END.validarCampoNomeRua(nomerua)) { labelEndereco.setTextFill(RED); nomerua.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (CEP.validarCampoPais(pais)) { labelPais.setTextFill(RED); pais.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (CEP.validarCampoEstado(estado)) { labelEstado.setTextFill(RED); estado.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (CEP.validarCampoCidade(cidade)) { labelCidade.setTextFill(RED); cidade.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        return camposValidos;
    }
    boolean verificaTabela(TableView tableView) {
        if (tableView.getItems().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    void setLabelColor(Label label) {
        label.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                label.setStyle("-fx-text-fill: black;"); // Altere a cor para vermelho quando focado
            } 
        });
    }
    void setComboBoxColor(ComboBox<String> box) {
        box.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                box.setStyle("-fx-border-color: transparent;"); // Altere a cor para vermelho quando focado
            } 
        });
    }
    public void exibirAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validação de Campos");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    public void displayErrorScreen() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Ocorreu um erro");
        alert.setContentText("As senhas são diferentes!");
        alert.showAndWait();
    }
}