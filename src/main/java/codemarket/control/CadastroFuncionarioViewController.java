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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class CadastroFuncionarioViewController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private ImageView img;
    @FXML
    private Button imgButton;
    @FXML
    private ComboBox<String> cidade;
    @FXML
    private ComboBox<String> estado;
    @FXML
    private TextField numero;
    @FXML
    private ComboBox<String> tipoSexo;
    @FXML
    private ComboBox<String> tipoStatus;
    @FXML
    private TextField cpf;
    @FXML
    private TextField rg;
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
    private TextField email;
    @FXML
    private TextField ddd;
    @FXML
    private TextField usuario;
    @FXML
    private TextField senha;
    @FXML
    private TextField confirmaSenha;
    @FXML
    private ComboBox<String> tipoCargo;
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
    private DatePicker dataNASC;
    @FXML
    private DatePicker validade;
    @FXML
    private TextField nomerua;
    @FXML
    private TextField salario;
    @FXML
    private ComboBox<String> logradouro;
    @FXML
    private ComboBox<String> tipoEndereco;
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
        ENT.validarDDD(event, ddd);
    }

    @FXML
    void validarFONE(KeyEvent event) {
        ENT.validarFONE(event, fone);
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
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg")
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
        
    }    
    
    @FXML
    void handleFinalizarButton() {
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
            USU.displayErrorScreen();
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
                cidade.getValue(), estado.getValue(), pais.getValue(), nomerua.getText(),
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