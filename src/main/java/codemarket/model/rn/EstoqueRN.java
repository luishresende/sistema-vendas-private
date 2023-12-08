package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoque;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.Locale;
import java.util.function.UnaryOperator;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.PercentageStringConverter;

;

public class EstoqueRN {

    private GenericDAO<TbEstoque> genericDao;

    public EstoqueRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEstoque Estoque) {
        genericDao.salvar(Estoque);
    }

    public void atualizar(TbEstoque Estoque) {
        genericDao.atualizar(Estoque);
    }

    public void excluir(TbEstoque Estoque) {
        genericDao.excluir(Estoque);
    }

    public List buscarTodos(String coluna) {
        List<TbEstoque> Estoques = genericDao.listarTodos(TbEstoque.class, coluna);
        return Estoques;
    }

    public TbEstoque listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEstoque obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }

    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }

    public void aceitaNumero(KeyEvent event, TextField valor) {
        String texto = valor.getText();
        if (!texto.matches("[0-9]*")) {
            valor.setText(texto.replaceAll("[^0-9]", ""));
        }
    }

    // Formatação monetária ---------------------------------------------------------------------
    private NumberFormat format, percentageFormat;
    private SimpleDoubleProperty amount;

    public void initializeCurrencyField(TextField textField, Locale locale, Double initialAmount) {
        textField.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        amount = new SimpleDoubleProperty(this, "amount", initialAmount);
        String textFieldId = textField.getId();
        // Erro aqui ------------------------------------------
        if ("idCompra".equals(textFieldId) || "idAvistaCompra".equals(textFieldId)) {
            format = NumberFormat.getCurrencyInstance(locale);
        } else if ("idAvistaMargem".equals(textFieldId)) {
            format = NumberFormat.getNumberInstance(locale);
        }
        // ---------------------------------------------------
        textField.setText(format.format(initialAmount));

        // Remove selection when textfield gets focus
        textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            Platform.runLater(() -> {
                int length = textField.getText().length();
                textField.selectRange(length, length);
                textField.positionCaret(length);
            });
        });

        // Listen the text's changes
        textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            formatText(textField, newValue);
            Platform.runLater(() -> {
                int length = textField.getText().length();
                textField.positionCaret(length);
            });
        });
    }

    public Double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return this.amount;
    }

    public void setAmount(TextField textField, Double newAmount) {
        if (newAmount >= 0.0) {
            amount.set(newAmount);
            formatText(textField, format.format(newAmount));
        }
    }

    public void setCurrencyFormat(TextField textField, Locale locale) {
        format = NumberFormat.getCurrencyInstance(locale);
        formatText(textField, format.format(getAmount()));
    }

    private void formatText(TextField textField, String text) {
        if (text != null && !text.isEmpty()) {
            String plainText = text.replaceAll("[^0-9]", "");

            while (plainText.length() < 3) {
                plainText = "0" + plainText;
            }

            StringBuilder builder = new StringBuilder(plainText);
            builder.insert(plainText.length() - 2, ".");

            Double newValue = Double.parseDouble(builder.toString());
            amount.set(newValue);
            textField.setText(format.format(newValue));
        }
    }

    public void deleteText(TextField textField, int start, int end) {
        StringBuilder builder = new StringBuilder(textField.getText());
        builder.delete(start, end);
        formatText(textField, builder.toString());
        textField.selectRange(start, start);
    }
    // ------------------------------------------------------------------------------------
}
