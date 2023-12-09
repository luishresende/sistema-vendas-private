package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.*;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.List;import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Tooltip;
import static javafx.scene.paint.Color.*;
import javafx.util.Callback;

public class UsuarioRN {

    private GenericDAO<TbUsuario> genericDao;

    public UsuarioRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbUsuario Usuario) {
        genericDao.salvar(Usuario);
    }

    public void atualizar(TbUsuario Usuario) {
        genericDao.atualizar(Usuario);
    }

    public void excluir(TbUsuario Usuario) {
        genericDao.excluir(Usuario);
    }
    public List buscarTodos(String coluna) {
        List<TbUsuario> Usuarios = genericDao.listarTodos(TbUsuario.class, coluna);
        return Usuarios;
    }
    public TbUsuario listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbUsuario obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }
    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    
    public Callback<DatePicker, DateCell> getDataPosterior() {
        return datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                // Desativar datas anteriores ao dia atual
                if (item.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: lightgray;"); // Cor de fundo para datas desativadas (opcional)
                }
            }
        };
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
    public void onTipoCargoSelecionado(ActionEvent event, TextField salario, ComboBox<String> tipoCargo) {
        CargoRN sal = new CargoRN();
        TbCargo valor = sal.listaUm("carDescricao", tipoCargo.getValue(), TbCargo.class);
        double salarioBase = valor.getCarsalarioBase();

        // Formata o salário base
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String salarioBaseFormatado = decimalFormat.format(salarioBase);

        salario.setText("R$ " + salarioBaseFormatado);

        // Configura a formatação para o TextField
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.isContentChange()) {
                String newText = change.getControlNewText();
                ParsePosition parsePosition = new ParsePosition(0);
                Number number = decimalFormat.parse(newText, parsePosition);
                if (number == null || parsePosition.getIndex() < newText.length()) {
                    return null;
                }
            }
            return change;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);

        salario.setTextFormatter(textFormatter);
    }
    public boolean validarCampoUsuario(TextField usuario) {
        if (usuario.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoSenha(TextField senha) {
        if (senha.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoConfirmaSenha(TextField usuario) {
        if (usuario.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarComboBoxCargo(ComboBox<String> cargo) {
        if (cargo.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarComboBoxStatus(ComboBox<String> status) {
        if (status.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean verificaSenhas(TextField senha, TextField confirmaSenha) {
        if (!senha.getText().equals(confirmaSenha.getText())) {
            return false;
        } else {
            return true;
        }
    }
}
