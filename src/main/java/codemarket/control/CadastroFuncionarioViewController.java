package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.*;
import codemarket.model.utils.DisplayDialogScreen;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private boolean editar = false;
    private TbFuncionario funcionarioEditar;
    
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
        END.validarCEP(event, cep);
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
        
        cpf.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    FUNC.handleFocusLostCPFCNPJ(null, cpf);
                }
            }
        });
        rg.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    FUNC.handleFocusLostRG(null, rg);
                }
            }
        });
        ddd.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    TEL.handleFocusLostDDD(null, ddd);
                }
            }
        });
        fone.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    TEL.handleFocusLostFone(null, fone);
                }
            }
        });
        cep.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    END.handleFocusLostCEP(null, cep);
                }
            }
        });
    }    
    
    @FXML
    void handleFinalizarButton() {
        if (verificaCampos() && verificaTabela(tableEnd) && verificaTabela(tableFone)) {
            if(editar){
                
            }else{               
                TbSexo sexo = null;
                if (tipoSexo.getValue().isEmpty() == false) {
                    sexo = SEX.listaUm("sexDescricao", tipoSexo.getValue(), TbSexo.class);
                }

                LocalDate dtNASC = dataNASC.getValue();  // Obter a data do DatePicker
                Date dateNASC = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());

                TbEntidade ENTIDADE = new TbEntidade(cpf.getText(), nome.getText(), nomeFantasia.getText(), 
                                                    rg.getText(), email.getText(), "Fisico", dateNASC, sexo);

                int i = 0;
                for (FoneModel fones : telefones) {
                    TelefoneTipoRN tipoTRN = new TelefoneTipoRN();
                    TbTipoTelefone tipo = tipoTRN.listaUm("ttDescricao", fones.getTipoContato(), TbTipoTelefone.class);
                    TbTelefone tell = new TbTelefone(fones.getDdd() + fones.getFone(), tipo, fones.getNomeContato());

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
                if(USU.verificaSenhas(senha, confirmaSenha)) {
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

                    if(editar){
                        funcionarioEditar.setFuncentcpfCnpj(ENTIDADE);
                        funcionarioEditar.setFuncUsuario(Usuario);
                        funcionarioEditar.setFuncCargo(cargo);
                        funcionarioEditar.setFuncStatus(staValor);
                        FUNC.atualizar(funcionarioEditar);
                    }else{
                        TbFuncionario funcionario = new TbFuncionario(ENTIDADE, Usuario, cargo, staValor);
                        FUNC.salvar(funcionario);
                    }
                    JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                    dialogStage.close();
                } else {
                    DisplayDialogScreen.getInstance().displayErrorScreen("Senhas", "Verifique a senha!", "As senhas não conferem.");
                }
            }
        } else {
            DisplayDialogScreen.getInstance().displayErrorScreen("Finalizar Cadastro", "Campos obrigatórios *", "Preencha todos os "
                        + "campos! \nAs tabelas de endereço e telefone tem que conter pelo menos uma informação.");
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
            DisplayDialogScreen.getInstance().displayErrorScreen("Tabela de Telefone", "Alguns campos vazios!", "Preencha os campos para inserir na tabela antes de salvar.");
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

            tipoEndereco.setValue("Selecione...");
            cep.clear();
            cidade.setValue("Selecione...");
            estado.setValue("Selecione...");
            pais.setValue("Selecione...");
            nomerua.clear();
            logradouro.setValue("Selecione...");
            bairro.clear();
            complemento.clear();
            numero.clear();
        } else {
            DisplayDialogScreen.getInstance().displayErrorScreen("Tabela de Endereco", "Alguns campos vazios!", "Preencha os campos para inserir na tabela antes de salvar.");
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
        if (ENT.validarNome(nome)){ camposValidos = false;}
        if (FUNC.validarCPF(cpf)) { camposValidos = false;};
        if (ENT.validarRGIE(rg)) { camposValidos = false;}
        if (ENT.validarNomeFantasia(nomeFantasia)) { camposValidos = false;}
        if (ENT.validarCampoData(dataNASC)) { camposValidos = false;}
        if (ENT.validarEmail(email)){ camposValidos = false;}
        if (SEX.validarCampo(tipoSexo)) { camposValidos = false;}
        if (USU.validarCampoUsuario(usuario)) { camposValidos = false;}
        if (USU.validarCampoSenha(senha)) { camposValidos = false;}
        if (USU.validarCampoConfirmaSenha(confirmaSenha)) { camposValidos = false;}
        if (USU.validarComboBoxCargo(tipoCargo)) { camposValidos = false;}
        if (USU.validarComboBoxStatus(tipoStatus)) { camposValidos = false;}
        return camposValidos;
    }
    boolean verificaCamposTableFone() {
        boolean camposValidos = true;
        if (TTEL.validarCampoTipoContato(tipoContato)) { camposValidos = false;}
        if (TTEL.validarCampoNomeContato(nomeContato)) { camposValidos = false;}
        if (TEL.validarCampoDDD(ddd)) { camposValidos = false;}
        if (TEL.validarCampoFone(fone)) { camposValidos = false;}
        return camposValidos;
    }
    
    boolean verificaCamposTableEndereco() {
        boolean camposValidos = true;
        if (BAI.validarCampo(bairro)) { camposValidos = false;}
        if (LOG.validarCampo(logradouro)) { camposValidos = false;}
        if (TEND.validarCampo(tipoEndereco)) { camposValidos = false;}
        if (END.validarCampoCEP(cep)) { camposValidos = false;}
        if (END.validarCampoNomeRua(nomerua)) { camposValidos = false;}
        if (CEP.validarCampoPais(pais)) { camposValidos = false;}
        if (CEP.validarCampoEstado(estado)) { camposValidos = false;}
        if (CEP.validarCampoCidade(cidade)) { camposValidos = false;}
        return camposValidos;
    }
    boolean verificaTabela(TableView tableView) {
        if (tableView.getItems().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public void editarFuncionario(TbFuncionario funcionarioParaEditar) {
        this.funcionarioEditar = funcionarioParaEditar;
        editar = true;
        TbFuncionario funcionario = funcionarioParaEditar;
        TbEntidade entidade = funcionario.getFuncentcpfCnpj();
        TbUsuario usuarioFunc = funcionario.getFuncUsuario();

        nome.setText(entidade.getEntNome());
        nomeFantasia.setText(entidade.getEntnomeFantasia());
        cpf.setText(entidade.getEntcpfCnpj());
        rg.setText(entidade.getEntrgIe());
        email.setText(entidade.getEntEmail());
        
        java.sql.Date date = new java.sql.Date(entidade.getEntdtNasc().getTime());
        LocalDate aniv = date.toLocalDate();
        dataNASC.setValue(aniv);
        
        usuario.setText(usuarioFunc.getUsuUsuario());
        senha.setText(usuarioFunc.getUsuSenha());
        confirmaSenha.setText(usuarioFunc.getUsuSenha());
        
        java.sql.Date datef = new java.sql.Date(usuarioFunc.getUsuValidade().getTime());
        LocalDate valid = datef.toLocalDate();

        validade.setValue(valid);
        
        if (entidade.getEntSexo() != null) {
            tipoSexo.setValue(entidade.getEntSexo().getSexDescricao());
        }
        
        if(usuarioFunc.getUsuimgPerfil() != null) {
            ImageManipulation imageManipulation = new ImageManipulation();
            img.setImage(imageManipulation.convertToImage(usuarioFunc.getUsuimgPerfil()));
        }
        
        tipoCargo.setValue(funcionario.getFuncCargo().getCarDescricao());
        tipoStatus.setValue(funcionario.getFuncStatus().getStaDescricao());
        
       
       List<TbEndereco> enderecosList = entidade.getTbEnderecoList();
       for (TbEndereco endereco : enderecosList) {
           EnderecoModel enderecoModel = new EnderecoModel(
               endereco.getEndTipo().getTeDescricao(),
               endereco.getEndendPid().getEndCEP(),
               endereco.getEndendPid().getTbCidEstPai().getTbCidade().getCidDescricao(),
               endereco.getEndendPid().getTbCidEstPai().getTbEstado().getEstSigla(),
               endereco.getEndendPid().getTbCidEstPai().getCepPaiSigla().getPaiDescricao(),
               endereco.getEndendPid().getEndPnomerua(),
               endereco.getEndendPid().getEndPbaiid().getBaiDescricao(),
               endereco.getEndComplemento(),
               String.valueOf(endereco.getEndNumero()),
               endereco.getEndendPid().getEndPlogid().getLogDescricao()
           );
           enderecos.add(enderecoModel);
       }

       // Fetch and populate phone data
       List<TbEntidadeHasTelefone> telefonesList = entidade.getTbEntidadeHasTelefoneList();
       for (TbEntidadeHasTelefone entidadeHasTelefone : telefonesList) {
           TbTelefone telefone = entidadeHasTelefone.getEhtFoneId();
           String contado = telefone.getFoneDescricao();
           String dd = contado.substring(0, Math.min(contado.length(), 4));
           String resto = contado.substring(Math.min(contado.length(), 4));

           FoneModel foneModel = new FoneModel(
               telefone.getFonenomeContato(),
               dd,
               resto,
               telefone.getFoneTipo().getTtDescricao()
           );
           telefones.add(foneModel);
       }       

       }
    public boolean enderecoJaExisteNoBanco(TbEndereco end) {
        for(TbEndereco endereco : funcionarioEditar.getFuncentcpfCnpj().getTbEnderecoList()){
            if(end == endereco){
                return false;
            }
        }
        return true;
    }

    // Método para verificar se o telefone já existe no banco
    public boolean telefoneJaExisteNoBanco(TbTelefone fone) {
        for(TbTelefone telefone : funcionarioEditar.getFuncentcpfCnpj().getTbTelefoneList()){
            if(fone == telefone){
                return false;
            }
        }
        return true;
    }
}