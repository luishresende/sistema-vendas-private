package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.*;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.*;
import java.net.URL;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import static javafx.scene.paint.Color.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CadastroEntidadeViewController implements Initializable {

    @FXML
    private Label labelNome, labelTipoEntidade, labelNomeFantasia, labelSexo, labelTipoCliente, labelDtNasc,
            labelEmail, labelTipoContato, labelNomeContato, labelDDD, labelFone, labelEndereco, labelLogradouro,
            labelTipoEnd, labelBairro, labelCEP, labelPais, labelEstado, labelCidade, labelCPFCNPJ, labelRGIE, tituloJanela;
    @FXML
    private CheckBox tipoEntidade1, tipoEntidade2;
    @FXML
    private ComboBox<String> cidade, tipoContato, tipoCliente, tipoEndereco, logradouro, estado, tipoSexo, pais;
    @FXML
    private RadioButton estrangeiro, brasileiro;
    @FXML
    private TextField numero, cpfcnpj, rgie, cep, nomeFantasia, complemento, nomeContato, email, codigo, ddd,
            bairro, nome, fone, nomerua;
    @FXML
    private DatePicker dataNASC;
    @FXML
    private TableView<EnderecoModel> tableEnd;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndtipo, tbEndcidade, tbEndest, tbEndpais, tbEndcep;
    @FXML
    private TableView<FoneModel> tableFone;
    @FXML
    private TableColumn<FoneModel, String> tbFoneddd, tbFonetipo, tbFonefone, tbFonenome;

    private ToggleGroup nacionalidade, seleEntidade;

    private ObservableList<FoneModel> telefones = FXCollections.observableArrayList();
    private ObservableList<EnderecoModel> enderecos = FXCollections.observableArrayList();
    private TbEndereco endPrincipal;
    private TbEntidadeHasEndereco e[] = new TbEntidadeHasEndereco[10];
    private TbEntidadeHasTelefone t[] = new TbEntidadeHasTelefone[10];
    private TbCliente CLIENTE = null;
    private TbFornecedor FORNECEDOR = null;
    private TbSexo SEXO = new TbSexo();
    private TbEntidade ENTIDADE = new TbEntidade();
    private TbTipoTelefone TIPOTELEFONE = new TbTipoTelefone();
    private TbTelefone TELEFONE = new TbTelefone();
    private TbEndPostal ENDPOSTAL = new TbEndPostal();
    private TbCidEstPai CEPS = new TbCidEstPai();
    private TbLogradouro LOGRADOURO = new TbLogradouro();
    private TbTipoEndereco TIPOENDERECO = new TbTipoEndereco();
    private TbBairro BAIRRO = new TbBairro();
    private EntidadeHasTelefoneRN EHT = new EntidadeHasTelefoneRN();

    private Stage dialogStage;
    EntidadeRN ENT = new EntidadeRN();
    TelefoneTipoRN TTEL = new TelefoneTipoRN();
    TelefoneRN TEL = new TelefoneRN();
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

    public void setTipoEntidade1(boolean True) {
        this.tipoEntidade1.setSelected(True);
    }

    public void setTipoEntidade2(boolean True) {
        this.tipoEntidade2.setSelected(True);
    }

    // Evento que fica verificando o tipo de cliente
    @FXML
    void onTipoClienteChanged(ActionEvent event) {
        ENT.onTipoClienteChanged(event, tipoCliente, cpfcnpj, rgie, labelCPFCNPJ, labelRGIE, tipoSexo, dataNASC);
    }

    // Evento que verifica a entrada do teclado para a formatação e aceitação de só numéro para CPF / CNPJ
    @FXML
    void validarCPFCNPJ(KeyEvent event) {
        ENT.validaCPFCNPJ(event, cpfcnpj, tipoCliente);
    }

    // Evento que verifica a entrada do teclado para o RG, só aceita numero 
    @FXML
    void validarRGIE(KeyEvent event) {
        ENT.validarRGIE(event, rgie);
    }

    // Evento para verificar só a entrada de numeros e formata para DDD
    @FXML
    void validarDDD(KeyEvent event) {
        TEL.validarDDD(event, ddd);
    }

    // Evento para verificar só a entrada de numeros e formata para Telefone
    @FXML
    void validarFONE(KeyEvent event) {
        TEL.validarFONE(event, fone);
    }

    // Evento para verificar só a entrada de numeros
    @FXML
    void validarNUM(KeyEvent event) {
        ENT.validarNUM(event, numero);
    }

    // Evento para verificar só a entrada de numeros e formata para CEP
    @FXML
    void validarCEP(KeyEvent event) {
        END.validarCEP(event, cep);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataNASC.setDayCellFactory(ENT.getDataAnterior());
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

        /* --------------- Combo Box - Tipo de Cliente ---------------------- */
        // Adicionando dados do Tipo de Cliente
        ObservableList<String> tipo = FXCollections.observableArrayList(
                "Físico",
                "Jurídico"
        );
        tipoCliente.setItems(tipo);
        tipoCliente.setValue("Físico");
        /* ------------------------------------------------------------------ */

 /* ----------------- Combo Box - Tipo de Sexo ----------------------- */
        // Adicionando dados do Tipo de Sexo
        SexoRN SEXO = new SexoRN();
        ArrayList tiposSexo = (ArrayList) SEXO.buscarTodos("sexDescricao");
        ObservableList<String> TS = FXCollections.observableArrayList(tiposSexo);
        tipoSexo.setItems(TS);

        /* ------------------------------------------------------------------ */
 /* ----------------- Combo Box - Tipo de Endereço ------------------- */
        // Adicionando dados do Tipo de Endereço
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
                brasileiro.setSelected(true); // Impede que o CheckBox seja desmarcado
            }
        });

        LogradouroRN logRN = new LogradouroRN();
        ArrayList loges = (ArrayList) logRN.buscarTodos("logDescricao");
        ObservableList<String> looo = FXCollections.observableArrayList(loges);
        logradouro.setItems(looo);
        
        ENT.ficaVerificandoCampos(nome, labelNome, nomeFantasia, labelNomeFantasia, cpfcnpj, labelCPFCNPJ, 
                                  rgie, labelRGIE, email, labelEmail, nomeContato, labelNomeContato, 
                                  ddd, labelDDD, fone, labelFone, nomerua, labelEndereco, bairro, labelBairro, 
                                  cep, labelCEP);
        
        Platform.runLater(() -> {
            setLabelColor(labelNome); setLabelColor(labelTipoEntidade); setLabelColor(labelSexo); setLabelColor(labelTipoCliente);
            setLabelColor(labelDtNasc); setLabelColor(labelEmail); setLabelColor(labelCPFCNPJ); setLabelColor(labelRGIE);
            setLabelColor(labelTipoContato); setLabelColor(labelNomeContato); setLabelColor(labelDDD); setLabelColor(labelFone);
            setLabelColor(labelEndereco); setLabelColor(labelLogradouro); setLabelColor(labelTipoEnd); setLabelColor(labelBairro);
            setLabelColor(labelPais); setLabelColor(labelEstado); setLabelColor(labelCidade); setComboBoxColor(pais); setComboBoxColor(estado);
            setComboBoxColor(cidade); setComboBoxColor(logradouro); setComboBoxColor(tipoCliente); setComboBoxColor(tipoContato);
            setComboBoxColor(tipoEndereco); setComboBoxColor(tipoSexo);
        });
        
        cpfcnpj.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    ENT.handleFocusLostCPFCNPJ(null, cpfcnpj, tipoCliente);
                }
            }
        });
        rgie.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    ENT.handleFocusLostRGIE(null, rgie, tipoCliente);
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
        SEXO = SEX.varificaSexo(tipoSexo, SEX);
        Date dateNASC = ENT.verificaData(dataNASC);
        ENTIDADE = new TbEntidade(cpfcnpj.getText(), nome.getText(), nomeFantasia.getText(), rgie.getText(), email.getText(),
                tipoCliente.getValue(), dateNASC, SEXO);
        
        int i = 0;
        for (FoneModel fones : telefones) {
            TIPOTELEFONE = TTEL.listaUm("ttDescricao", fones.getTipoContato(), TbTipoTelefone.class);
            TELEFONE = new TbTelefone(fones.getDdd() + fones.getFone(), TIPOTELEFONE);
            
            t[i] = new TbEntidadeHasTelefone(TELEFONE, ENTIDADE);
            i++;
        }
        System.out.println(TELEFONE);
        

        i = 0;
        for (EnderecoModel endereco : enderecos) {
            BAIRRO = new TbBairro(endereco.getBairro());

            LOGRADOURO = new TbLogradouro(endereco.getLogradouro());

            CidadeRN cid = new CidadeRN();
            String jpql = "SELECT t.tbCidade FROM TbCidEstPai t WHERE "
                    + "t.tbEstado.estSigla = '" + endereco.getEstado() + "' "
                    + "AND t.tbCidade.cidDescricao = '" + endereco.getCidade() + "'";
            TbCidade new_cid = (TbCidade) cid.pesquisar(jpql).get(0);

            CEPS = (TbCidEstPai) CEP.pesquisar("SELECT t FROM TbCidEstPai t "
                    + "WHERE t.tbEstado.estSigla = '" + endereco.getEstado() + "' AND t.tbCidade.cidId = '"
                    + new_cid.getCidId() + "'").get(0);

            ENDPOSTAL = new TbEndPostal(endereco.getNomerua(), endereco.getCep(), LOGRADOURO, BAIRRO, CEPS);

            
            TIPOENDERECO = TEND.listaUm("teDescricao", endereco.getTipoEndereco(), TbTipoEndereco.class);

            TbEndereco ende = new TbEndereco(Integer.parseInt(endereco.getNumero()), endereco.getComplemento(), ENDPOSTAL, TIPOENDERECO);

            e[i] = new TbEntidadeHasEndereco(ENTIDADE, ende);

            i++;
            this.endPrincipal = ende;

        }

        ENTIDADE.setEntEnderecoPrincipal(endPrincipal);
        
        if (tipoEntidade1.isSelected()) {
            if(!verificaCamposA() && "Juridico".equals(tipoCliente)){
                CLIENTE = new TbCliente(ENTIDADE);
                ClienteRN cliente = new ClienteRN();
                cliente.salvar(CLIENTE);
                JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                dialogStage.close();
            } else if(!verificaCamposB() && "Físico".equals(tipoCliente)) {
                CLIENTE = new TbCliente(ENTIDADE);
                ClienteRN cliente = new ClienteRN();
                cliente.salvar(CLIENTE);
                JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                dialogStage.close();
            } else {
                DisplayDialogScreen.getInstance().displayErrorScreen("Finalizar Cadastro", "Alguns campos vazios!", "Preencha todos os "
                    + "campos referente a dados pessoais e verifique se "
                    + "não está faltando nenhum dado nas tabelas de endereço e telefone.");
            }
        }
        if (tipoEntidade2.isSelected()) {
            if(!verificaCamposA() && "Juridico".equals(tipoCliente)){
                FORNECEDOR = new TbFornecedor(ENTIDADE);
                FornecedorRN forne = new FornecedorRN();
                forne.salvar(FORNECEDOR);
                JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                dialogStage.close();
            } else if(!verificaCamposB() && "Físico".equals(tipoCliente)) {
                FORNECEDOR = new TbFornecedor(ENTIDADE);
                FornecedorRN forne = new FornecedorRN();
                forne.salvar(FORNECEDOR);
                JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                dialogStage.close();
            } else {
                DisplayDialogScreen.getInstance().displayErrorScreen("Finalizar Cadastro", "Alguns campos vazios!", "Preencha todos os "
                    + "campos referente a dados pessoais e verifique se "
                    + "não está faltando nenhum dado nas tabelas de endereço e telefone.");
            }
        }

        ClienteRN cli = new ClienteRN();
        FornecedorRN fore = new FornecedorRN();
        TbCliente clientes = null;
        TbFornecedor fornecedores = null;

        if (CLIENTE != null) {
            clientes = (TbCliente) cli.listaUm("clicpfCnpj", CLIENTE.getClicpfCnpj().getEntcpfCnpj(), TbCliente.class);
        }

        if (FORNECEDOR != null) {
            fornecedores = (TbFornecedor) fore.listaUm("forcpfCnpj", FORNECEDOR.getForcpfCnpj().getEntcpfCnpj(), TbFornecedor.class);
        }

        if (clientes == CLIENTE || fornecedores == FORNECEDOR) {
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
        }
        
//        } else {
//            DisplayDialogScreen.getInstance().displayErrorScreen("Finalizar Cadastro", "Alguns campos vazios!", "Preencha todos os "
//                    + "campos referente a dados pessoais e verifique se "
//                    + "não está faltando nenhum dado nas tabelas de endereço e telefone.");
//        }
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
        TIPOTELEFONE = new TbTipoTelefone(tipoContato.getValue());
        TELEFONE = new TbTelefone(ddd.getText() + fone.getText(), TIPOTELEFONE);
        System.out.println(TELEFONE.getFoneDescricao());
        System.out.println(TIPOTELEFONE.getTtDescricao());
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
    boolean verificaCamposA() {
        boolean camposValidos = true;
        ArrayList<String> campos = ENT.validarEntidadeJuridico(ENTIDADE);
        camposValidos = !campos.isEmpty();
//            for (String campo : campos){
//                System.out.println(campo + "\n");
//            }
        return camposValidos;
    }
    boolean verificaCamposB() {
        boolean camposValidos = true;
        ArrayList<String> campos = ENT.validarEntidadeFisico(ENTIDADE);
        camposValidos = !campos.isEmpty();
//            for (String campo : campos){
//                System.out.println(campo + "\n");
//            }
        return camposValidos;
    }
    boolean verificaCampos() {
        boolean camposValidos = true;
        if (ENT.validarNome(nome)){ labelNome.setTextFill(RED); nome.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarCPFCNPJ(cpfcnpj, tipoCliente)) { labelCPFCNPJ.setTextFill(RED); cpfcnpj.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarRGIE(rgie)) { labelRGIE.setTextFill(RED); rgie.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarNomeFantasia(nomeFantasia)) { labelNomeFantasia.setTextFill(RED); nomeFantasia.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarCampoData(dataNASC)) { labelDtNasc.setTextFill(RED); dataNASC.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (ENT.validarCampoCheck(tipoEntidade1, tipoEntidade2)){ labelTipoEntidade.setTextFill(RED); tipoEntidade1.setTextFill(RED); tipoEntidade2.setTextFill(RED); camposValidos = false;}
        if (ENT.validarCampoTipoCliente(tipoCliente)){ labelTipoCliente.setTextFill(RED); tipoCliente.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (ENT.validarEmail(email)){ labelEmail.setTextFill(RED); email.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        if (SEX.validarCampo(tipoSexo)) { labelSexo.setTextFill(RED); tipoSexo.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        return camposValidos;
    }
    void setLabelColor(Label label) {
        label.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // Focado
                label.setStyle("-fx-text-fill: black;"); 
            } 
        });
    }
    void setComboBoxColor(ComboBox<String> box) {
        box.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // Focado
                box.setStyle("-fx-border-color: transparent;");
            } 
        });
    }
    boolean verificaCamposTableFone() {
        boolean camposValidos = true;
        ArrayList<String> campos = TEL.validarTelefone(TELEFONE);
        ArrayList<String> campoTipoTelefone = TTEL.validarTipoTelefone(TIPOTELEFONE);
        
        camposValidos = !campos.isEmpty() && !campoTipoTelefone.isEmpty();

        campos.addAll(campoTipoTelefone);
//        if (TTEL.validarCampoTipoContato(tipoContato)) { labelTipoContato.setTextFill(RED); tipoContato.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (TTEL.validarCampoNomeContato(nomeContato)) { labelNomeContato.setTextFill(RED); nomeContato.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (TEL.validarCampoDDD(ddd)) { labelDDD.setTextFill(RED); ddd.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (TEL.validarCampoFone(fone)) { labelFone.setTextFill(RED); fone.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        return camposValidos;
    }
    
    boolean verificaCamposTableEndereco() {
        boolean camposValidos = true;
        ArrayList<String> campos = END.validarEnderecoPostal(ENDPOSTAL);
        ArrayList<String> campoLogradouro = LOG.validarLogradouro(LOGRADOURO);
        ArrayList<String> campoTipoEndereco = TEND.validarTipoEndereco(TIPOENDERECO);
        ArrayList<String> campoBairro = BAI.validarBairro(BAIRRO);
        ArrayList<String> campoCidEstPai = CEP.validarPaisEstadoCidade(CEPS);
        
        camposValidos = !campos.isEmpty();
        camposValidos = !campoLogradouro.isEmpty();
        camposValidos = !campoTipoEndereco.isEmpty();
        camposValidos = !campoBairro.isEmpty();
        camposValidos = !campoCidEstPai.isEmpty();
        
        campos.addAll(campoLogradouro);
        campos.addAll(campoTipoEndereco);
        campos.addAll(campoBairro);
        campos.addAll(campoCidEstPai);
//        if (BAI.validarCampo(bairro)) { labelBairro.setTextFill(RED); bairro.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (LOG.validarCampo(logradouro)) { labelLogradouro.setTextFill(RED); logradouro.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (TEND.validarCampo(tipoEndereco)) { labelTipoEnd.setTextFill(RED); tipoEndereco.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (END.validarCampoCEP(cep)) { labelCEP.setTextFill(RED); cep.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (END.validarCampoNomeRua(nomerua)) { labelEndereco.setTextFill(RED); nomerua.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (CEP.validarCampoPais(pais)) { labelPais.setTextFill(RED); pais.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (CEP.validarCampoEstado(estado)) { labelEstado.setTextFill(RED); estado.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
//        if (CEP.validarCampoCidade(cidade)) { labelCidade.setTextFill(RED); cidade.setStyle("-fx-border-color: #FF9999;"); camposValidos = false;}
        return camposValidos;
    }
    boolean verificaTabela(TableView tableView) {
        if (tableView.getItems().isEmpty()) {
            tableView.setStyle("-fx-border-color: #FF9999;");
            return false;
        } else {
            return true;
        }
    }
}
