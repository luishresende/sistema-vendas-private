package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.TbEntidade;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.InputEvent;
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
            labelCPFCNPJ.setText("CNPJ *");
            labelRGIE.setText("Inscrição Estadual *");
            sexo.setDisable(true);
            data.setDisable(true);
        } else if ("Físico".equals(tipoSelecionado)) {
            // Formatação para CPF
            labelCPFCNPJ.setText("CPF *");
            labelRGIE.setText("RG *");
            sexo.setDisable(false);
            data.setDisable(false);
        } 
        cpfcnpj.clear();
        rgie.clear();
        sexo.setPromptText("Selecione...");
    }

    // Só valida a entrada de valores numéricos e formata de acordo o tipo de cliente
    public void validaCPFCNPJ(KeyEvent event, TextField cpfcnpj, ComboBox<String> tipo) {
        String texto = cpfcnpj.getText();
        String tipoSelecionado = tipo.getValue();
        if (!texto.matches("[0-9]*")) {
            cpfcnpj.setText(texto.replaceAll("[^0-9]", ""));
        }
        // Formatação do CNPJ
        if (texto.length() == 14 && "Jurídico".equals(tipoSelecionado)) {
            cpfcnpj.setText(texto.substring(0, 2) + "." + texto.substring(2, 5) + "." + texto.substring(5, 8) + "/" + texto.substring(8, 12) + "-" + texto.substring(12));
            cpfcnpj.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.length() > 18) {
                    cpfcnpj.setText(oldValue);
                }
            });
        }
        // Formatação do CPF
        if (texto.length() == 11 && "Físico".equals(tipoSelecionado)) {
            cpfcnpj.setText(texto.substring(0, 3) + "." + texto.substring(3, 6) + "." + texto.substring(6, 9) + "-" + texto.substring(9, 11));
            cpfcnpj.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.length() > 14) {
                    cpfcnpj.setText(oldValue);
                }
            });
        }
    }
    public void handleFocusLostCPFCNPJ(InputEvent event, TextField cpfcnpj, ComboBox<String> tipo) {
        String texto = cpfcnpj.getText();
        String tipoSelecionado = tipo.getValue();
        // Verifica se o número de caracteres é o esperado
        if ("Jurídico".equals(tipoSelecionado) && texto.length() != 18) {
            DisplayDialogScreen.getInstance().displayErrorScreen("CNPJ", "Verifique os dados inseridos!", "Preencha corretamente o campo CNPJ.");
        } else if(("Físico".equals(tipoSelecionado) && texto.length() != 14)){
            DisplayDialogScreen.getInstance().displayErrorScreen("CPF", "Verifique os dados inseridos!", "Preencha corretamente o campo CPF.");
        }
    }
    public void handleFocusLostRGIE(InputEvent event, TextField rgie, ComboBox<String> tipo) {
        String texto = rgie.getText();
        if (texto.length() != 14 && "Jurídico".equals(tipo.getValue())) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Inscrição Estadual", "Verifique os dados inseridos!", "Preencha corretamente o campo Inscrição Estadual.");
        }
    }
    public void validarRGIE(KeyEvent event, TextField rgie) {
        String texto = rgie.getText();
        if (!texto.matches("[0-9]*")) {
            rgie.setText(texto.replaceAll("[^0-9]", ""));
        }
        rgie.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 14) {
                rgie.setText(oldValue);
            }
        });
    }
    
    // Numero
    public void validarNUM(KeyEvent event, TextField numero) {
        String texto = numero.getText();
        if (!texto.matches("[0-9]*")) {
            numero.setText(texto.replaceAll("[^0-9]", ""));
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
    
    public void ficaVerificandoCampos(TextField nome, Label labelNome, TextField nomeFantasia, Label labelNomeFantasia, 
                                      TextField cpfcnpj, Label labelCPFCNPJ, TextField rgie, Label labelRGIE, 
                                      TextField email, Label labelEmail,
                                      TextField nomeContato, Label labelNomeContato, TextField ddd, Label labelDDD, 
                                      TextField fone, Label labelFone,  
                                      TextField nomerua, Label labelNomeRua, TextField bairro, Label labelBairro, 
                                      TextField cep, Label labelCEP) {
        addFocusListener(nome, labelNome);
        addFocusListener(nomeFantasia, labelNomeFantasia);
        addFocusListener(cpfcnpj, labelCPFCNPJ);
        addFocusListener(rgie, labelRGIE);
        addFocusListener(email, labelEmail);
        addFocusListener(nomeContato, labelNomeContato);
        addFocusListener(ddd, labelDDD);
        addFocusListener(fone, labelFone);
        addFocusListener(nomerua, labelNomeRua);
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
            validationLabel.setTextFill(RED);
            Tooltip.install(textField, tooltip);
        } else {
            textField.setStyle("");
            validationLabel.setTextFill(BLACK);
            Tooltip.uninstall(textField, tooltip);
        }
    }
    
    public void validarCampoCheck(CheckBox cliente, CheckBox fornecedor) {
        if (!cliente.isSelected() && !fornecedor.isSelected()) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Tipo de Entidade", "Falta selecionar!", "Selecione pelo menos um tipo de entidade.");
        }
    }
    
    public boolean validarNome(TextField nome) {
        if (nome.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarNomeFantasia(TextField nomeFantasia) {
        if (nomeFantasia.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCPFCNPJ(TextField cpfcnpj, ComboBox<String> tipo) {
        String texto = cpfcnpj.getText();
        if (cpfcnpj.getText().trim().isEmpty() && texto.length() < 14 || texto.length() > 18) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarRGIE(TextField rgie) {
        if (rgie.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarEmail(TextField email) {
        if (email.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoData(DatePicker data) {
        if (data.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoTipoCliente(ComboBox<String> tipoCliente) {
        if (tipoCliente.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<String> validarEntidadeJuridico(TbEntidade entidade) {
        ArrayList<String> errors = new ArrayList<String>();
        if(!entidade.getEntcpfCnpj().isEmpty()){
            String cnpj = entidade.getEntcpfCnpj();
            if (cnpj.length() != 18) {
                errors.add("Campo CNPJ incorreto.");
            }
        } else {
            errors.add("Preeencha o campo CNPJ.");
        }
        if(!entidade.getEntrgIe().isEmpty()) {
            String inscricaoEstadual = entidade.getEntrgIe();
            if(inscricaoEstadual.length() != 14) {
                errors.add("Campo Inscrição Estadual incorreto.");
            }
        } else {
            errors.add("Preencha o campo Inscrição Estadual.");
        }
        if(entidade.getEntEmail().isEmpty()) {
            errors.add("Preencha o campo Email.");
        }
        return errors;
    }
    public ArrayList<String> validarEntidadeFisico(TbEntidade entidade) {
        ArrayList<String> errors = new ArrayList<String>();
        if(!entidade.getEntcpfCnpj().isEmpty()){
            String cnpj = entidade.getEntcpfCnpj();
            if (cnpj.length() != 14) {
                errors.add("Campo CPF incorreto.");
            }
        } else {
            errors.add("Preeencha o campo CPF.");
        }
        if(!entidade.getEntrgIe().isEmpty()) {
            String inscricaoEstadual = entidade.getEntrgIe();
            if(inscricaoEstadual.length() != 14) {
                errors.add("Campo RG incorreto.");
            }
        } else {
            errors.add("Preencha o campo RG.");
        }
        if(entidade.getEntEmail().isEmpty()) {
            errors.add("Preencha o campo Email.");
        }
        if(entidade.getEntdtNasc() == null) {
            errors.add("Insira a data de nascimento.");
        }
        return errors;
    }
}
