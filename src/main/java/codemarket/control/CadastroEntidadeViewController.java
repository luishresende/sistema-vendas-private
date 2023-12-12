package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.*;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.utils.ImageManipulation;
import codemarket.model.vo.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CadastroEntidadeViewController implements Initializable {

    @FXML
    private Label labelNome, labelTipoEntidade, labelNomeFantasia, labelSexo, labelTipoCliente, labelDtNasc,
            labelEmail, labelTipoContato, labelNomeContato, labelDDD, labelFone, labelEndereco, labelLogradouro,
            labelTipoEnd, labelBairro, labelCEP, labelPais, labelEstado, labelCidade, labelCPFCNPJ, labelRGIE, tituloJanela;
    @FXML
    private CheckBox tipoCliente, tipoFornecedor;
    @FXML
    private ComboBox<String> cidade, tipoContato, tipoPessoa, tipoEndereco, logradouro, estado, tipoSexo, pais;
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
    private TbCliente clienteParaEditar;
    private TbFornecedor fornecedorParaEditar;
    private TbEntidade enti;
    private boolean editar = false;

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
        this.tipoCliente.setSelected(True);
    }

    public void setTipoEntidade2(boolean True) {
        this.tipoFornecedor.setSelected(True);
    }

    // Evento que fica verificando o tipo de cliente
    @FXML
    void onTipoClienteChanged(ActionEvent event) {
        ENT.onTipoClienteChanged(event, tipoPessoa, cpfcnpj, rgie, labelCPFCNPJ, labelRGIE, tipoSexo, dataNASC);
    }

    // Evento que verifica a entrada do teclado para a formatação e aceitação de só numéro para CPF / CNPJ
    @FXML
    void validarCPFCNPJ(KeyEvent event) {
        ENT.validaCPFCNPJ(event, cpfcnpj, tipoPessoa);
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
        tipoPessoa.setItems(tipo);
        tipoPessoa.setValue("Físico");
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
        
        cpfcnpj.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    ENT.handleFocusLostCPFCNPJ(null, cpfcnpj, tipoPessoa);
                }
            }
        });
        rgie.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) { // Se o foco foi perdido
                    ENT.handleFocusLostRGIE(null, rgie, tipoPessoa);
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
            TbSexo sexo = null;
            if (tipoSexo.getValue().isEmpty() == false) {
                sexo = SEX.listaUm("sexDescricao", tipoSexo.getValue(), TbSexo.class);
            }

            Date dateNASC = null;
            if(tipoPessoa.getValue() == "Físico"){
                LocalDate dtNASC = dataNASC.getValue();
                dateNASC = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());
            }

            TbEntidade ENTIDADE = new TbEntidade(cpfcnpj.getText(), nome.getText(), nomeFantasia.getText(), 
                                                rgie.getText(), email.getText(), tipoPessoa.getValue(), dateNASC, sexo);
            

            int i = 0;
            for (FoneModel fones : telefones) {
                TelefoneTipoRN tipoTRN = new TelefoneTipoRN();
                TbTipoTelefone tipo = tipoTRN.listaUm("ttDescricao", fones.getTipoContato(), TbTipoTelefone.class);

                if(fones.getHas() == null){
                    TbTelefone tell = new TbTelefone(fones.getDdd() + fones.getFone(), tipo, fones.getNomeContato());
                    
                    TbEntidadeHasTelefone tel = null;
                    if(editar){
                        tel = new TbEntidadeHasTelefone(tell, enti);
                    }else{
                        tel = new TbEntidadeHasTelefone(tell, ENTIDADE);
                    }
                    t[i] = tel;            
                    i++;
                }else{
                   TbTelefone f = fones.getHas();
                   f.setFoneDescricao(fones.getDdd() + fones.getFone());
                   f.setFonenomeContato(fones.getNomeContato());
                   f.setFoneTipo(tipo);

                   TelefoneRN trn = new TelefoneRN();
                   trn.atualizar(f);                   
                }

            }
            
            for (EnderecoModel endereco : enderecos){
                if(endereco.getHas() == null){
                    i = 0;
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

                    TbEntidadeHasEndereco new_endereco = null;
                    if(editar){
                        new_endereco = new TbEntidadeHasEndereco(enti, ende);
                    }else{
                        new_endereco = new TbEntidadeHasEndereco(ENTIDADE, ende);
                    }
                    e[i] = new_endereco;
                    i++;
                    this.endPrincipal = ende;   
                }else{
                        
                    TbEndereco end = endereco.getHas();
                    end.setEndComplemento(endereco.getComplemento());
                    end.setEndNumero(Integer.parseInt(endereco.getNumero()));

                    TipoEnderecoRN trn = new TipoEnderecoRN();
                    TbTipoEndereco tip = trn.listaUm("teDescricao", endereco.getTipoEndereco(), TbTipoEndereco.class);
                    end.setEndTipo(tip);

                    TbEndPostal endP = end.getEndendPid();
                    endP.setEndPnomerua(endereco.getNomerua());
                    endP.setEndCEP(endereco.getCep());

                    CidadeRN cid = new CidadeRN();
                    String jpql = "SELECT t.tbCidade FROM TbCidEstPai t WHERE "
                            + "t.tbEstado.estSigla = '" + endereco.getEstado() + "' "
                            + "AND t.tbCidade.cidDescricao = '" + endereco.getCidade() + "'";
                    TbCidade new_cid = (TbCidade) cid.pesquisar(jpql).get(0);

                    CidEstPaiRN cep = new CidEstPaiRN();
                    TbCidEstPai ceps = (TbCidEstPai) cep.pesquisar("SELECT t FROM TbCidEstPai t "
                            + "WHERE t.tbEstado.estSigla = '" + endereco.getEstado() + "' AND t.tbCidade.cidId = '"
                            + new_cid.getCidId() + "'").get(0);

                    endP.setTbCidEstPai(ceps);

                    TbLogradouro lou = endP.getEndPlogid();
                    lou.setLogDescricao(endereco.getLogradouro());

                    TbBairro bai = endP.getEndPbaiid();
                    bai.setBaiDescricao(endereco.getBairro());

                    EnderecoRN endrn = new EnderecoRN();
                    endrn.atualizar(end);
                }
            }
            if(editar){
                
                enti.setEntEmail(email.getText());
                enti.setEntNome(nome.getText());
                enti.setEntnomeFantasia(nomeFantasia.getText());
                enti.setEntSexo(sexo);
                enti.setEntdtNasc(dateNASC);
                enti.setEntcpfCnpj(cpfcnpj.getText());
                enti.setEntrgIe(rgie.getText());
                                
                if(fornecedorParaEditar != null){
                    FornecedorRN foreee = new FornecedorRN();
                    fornecedorParaEditar.setForcpfCnpj(enti);
                    foreee.atualizar(fornecedorParaEditar);

                }else{
                    ClienteRN cliee = new ClienteRN();
                    clienteParaEditar.setClicpfCnpj(enti);
                    cliee.atualizar(clienteParaEditar);
                }
                
                EntidadeHasTelefoneRN eht = new EntidadeHasTelefoneRN();
                for(TbEntidadeHasTelefone tel : t){
                    if(tel == null){
                        break;
                    }
                    eht.salvar(tel);
                }
                EntidadeHasEnderecoRN ehe = new EntidadeHasEnderecoRN();
                for(TbEntidadeHasEndereco end : e){
                    if(end == null){
                        break;
                    }
                    ehe.salvar(end);
                }
                JOptionPane.showMessageDialog(null, "Edição concluido com sucesso!");
                
                dialogStage.close();
             
            }else{
                
                ENTIDADE.setEntEnderecoPrincipal(endPrincipal);
                if (tipoCliente.isSelected()) {
                if("Juridico".equals(tipoPessoa.getValue())){
                    CLIENTE = new TbCliente(ENTIDADE);
                    ClienteRN cliente = new ClienteRN();
                    cliente.salvar(CLIENTE);
                    JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                    dialogStage.close();
                } else if("Físico".equals(tipoPessoa.getValue())) {
                    CLIENTE = new TbCliente(ENTIDADE);
                    ClienteRN cliente = new ClienteRN();
                    cliente.salvar(CLIENTE);
                    JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                    dialogStage.close();
                } else {
                    DisplayDialogScreen.getInstance().displayErrorScreen("Tipo Cliente", "Físico / Jurídico *", "Selecione uma opção de cliente.");
                }
            }
                
            if (tipoFornecedor.isSelected()) {
                if("Jurídico".equals(tipoPessoa.getValue())){
                    FORNECEDOR = new TbFornecedor(ENTIDADE);
                    FornecedorRN forne = new FornecedorRN();
                    forne.salvar(FORNECEDOR);
                    JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                    dialogStage.close();
                } else if("Físico".equals(tipoPessoa.getValue())) {
                    FORNECEDOR = new TbFornecedor(ENTIDADE);
                    FornecedorRN forne = new FornecedorRN();
                    forne.salvar(FORNECEDOR);
                    JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
                    dialogStage.close();
                } else {
                    DisplayDialogScreen.getInstance().displayErrorScreen("Tipo Fornecedor", "Físico / Jurídico *", "Selecione uma opção de cliente.");
                }
            }
            
                EntidadeHasTelefoneRN eht = new EntidadeHasTelefoneRN();
                for(TbEntidadeHasTelefone tel : t){
                    if(tel == null){
                        break;
                        
                    }
                    eht.salvar(tel);
                }
                EntidadeHasEnderecoRN ehe = new EntidadeHasEnderecoRN();
                for(TbEntidadeHasEndereco end : e){
                    if(end == null){
                        break;
                    }
                    ehe.salvar(end);
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
            FoneModel novoFone = new FoneModel(nomeContato.getText(), ddd.getText(), fone.getText(), tipoContato.getValue(), null);
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
        TELEFONE = new TbTelefone(ddd.getText() + fone.getText(), TIPOTELEFONE, null);
        if(verificaCamposTableEndereco()){
            EnderecoModel novoEndereco = new EnderecoModel(tipoEndereco.getValue(), cep.getText(),
                    cidade.getValue(), estado.getValue(),
                    pais.getValue(), nomerua.getText(),
                    bairro.getText(), complemento.getText(), numero.getText(), logradouro.getValue(), null);
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
             
            if(selectedEndereco.getHas() != null){
                EntidadeHasEnderecoRN ehe = new EntidadeHasEnderecoRN();
                TbEntidadeHasEndereco remove_end = (TbEntidadeHasEndereco) ehe.pesquisar("SELECT t FROM TbEntidadeHasEndereco"
                                                                                          + " t where t.eeentcpfCnpj = '" + enti.getEntcpfCnpj() + 
                                                                                          "' and t.eeEndId = '" + selectedEndereco.getHas().getEndId() + "'").get(0);
                ehe.excluir(remove_end);   
            }
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
            
            if(selectedFone.getHas() != null){
                EntidadeHasTelefoneRN ehe = new EntidadeHasTelefoneRN();
                TbEntidadeHasTelefone remove_tel = (TbEntidadeHasTelefone) ehe.pesquisar("SELECT t FROM TbEntidadeHasTelefone"
                                                                                          + " t where t.ehtentcpfCnpj = '" + enti.getEntcpfCnpj() + 
                                                                                          "' and t.ehtFoneId = '" + selectedFone.getHas().getFoneId()+ "'").get(0);
                EntidadeRN adminrn = new EntidadeRN();
                TbEntidade admin = adminrn.listaUm("entcpfCnpj", "000.000.000-00", TbEntidade.class);
                remove_tel.setEhtentcpfCnpj(admin);
                ehe.atualizar(remove_tel);   
            }
        }
    }

    @FXML
    void handlerCancelarFone() {
        FoneModel selectedFone = tableFone.getSelectionModel().getSelectedItem();
        if(selectedFone != null){
            telefones.remove(selectedFone);

            if(selectedFone.getHas() != null){
                    EntidadeHasTelefoneRN ehe = new EntidadeHasTelefoneRN();
                    TbEntidadeHasTelefone remove_tel = (TbEntidadeHasTelefone) ehe.pesquisar("SELECT t FROM TbEntidadeHasTelefone"
                                                                                              + " t where t.ehtentcpfCnpj = '" + enti.getEntcpfCnpj() + 
                                                                                              "' and t.ehtFoneId = '" + selectedFone.getHas().getFoneId()+ "'").get(0);
                    EntidadeRN adminrn = new EntidadeRN();
                    TbEntidade admin = adminrn.listaUm("entcpfCnpj", "000.000.000-00", TbEntidade.class);
                    remove_tel.setEhtentcpfCnpj(admin);
                    ehe.atualizar(remove_tel);   
                }            
        }
    }

    @FXML
    void handlerCancelarEnd() {
        EnderecoModel selectedEndereco = tableEnd.getSelectionModel().getSelectedItem();
        enderecos.remove(selectedEndereco);
        
        if(selectedEndereco.getHas() != null){
                EntidadeHasEnderecoRN ehe = new EntidadeHasEnderecoRN();
                TbEntidadeHasEndereco remove_end = (TbEntidadeHasEndereco) ehe.pesquisar("SELECT t FROM TbEntidadeHasEndereco"
                                                                                          + " t where t.eeentcpfCnpj = '" + enti.getEntcpfCnpj() + 
                                                                                          "' and t.eeEndId = '" + selectedEndereco.getHas().getEndId() + "'").get(0);
                ehe.excluir(remove_end);   
            }
    }
    
    boolean verificaCampos() {
        boolean camposValidos = true;
        if (ENT.validarNome(nome)){ camposValidos = false;}
        if (ENT.campoCPFCNPJ(cpfcnpj)) { camposValidos = false;}
        if (ENT.validarRGIE(rgie)) { camposValidos = false;}
        if (ENT.validarNomeFantasia(nomeFantasia)) { camposValidos = false;}
        if (!dataNASC.isDisable()){
        if (ENT.validarCampoData(dataNASC)) { camposValidos = false;}}
        if (ENT.validarCampoCheck(tipoCliente, tipoFornecedor)){ camposValidos = false;}
        if (ENT.validarCampoTipoCliente(tipoPessoa)){ camposValidos = false;}
        if (ENT.validarEmail(email)){ camposValidos = false;}
        if (!tipoSexo.isDisable()){
        if (SEX.validarCampo(tipoSexo)) { camposValidos = false;}}
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
    
    public void editarClienteFornecedor(TbCliente clienteParaEditar, TbFornecedor fornecedorParaEditar){
        if(fornecedorParaEditar != null){
            this.fornecedorParaEditar = fornecedorParaEditar;
            this.enti = fornecedorParaEditar.getForcpfCnpj();
            tipoFornecedor.setSelected(true);
            
        }else{
            this.clienteParaEditar = clienteParaEditar;
            this.enti = clienteParaEditar.getClicpfCnpj();
            tipoCliente.setSelected(true);
        }
        tipoFornecedor.setDisable(true);
        tipoCliente.setDisable(true);
        editar = true;
        nome.setText(enti.getEntNome());
        nomeFantasia.setText(enti.getEntnomeFantasia());
        cpfcnpj.setText(enti.getEntcpfCnpj());
        rgie.setText(enti.getEntrgIe());
        email.setText(enti.getEntEmail());
        
        
        java.util.Date utilDate = enti.getEntdtNasc(); 
        if (utilDate != null) {
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            LocalDate aniv = sqlDate.toLocalDate();
            dataNASC.setValue(aniv);
        } else {
            dataNASC.setValue(null); 
        }

        if (enti.getEntSexo() != null) {
            tipoSexo.setValue(enti.getEntSexo().getSexDescricao());
        }
        
        List<EnderecoModel> enderecos = new ArrayList<>();
        List<FoneModel> telefones = new ArrayList<>();

        try {
            List<TbEndereco> enderecosList = enti.getTbEnderecoList();
            for (TbEndereco endereco : enderecosList) {
                try {
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
                        endereco.getEndendPid().getEndPlogid().getLogDescricao(),
                        endereco
                    );
                    enderecos.add(enderecoModel);
                } catch (Exception e) {}
            }

            List<TbTelefone> telefonesList = enti.getTbTelefoneList();
            for (TbTelefone entidadeHasTelefone : telefonesList) {
                try {
                    TbTelefone telefone = entidadeHasTelefone;
                    String contado = telefone.getFoneDescricao();
                    String dd = contado.substring(0, Math.min(contado.length(), 4));
                    String resto = contado.substring(Math.min(contado.length(), 4));

                    FoneModel foneModel = new FoneModel(
                        telefone.getFonenomeContato(),
                    dd,
                    resto,
                    telefone.getFoneTipo().getTtDescricao(),
                    telefone
                );
                telefones.add(foneModel);
            } catch (Exception e) {}
        }
    } catch (Exception e) {}

    }
}
