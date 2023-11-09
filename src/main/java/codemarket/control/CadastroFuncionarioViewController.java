package codemarket.control;

import codemarket.control.tableViewModel.EnderecoModel;
import codemarket.control.tableViewModel.FoneModel;
import codemarket.model.rn.CidadeRN;
import codemarket.model.rn.EstadoRN;
import codemarket.model.rn.PaisRN;
import codemarket.model.rn.SexoRN;
import codemarket.model.rn.TelefoneTipoRN;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private TextField logradouro;
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
    }    
    
    @FXML
    void handleFinalizarButton() {
        
        for (FoneModel fones : telefones) {

        }

        for (EnderecoModel endereco : enderecos) {

        }
        
        // Inserindo os dados na tabela entidade
//        String name = this.nome.getText();
//        String nomeFant = this.nomeFantasia.getText();
//        String sexoSele = this.tipoSexo.getValue(); 
//        String tipocliente = this.tipoCliente.getValue();
//        LocalDate dataNasc = this.dataNASC.getValue();
//        Date dataNascDate = Date.from(dataNasc.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        String Email = this.email.getText();
//        String doc = this.cpf.getText();
//        TbEntidade ENTIDADE = new TbEntidade(name, nomeFant, tipoEnd, est, telefone, Email, dataNascDate, est, ENDERECO, SEX);
//        EntidadeRN ent = new EntidadeRN();
//        ent.salvar(ENTIDADE);

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
//        EnderecoModel novoEndereco = new EnderecoModel(tipoEndereco.getValue(), cep.getText(),
//                cidade.getValue(), estado.getValue(),
//                pais.getValue(), logradouro.getText(),
//                bairro.getText(), complemento.getText(), numero.getText());
//        enderecos.add(novoEndereco);

        tipoEndereco.setValue("Selecione...");
        cep.clear();
        cidade.setValue("Selecione...");
        estado.setValue("Selecione...");
        pais.setValue("Selecione...");
        logradouro.clear();
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
            logradouro.setText(selectedEndereco.getLogradouro());
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
