package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.*;
import codemarket.model.vo.*;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javax.swing.text.NumberFormatter;

public class CadastroFuncionarioViewController implements Initializable {

    @FXML
    private Label tituloJanela;
    @FXML
    private ImageView img;
    @FXML
    private Button imgButton;
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
    private TextField codigo;
    @FXML
    private TextField ddd;
    @FXML
    private TextField usuario;
    @FXML
    private TextField senha;
    @FXML
    private TextField confirmaSenha;
    @FXML
    private TextField cargo;
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

    @FXML
    private void validarCPF(KeyEvent event) {
        String texto = cpf.getText();
        if (!texto.matches("[0-9]*")) {
            // Só aceita valores numéricos
            cpf.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 11) {
            // Formatação para CPF "999.999.999-99"
            cpf.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
        }
    }

    @FXML
    private void validarDDD(KeyEvent event) {
        String texto = ddd.getText();
        if (!texto.matches("[0-9]*")) {
            ddd.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 2) {
            // Formatação para "(DD)"
            ddd.setText("(" + texto + ")");
        }
    }

    @FXML
    private void validarFONE(KeyEvent event) {
        String texto = fone.getText();
        if (!texto.matches("[0-9]*")) {
            fone.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 9) {
            // Formatação para "(DD)"
            fone.setText(texto.substring(0, 1) + " " + texto.substring(1, 5) + "-" + texto.substring(5, 9));
        }
        if (texto.length() >= 9) {
            event.consume(); // Impede que mais de 2 caracteres sejam inseridos
        }
    }

    @FXML
    private void validarNUM(KeyEvent event) {
        String texto = numero.getText();
        if (!texto.matches("[0-9]*")) {
            numero.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    @FXML
    private void validarCEP(KeyEvent event) {
        String texto = cep.getText();
        if (!texto.matches("[0-9]*")) {
            cep.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 8) {
            cep.setText(texto.substring(0, 5) + " - " + texto.substring(5, 8));
        }
    }
    
    @FXML
    private void validarRG(KeyEvent event) {
        String texto = rg.getText();
        if (!texto.matches("[0-9]*")) {
            rg.setText(texto.replaceAll("[^0-9]", ""));
        }
    }
    
    @FXML
    private void validarSalario(KeyEvent event) {
        String texto = salario.getText();
        if (!texto.matches("[0-9]*")) {
            salario.setText(texto.replaceAll("[^0-9]", ""));
        }
        StringConverter<Number> converter = new NumberStringConverter("#,##0.00");
        TextFormatter<Number> textFormatter = new TextFormatter<>(converter, 0.0, change -> {
            String newText = change.getControlNewText();
            ParsePosition parsePosition = new ParsePosition(0);
            Number number = converter.fromString(newText);
            if (number != null) {
                return change;
            } else {
                return null;
            }
        });

        salario.setTextFormatter(textFormatter);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            // Abrir o diálogo de seleção de arquivo
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            
            if (selectedFile != null) {
                // Carregar a imagem selecionada
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
                brasileiro.setSelected(true); // Impede que o CheckBox seja desmarcado
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
    }    
    
    @FXML
    void handleFinalizarButton() {
        
        for (FoneModel fones : telefones) {
            TelefoneTipoRN tipoTRN = new TelefoneTipoRN();
            TbTipoTelefone t = new TbTipoTelefone(fones.getTipoContato());
            tipoTRN.salvar(t);

            TelefoneRN trn = new TelefoneRN();
            TbTelefone tell = new TbTelefone(fones.getDdd() + fones.getFone(), t);
            trn.salvar(tell);
        }

        for (EnderecoModel endereco : enderecos) {
            BairroRN bairroRn = new BairroRN();
            TbBairro b = new TbBairro(endereco.getBairro());
            bairroRn.salvar(b);

            LogradouroRN lourn = new LogradouroRN();
            TbLogradouro l = new TbLogradouro(endereco.getLogradouro());
            lourn.salvar(l);

            CidadeRN cid = new CidadeRN();
            String jpql = "SELECT t.tbCidade FROM TbCidEstPai t WHERE "
                    + "t.tbEstado.estSigla = '" + endereco.getEstado() + "' "
                    + "AND t.tbCidade.cidDescricao = '" + endereco.getCidade() + "'";
            TbCidade new_cid = (TbCidade) cid.pesquisar(jpql).get(0);
 
            CidEstPaiRN CEP = new CidEstPaiRN();
            TbCidEstPai ceps = (TbCidEstPai) CEP.pesquisar("SELECT t FROM TbCidEstPai t "
                    + "WHERE t.tbEstado.estSigla = '" + endereco.getEstado() + "' AND t.tbCidade.cidId = '"
                    + new_cid.getCidId() + "'").get(0);

            EndPostalRN postalRN = new EndPostalRN();
            TbEndPostal postal = new TbEndPostal(endereco.getNomerua(), endereco.getCep(), l, b, ceps);
            postalRN.salvar(postal);

            TipoEnderecoRN te = new TipoEnderecoRN();
            TbTipoEndereco tende = te.listaUm("teDescricao", endereco.getTipoEndereco(), TbTipoEndereco.class);

            EnderecoRN endRN = new EnderecoRN();
            TbEndereco ende = new TbEndereco(Integer.parseInt(endereco.getNumero()), endereco.getComplemento(), postal, tende);
            endRN.salvar(ende);

            this.endPrincipal = ende;
        }
        
        SexoRN sexorn = new SexoRN();
        TbSexo sexo = sexorn.listaUm("sexDescricao", tipoSexo.getValue(), TbSexo.class);

        LocalDate dtNASC = dataNASC.getValue();  // Obter a data do DatePicker
        Date dateNASC = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());

        TbEntidade ENTIDADE = new TbEntidade(cpf.getText(), nome.getText(), nomeFantasia.getText(), rg.getText(), email.getText(),
                null, dateNASC, sexo, endPrincipal);
        EntidadeRN ent = new EntidadeRN();
        ent.salvar(ENTIDADE);
        
        StatusRN staRN = new StatusRN();
        TbStatus staValor = staRN.listaUm("staDescricao", tipoStatus.getValue(), TbStatus.class);
        
        LocalDate dtValidade = validade.getValue();  // Obter a data do DatePicker
        Date dataValidade = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if(senha.getText() == null ? confirmaSenha.getText() == null : senha.getText().equals(confirmaSenha.getText())) {
            UsuarioRN usu = new UsuarioRN();
            TbUsuario Usuario = new TbUsuario(usuario.getText(), senha.getText(), dataValidade, staValor);
            usu.salvar(Usuario);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro");
            alert.setContentText("As senhas são diferentes!");

            alert.showAndWait();
        }
        
        CargoRN carRN = new CargoRN();
        TbCargo car = new TbCargo();
        FuncionarioRN funcRN = new FuncionarioRN();
//        sTbFuncionario funcionario = new TbFuncionario(ENTIDADE, Usuario, );
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
