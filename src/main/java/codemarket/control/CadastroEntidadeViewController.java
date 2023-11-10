package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.*;
import codemarket.model.vo.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

public class CadastroEntidadeViewController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private CheckBox tipoEntidade1;
    @FXML
    private CheckBox tipoEntidade2;
    @FXML
    private TextField observacao;
    @FXML
    private ComboBox<String> cidade;
    @FXML
    private RadioButton estrangeiro;
    @FXML
    private ComboBox<String> estado;
    @FXML
    private TextField numero;
    @FXML
    private ComboBox<String> tipoSexo;
    @FXML
    private TextField cpfcnpj;
    @FXML
    private TextField rgie;
    @FXML
    private TextField cep;
    @FXML
    private TextField nomeFantasia;
    @FXML
    private TextField complemento;
    @FXML
    private ComboBox<String> tipoContato;
    @FXML
    private TextField nomeContato;
    @FXML
    private Label labelCPFCNPJ;
    @FXML
    private Label labelRGIE;
    @FXML
    private TextField email;
    @FXML
    private TextField codigo;
    @FXML
    private TextField ddd;
    @FXML
    private RadioButton brasileiro;
    @FXML
    private TextField bairro;
    @FXML
    private TextField nome;
    @FXML
    private ComboBox<String> pais;
    @FXML
    private TextField fone;
    @FXML
    private ComboBox<String> tipoCliente;
    @FXML
    private DatePicker dataNASC;
    @FXML
    private TextField nomerua;
    @FXML
    private ComboBox<String> tipoEndereco;
    @FXML
    private ComboBox<String> logradouro;
    @FXML
    private Button buttonFinalizar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonEndSalvar;
    @FXML
    private Button buttonFoneSalvar;
    @FXML
    private Button buttonAlterarFone;
    @FXML
    private Button buttonAlterarEnd;
    @FXML
    private Button buttonCancelarEnd;
    @FXML
    private Button buttonCancelarFone;
    @FXML
    private TableView<EnderecoModel> tableEnd;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndtipo;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndcidade;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndest;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndpais;
    @FXML
    private TableColumn<EnderecoModel, String> tbEndcep;

    @FXML
    private TableView<FoneModel> tableFone;
    @FXML
    private TableColumn<FoneModel, String> tbFoneddd;
    @FXML
    private TableColumn<FoneModel, String> tbFonetipo;
    @FXML
    private TableColumn<FoneModel, String> tbFonefone;
    @FXML
    private TableColumn<FoneModel, String> tbFonenome;

    private ToggleGroup nacionalidade;
    private ToggleGroup seleEntidade;

    private ObservableList<FoneModel> telefones = FXCollections.observableArrayList();
    private ObservableList<EnderecoModel> enderecos = FXCollections.observableArrayList();
    private TbEndereco endPrincipal;
    private TbEntidadeHasEndereco e[] = new TbEntidadeHasEndereco[10];
    private TbEntidadeHasTelefone t[] = new TbEntidadeHasTelefone[10];
    private TbCliente CLIENTE = null;
    private TbFornecedor FORNECEDOR = null;

    private Stage dialogStage;

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTituloJanela(String titulo) {
        this.tituloJanela.setText(titulo);
    }

    EntidadeRN ENT = new EntidadeRN();
    // Evento que fica verificando o tipo de cliente
    @FXML
    void onTipoClienteChanged(ActionEvent event){
        ENT.onTipoClienteChanged(event, tipoCliente, cpfcnpj, rgie, labelCPFCNPJ, labelRGIE, tipoSexo, dataNASC);
    }
    // Evento que verifica a entrada do teclado para a formatação e aceitação de só numéro para CPF / CNPJ
    @FXML
    void validarCPFCNPJ(KeyEvent event){
        ENT.validarCPFCNPJ(event, cpfcnpj, tipoCliente);
    }
    // Evento que verifica a entrada do teclado para o RG, só aceita numero 
    @FXML
    void validarRGIE(KeyEvent event) {
        ENT.validarRGIE(event, rgie);
    }
    
    // Evento para verificar só a entrada de numeros e formata para DDD
    @FXML
    void validarDDD(KeyEvent event) {
        ENT.validarDDD(event, ddd);
    }

    // Evento para verificar só a entrada de numeros e formata para Telefone
    @FXML
    void validarFONE(KeyEvent event) {
        ENT.validarFONE(event, fone);
    }

    // Evento para verificar só a entrada de numeros
    @FXML
    void validarNUM(KeyEvent event) {
        ENT.validarNUM(event, numero);
    }

    // Evento para verificar só a entrada de numeros e formata para CEP
    @FXML
    void validarCEP(KeyEvent event) {
        ENT.validarCEP(event, cep);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        /* ------------------------------------------------------------------ */

        /* ----------------- Combo Box - Tipo de Sexo ----------------------- */
        // Adicionando dados do Tipo de Sexo
        SexoRN sexo = new SexoRN();
        ArrayList tiposSexo = (ArrayList) sexo.buscarTodos("sexDescricao");
        ObservableList<String> TS = FXCollections.observableArrayList(tiposSexo);
        tipoSexo.setItems(TS);

        /* ------------------------------------------------------------------ */
        /* ----------------- Combo Box - Tipo de Endereço ------------------- */
        // Adicionando dados do Tipo de Sexo
        ObservableList<String> der = FXCollections.observableArrayList(
                "Residencial",
                "Outro"
        );
        tipoEndereco.setItems(der);
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

    }

    @FXML
    void handleFinalizarButton() {

        SexoRN sexorn = new SexoRN();
        TbSexo sexo = sexorn.listaUm("sexDescricao", tipoSexo.getValue(), TbSexo.class);
        

        LocalDate dtNASC = dataNASC.getValue();  // Obter a data do DatePicker
        Date dateNASC = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());

        TbEntidade ENTIDADE = new TbEntidade(cpfcnpj.getText(), nome.getText(), nomeFantasia.getText(), rgie.getText(), email.getText(),
                tipoCliente.getValue(), dateNASC, sexo);

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

        if (tipoEntidade1.isSelected()) {
            CLIENTE = new TbCliente(ENTIDADE);
            ClienteRN cliente = new ClienteRN();
            cliente.salvar(CLIENTE);
        }
        if (tipoEntidade2.isSelected()) {
            FORNECEDOR = new TbFornecedor(ENTIDADE);
            FornecedorRN forne = new FornecedorRN();
            forne.salvar(FORNECEDOR);
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
    }

    @FXML
    void handleCancelarbutton() {
        dialogStage.close();
    }

    @FXML
    void handleSalvarFonebutton() {
        FoneModel novoFone = new FoneModel(nomeContato.getText(), ddd.getText(), fone.getText(), tipoContato.getValue());
        telefones.add(novoFone);

        nomeContato.clear();
        ddd.clear();
        fone.clear();
        tipoContato.setValue("Selecione...");
    }

    @FXML
    void handleSalvarEndbutton() {
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
}
