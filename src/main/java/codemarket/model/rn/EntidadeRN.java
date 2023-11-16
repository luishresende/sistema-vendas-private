package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidade;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import static javafx.scene.paint.Color.*;
import javafx.util.Callback;
;

public class EntidadeRN {

    private GenericDAO<TbEntidade> genericDao;
    
    public EntidadeRN() {
        genericDao = new GenericDAO<>();
    }
    
    public void salvar(TbEntidade Entidade) {
        genericDao.salvar(Entidade);
    }

    public void atualizar(TbEntidade Entidade) {
        genericDao.atualizar(Entidade);
    }

    public void excluir(TbEntidade Entidade) {
        genericDao.excluir(Entidade);
    }
    public List buscarTodos(String coluna) {
        List<TbEntidade> Entidades = genericDao.listarTodos(TbEntidade.class, coluna);
        return Entidades;
    }
    public TbEntidade listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEntidade obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    
    public void onTipoClienteChanged(ActionEvent event, ComboBox<String> tipoCliente, TextField cpfcnpj, TextField rgie, Label labelCPFCNPJ, Label labelRGIE, ComboBox<String> sexo, DatePicker data) {
        String tipoSelecionado = tipoCliente.getValue(); // Obtém o tipo selecionado na ComboBox
        if ("Jurídico".equals(tipoSelecionado)) {
            // Formatação para CNPJ
            labelCPFCNPJ.setText("CNPJ");
            labelRGIE.setText("Inscrição Estadual");
            sexo.setDisable(true);
            data.setDisable(true);
        } else if ("Físico".equals(tipoSelecionado)) {
            // Formatação para CPF
            labelCPFCNPJ.setText("CPF");
            labelRGIE.setText("RG");
            sexo.setDisable(false);
            data.setDisable(false);
        } else {
            labelCPFCNPJ.setText("CPF / CNPJ");
            labelRGIE.setText("RG / IE");
            sexo.setDisable(true);
            data.setDisable(true);
        }
        cpfcnpj.clear();
        rgie.clear();
        sexo.setPromptText("Selecione...");
    }

    // Só valida a entrada de valores numéricos e formata de acordo o tipo de cliente
    public void validarCPFCNPJ(KeyEvent event, TextField cpfcnpj, ComboBox<String> tipo) {
        String texto = cpfcnpj.getText();
        if (!texto.matches("[0-9]*")) {
            // Só aceita valores numéricos
            cpfcnpj.setText(texto.replaceAll("[^0-9]", ""));
        }
        String tipoSelecionado = tipo.getValue(); // Obtém o tipo selecionado na ComboBox 
        if (texto.length() == 14 && "Jurídico".equals(tipoSelecionado)) {
            // Formatação para CNPJ "99.999/9999-99"
            cpfcnpj.setText(texto.substring(0, 2) + "." + texto.substring(2, 5) + "." + texto.substring(5, 8) + "/" + texto.substring(8, 12) + "-" + texto.substring(12));
        } else if (texto.length() == 11 && "Físico".equals(tipoSelecionado)) {
            // Formatação para CPF "999.999.999-99"
            cpfcnpj.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
        }
    }
    
    public void validarRGIE(KeyEvent event, TextField rgie) {
        String texto = rgie.getText();
        if (!texto.matches("[0-9]*")) {
            rgie.setText(texto.replaceAll("[^0-9]", ""));
        }
    }
    
    // Numero
    public void validarNUM(KeyEvent event, TextField numero) {
        String texto = numero.getText();
        if (!texto.matches("[0-9]*")) {
            numero.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    // Valida CEP
    public void validarCEP(KeyEvent event, TextField cep) {
        String texto = cep.getText();
        if (!texto.matches("[0-9]*")) {
            cep.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 8) {
            cep.setText(texto.substring(0, 5) + "-" + texto.substring(5, 8));
        }
    }
    
    public Callback<DatePicker, DateCell> getDataAnterior() {
        return datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                // Desativar datas posteriores ao dia atual
                if (item.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: lightgray;"); // Cor de fundo para datas desativadas (opcional)
                }
            }
        };
    }
    
    public Date verificaData(DatePicker dataNASC) {
        Date dateNASC = null;
        if(!dataNASC.isDisable()){
            LocalDate dtNASC = dataNASC.getValue();  // Obter a data do DatePicker
            dateNASC = Date.from(dtNASC.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        return dateNASC;
    }
    
    public void ficaVerificandoCampos(TextField nome, TextField nomeFantasia, TextField cpfcnpj, TextField rgie, TextField email,
                                      TextField nomeContato, TextField ddd, TextField fone, Label labelNome, Label labelNomeFantasia,
                                      TextField nomerua, TextField bairro, TextField cep, Label labelCPFCNPJ, Label labelRGIE, 
                                      Label labelEmail, Label labelNomeContato, Label labelDDD, Label labelFone, Label labelEndereco,
                                      Label labelBairro, Label labelCEP) {
        addFocusListener(nome, labelNome);
        addFocusListener(nomeFantasia, labelNomeFantasia);
        addFocusListener(cpfcnpj, labelCPFCNPJ);
        addFocusListener(rgie, labelRGIE);
        addFocusListener(email, labelEmail);
        addFocusListener(nomeContato, labelNomeContato);
        addFocusListener(ddd, labelDDD);
        addFocusListener(fone, labelFone);
        addFocusListener(nomerua, labelEndereco);
        addFocusListener(bairro, labelBairro);
        addFocusListener(cep, labelCEP);
    }
    
    public void addFocusListener(TextField textField, Label validationLabel) {
        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) { // Quando o foco é perdido
                validarCampoText(textField, validationLabel);
            }
        });
    }
    
    private void validarCampoText(TextField textField, Label validationLabel) {
        Tooltip tooltip = new Tooltip("Por favor, insira algo.");
        if (textField.getText().trim().isEmpty()) {
            textField.setStyle("-fx-border-color: red;");
            validationLabel.setStyle("-fx-text-fill: red;");
            Tooltip.install(textField, tooltip);
        } else {
            textField.setStyle("");
            validationLabel.setText("");
            Tooltip.uninstall(textField, tooltip);
        }
    }
    
    public boolean validarCampo(TextField nome, TextField nomeFantasia, TextField cpfcnpj, TextField rgie, TextField email,
                                    Label labelNome, Label labelNomeFantasia, Label labelCPFCNPJ, Label labelRGIE, Label labelEmail, 
                                    ComboBox<String> tipoSexo, ComboBox<String> tipoCliente, Label labelTipoCliente, Label labelSexo,
                                    DatePicker data, Label labelDt) {
        if (nome.getText().trim().isEmpty() || nomeFantasia.getText().trim().isEmpty() || cpfcnpj.getText().trim().isEmpty() || 
            rgie.getText().trim().isEmpty() || email.getText().trim().isEmpty() || tipoSexo.getValue() == null || tipoCliente.getValue() == null ||
            data.getValue() == null) {

            labelNome.setTextFill(RED);
            nome.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelNomeFantasia.setTextFill(RED);
            nomeFantasia.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelCPFCNPJ.setTextFill(RED);
            cpfcnpj.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelRGIE.setTextFill(RED);
            rgie.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelEmail.setTextFill(RED);
            email.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelTipoCliente.setTextFill(RED);
            tipoCliente.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelSexo.setTextFill(RED);
            tipoSexo.setStyle("-fx-border-color: #FF9999;");
            labelDt.setTextFill(RED);
            data.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            
            return true;
        } else {
            labelNome.setTextFill(BLACK);
            nome.setStyle("");
            labelNomeFantasia.setTextFill(BLACK);
            nomeFantasia.setStyle("");
            labelCPFCNPJ.setTextFill(BLACK);
            cpfcnpj.setStyle("");
            labelRGIE.setTextFill(BLACK);
            rgie.setStyle("");
            labelEmail.setTextFill(BLACK);
            email.setStyle("");
            labelSexo.setTextFill(BLACK);
            tipoSexo.setStyle("");
            labelTipoCliente.setTextFill(BLACK);
            tipoCliente.setStyle("");
            labelDt.setTextFill(BLACK);
            data.setStyle("");
            
            return false;
        }
    }
    
    public boolean validarCamposTableFone(TextField nomeContato, TextField ddd, TextField fone, 
                                             Label labelNomeContato, Label labelDDD, Label labelFone,
                                             ComboBox<String> tipoContato, Label labelTipoContato) {
        if (nomeContato.getText().trim().isEmpty() || ddd.getText().trim().isEmpty() || fone.getText().trim().isEmpty() 
            || tipoContato.getValue() == null) {
            // Campo vazio, exibe mensagem de erro
            labelNomeContato.setTextFill(RED);
            nomeContato.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelDDD.setTextFill(RED);
            ddd.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelFone.setTextFill(RED);
            fone.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelTipoContato.setTextFill(RED);
            tipoContato.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            return true;
        } else {
            // Campo não vazio, limpa a mensagem de erro e restaura a cor de fundo padrão
            labelNomeContato.setTextFill(BLACK);
            nomeContato.setStyle(""); // Cor de fundo vermelha
            labelDDD.setTextFill(BLACK);
            ddd.setStyle(""); // Cor de fundo vermelha
            labelFone.setTextFill(BLACK);
            fone.setStyle(""); // Cor de fundo vermelha
            labelTipoContato.setTextFill(BLACK);
            tipoContato.setStyle(""); // Cor de fundo vermelha
            return false;
        }
    }
    
    public boolean validarCamposTableEndereco(TextField nomerua, TextField bairro, TextField CEP, 
                                              Label labelEndereco, Label labelBairro, Label labelCEP, 
                                              ComboBox<String> logradouro, ComboBox<String> tipoEndereco,
                                              Label labelLogradouro, Label labelTipoEnd) {
        if (nomerua.getText().trim().isEmpty() || bairro.getText().trim().isEmpty() || CEP.getText().trim().isEmpty()) {
            // Campo vazio, exibe mensagem de erro
            labelEndereco.setTextFill(RED);
            nomerua.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelBairro.setTextFill(RED);
            bairro.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelCEP.setTextFill(RED);
            CEP.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelLogradouro.setTextFill(RED);
            logradouro.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            labelTipoEnd.setTextFill(RED);
            tipoEndereco.setStyle("-fx-border-color: #FF9999;"); // Cor de fundo vermelha
            
            return true;
        } else {
            // Campo não vazio, limpa a mensagem de erro e restaura a cor de fundo padrão
            labelEndereco.setTextFill(BLACK);
            nomerua.setStyle(""); // Cor de fundo vermelha
            labelBairro.setTextFill(BLACK);
            bairro.setStyle(""); // Cor de fundo vermelha
            labelCEP.setTextFill(BLACK);
            CEP.setStyle(""); // Cor de fundo vermelha
            
            return false;
        }
    }
    
    public void exibirAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validação de Campos");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
