package codemarket.model.rn;
import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidade;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
        sexo.setValue("Selecione...");
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
    
    public void verificaCamposText(TextField text) {
        text.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) { // Quando o foco é perdido
                validarCampo(text);
            }
        });
    }
    
    private void validarCampo(TextField textField) {
        if (textField.getText().trim().isEmpty()) {
            // Campo vazio, exibe mensagem de erro
            textField.setStyle("-fx-background-color: #FF9999;"); // Cor de fundo vermelha
            textField.setText("Por favor, insira algo.");
        } else {
            // Campo não vazio, limpa a mensagem de erro e restaura a cor de fundo padrão
            textField.setStyle("");
        }
    }
}
