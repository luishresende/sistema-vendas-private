package codemarket.control;

import codemarket.model.conexao.HibernateConnection;
import codemarket.model.rn.BairroRN;
import codemarket.model.rn.CidEstPaiRN;
import codemarket.model.rn.CidadeRN;
import codemarket.model.rn.ClienteRN;
import codemarket.model.rn.EndPostalRN;
import codemarket.model.rn.EnderecoRN;
import codemarket.model.rn.EntidadeRN;
import codemarket.model.rn.EstadoRN;
import codemarket.model.rn.LogradouroRN;
import codemarket.model.rn.PaisRN;
import codemarket.model.rn.SexoRN;
import codemarket.model.vo.TbBairro;
import codemarket.model.vo.TbCidEstPai;
import codemarket.model.vo.TbCidade;
import codemarket.model.vo.TbCliente;
import codemarket.model.vo.TbEndPostal;
import codemarket.model.vo.TbEndereco;
import codemarket.model.vo.TbEntidade;
import codemarket.model.vo.TbEstado;
import codemarket.model.vo.TbFornecedor;
import codemarket.model.vo.TbLogradouro;
import codemarket.model.vo.TbPais;
import codemarket.model.vo.TbSexo;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CadastroEntidadeViewController implements Initializable {
    EntityManager manager = HibernateConnection.getInstance();
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
    private Button buttonSalvar;
    @FXML
    private Button buttonCancelar;
    private ToggleGroup nacionalidade;
    private ToggleGroup seleEntidade;

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

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void ativarMover(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void moverJanela(MouseEvent event) {
        dialogStage.setX(event.getScreenX() - xOffset);
        dialogStage.setY(event.getScreenY() - yOffset);
    }

    // Função para limpara o campo e ativar e desativar campos de pessoa Fisica 
    @FXML
    void onTipoClienteChanged(ActionEvent event) {
        String tipoSelecionado = tipoCliente.getValue(); // Obtém o tipo selecionado na ComboBox
        if ("Jurídico".equals(tipoSelecionado)) {
            // Formatação para CNPJ
            labelCPFCNPJ.setText("CNPJ");
            tipoSexo.setDisable(true);
            dataNASC.setDisable(true);
        } else if ("Físico".equals(tipoSelecionado)) {
            // Formatação para CPF
            labelCPFCNPJ.setText("CPF");
            tipoSexo.setDisable(false);
            dataNASC.setDisable(false);
        } else {
            labelCPFCNPJ.setText("CPF / CNPJ");
            tipoSexo.setDisable(true);
            dataNASC.setDisable(true);
        }
        cpfcnpj.clear();
        tipoSexo.setValue("Selecione...");
    }

    // Só valida a entrada de valores numéricos e formata de acordo o tipo de cliente
    @FXML
    void validarCPFCNPJ(KeyEvent event) {
        String texto = cpfcnpj.getText();
        if (!texto.matches("[0-9]*")) {
            // Só aceita valores numéricos
            cpfcnpj.setText(texto.replaceAll("[^0-9]", ""));
        }
        String tipoSelecionado = tipoCliente.getValue(); // Obtém o tipo selecionado na ComboBox 
        if (texto.length() == 14 && "Jurídico".equals(tipoSelecionado)) {
            // Formatação para CNPJ "99.999/9999-99"
            cpfcnpj.setText(texto.substring(0, 2) + "." + texto.substring(2, 5) + "." + texto.substring(5, 8) + "/" + texto.substring(8, 12) + "-" + texto.substring(12));
        } else if (texto.length() == 11 && "Físico".equals(tipoSelecionado)) {
            // Formatação para CPF "999.999.999-99"
            cpfcnpj.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
        }
    }

    // DDD
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

    // Telefone
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

    // Numero
    @FXML
    private void validarNUM(KeyEvent event) {
        String texto = numero.getText();
        if (!texto.matches("[0-9]*")) {
            numero.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    // CEP
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
    
    String pai;
    String est;
    String cid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* --------------- Combo Box - Tipo de Cliente ---------------------- */
        // Adicionando dados do Tipo de Cliente
        ObservableList<String> tipo = FXCollections.observableArrayList(
                "Selecione...",
                "Físico",
                "Jurídico"
        );
        tipoCliente.setItems(tipo);
        /* ------------------------------------------------------------------ */

        /* ----------------- Combo Box - Tipo de Sexo ----------------------- */
        // Adicionando dados do Tipo de Sexo
        ObservableList<String> sexo = FXCollections.observableArrayList(
                "Selecione...",
                "Masculino",
                "Feminino",
                "Outro"
        );
        tipoSexo.setItems(sexo);
        /* ------------------------------------------------------------------ */
        /* ----------------- Combo Box - Tipo de Endereço ------------------- */
        // Adicionando dados do Tipo de Sexo
        ObservableList<String> der = FXCollections.observableArrayList(
                "Selecione...",
                "Residencial",
                "Outro"
        );
        tipoEndereco.setItems(der);
        /* ------------------------------------------------------------------ */
        /* ----------------- Combo Box - Tipo de Estado ------------------- */
        // Adicionando dados do Tipo de Estado
        EstadoRN es = new EstadoRN();
        ArrayList listEstados = (ArrayList) es.buscarTodos("estSigla");
        ObservableList<String> ET = FXCollections.observableArrayList(
            listEstados
        );
        estado.setItems(ET);
       
        /* ------------------------------------------------------------------ */
        /* ------------------ Combo Box - Tipo de Cidade -------------------- */
        // Adicionando dados do Tipo de Estado
//        estado.setOnAction(event -> {
//            est = this.estado.getValue();
//            System.out.println(est);
//            String jpql = " SELECT t.tbCidade.cidDescricao FROM TbCidEstPai t WHERE t.tbCidEstPaiPK.cepEstSigla = '" + est + "'";
//            List<String> listCidades = pesquisa.
//            ObservableList<String> CI = FXCollections.observableArrayList(
//                listCidades
//            );
//            cidade.setItems(CI);
//        });
        CidadeRN cd = new CidadeRN();
        String jpql = " SELECT t.cidDescricao FROM TbCidade t";
        List<String> listCidades = cd.pesquisar(jpql);
        ObservableList<String> CI = FXCollections.observableArrayList(
            listCidades
        );
        cidade.setItems(CI);
        
        nacionalidade = new ToggleGroup();
        // Associe o ToggleGroup aos RadioButtons
        brasileiro.setToggleGroup(nacionalidade);
        estrangeiro.setToggleGroup(nacionalidade);
        // Adicione um evento para lidar com a seleção
        nacionalidade.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (nacionalidade.getSelectedToggle() == brasileiro) {
                pais.setValue("Brasil");
                // Faça algo quando o "Brasileiro" for selecionado
            } else if (nacionalidade.getSelectedToggle() == estrangeiro) {
                pais.setValue("Selecione...");
                // Faça algo quando o "Estrangeiro" for selecionado
            }
        });
    }

    @FXML
    void handleSalvarButton() {
        // Dados Pessoais
        String name = this.nome.getText();
        String nomeFant = this.nomeFantasia.getText();
        String sexoSele = this.tipoSexo.getValue();
        String tipocliente = this.tipoCliente.getValue();
        LocalDate dataNasc = this.dataNASC.getValue();
        Date dataNascDate = Date.from(dataNasc.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String Email = this.email.getText();
        String doc = this.cpfcnpj.getText();
        String contato = this.tipoContato.getValue();
        String nomContato = this.nomeContato.getText();
        String DDD = this.ddd.getText();
        String telefone = this.fone.getText();
        String obs = this.observacao.getText();
        // Dados de Endereço
        String log = this.logradouro.getText();
        String tipoEnd = this.tipoEndereco.getValue();
        String bai = this.bairro.getText();
        String comp = this.complemento.getText();
        String CEP = this.cep.getText();
        String numeroTex = this.numero.getText();
        // Inserindo os dados de endereço
        int num = 0;
        try {
            num = Integer.parseInt(numeroTex);
        } catch (NumberFormatException e) {}

        // Inserindo no Banco de Dados
        TbBairro BAIRRO = new TbBairro(bai);
        BairroRN ba = new BairroRN();
        ba.salvar(BAIRRO);
        TbLogradouro LOGR = new TbLogradouro(log);
        LogradouroRN logradourorn = new LogradouroRN();
        logradourorn.salvar(LOGR);
        TbPais PAI = new TbPais("BR",pai);
        PaisRN p = new PaisRN();
        p.salvar(PAI);
        TbEstado ESTADO = new TbEstado("PR",est);
        EstadoRN es = new EstadoRN();
        es.salvar(ESTADO);
        TbCidade CIDADE = new TbCidade(cid);
        CidadeRN cd = new CidadeRN();
        cd.salvar(CIDADE);
        TbCidEstPai CIESPA = new TbCidEstPai(CIDADE, ESTADO, PAI);
        CidEstPaiRN ciespa = new CidEstPaiRN();
        ciespa.salvar(CIESPA);
        TbEndPostal ENDPOSTAL = new TbEndPostal(tipoEnd, CEP, BAIRRO, CIESPA, LOGR);
        EndPostalRN ed = new EndPostalRN();
        ed.salvar(ENDPOSTAL);
        TbEndereco ENDERECO = new TbEndereco(num, comp, ENDPOSTAL);
        EnderecoRN end = new EnderecoRN();
        end.salvar(ENDERECO);
        // Inserindo na tabela Sexo        
        TbSexo SEX = new TbSexo(sexoSele);
        SexoRN s = new SexoRN();
        s.salvar(SEX);
        // Inserindo os dados na tabela entidade
        TbEntidade ENTIDADE = new TbEntidade(name, nomeFant, tipoEnd, est, telefone, Email, dataNascDate, est, ENDERECO, SEX);
        EntidadeRN ent = new EntidadeRN();
        ent.salvar(ENTIDADE);

        if (tipoEntidade1.isSelected()) {
            TbCliente CLIENTE = new TbCliente(ENTIDADE);
            ClienteRN cliente = new ClienteRN();
            cliente.salvar(CLIENTE);
        }
        if (tipoEntidade2.isSelected()) {
            TbFornecedor FORNECEDOR = new TbFornecedor(ENTIDADE);
            EntidadeRN entidade = new EntidadeRN();
            entidade.salvar(ENTIDADE);
        }
    }

    @FXML
    void handleCancelarbutton() {
        dialogStage.close();
    }
}
