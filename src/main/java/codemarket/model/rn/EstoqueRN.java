package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEstoque;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
    private NumberFormat format, percentageFormat, numeroFormat;
    private SimpleDoubleProperty amount;

    public void initializeCurrencyField(TextField textField, Locale locale, Double initialAmount) {
        textField.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        amount = new SimpleDoubleProperty(this, "amount", initialAmount);
        String textFieldId = textField.getId();
        if ("idCompra".equals(textFieldId) || "idAvistaValor".equals(textFieldId)) {
            format = NumberFormat.getCurrencyInstance(locale);
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
                formatText(textField, newValue, format);
                Platform.runLater(() -> {
                    int length = textField.getText().length();
                    textField.positionCaret(length);
                });
            });
        }
        if ("idAvistaMargem".equals(textFieldId)) {
            percentageFormat = NumberFormat.getPercentInstance(locale);
            textField.setText(percentageFormat.format(initialAmount));
            textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                formatText(textField, newValue, percentageFormat);
                Platform.runLater(() -> {
                    int length = textField.getText().length();
                    textField.positionCaret(length);
                });
            });
        }
        if ("idMinimo".equals(textFieldId) || "idQuantidade".equals(textFieldId)) {
            numeroFormat = NumberFormat.getNumberInstance(locale);
            numeroFormat.setMinimumFractionDigits(2);
            textField.setText(numeroFormat.format(initialAmount));
            textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                formatText(textField, newValue, numeroFormat);
                Platform.runLater(() -> {
                    int length = textField.getText().length();
                    textField.positionCaret(length);
                });
            });
        }
    }

    public Double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return this.amount;
    }

    public void setAmount(TextField textField, Double newAmount, NumberFormat formato) {
        if (newAmount >= 0.0) {
            amount.set(newAmount);
            formatText(textField, formato.format(newAmount), formato);
        }
    }

    public void setCurrencyFormat(TextField textField, Locale locale, NumberFormat formato) {
        formato = NumberFormat.getCurrencyInstance(locale);
        formatText(textField, formato.format(getAmount()), formato);
    }

    private void formatText(TextField textField, String text, NumberFormat formato) {
        if (text != null && !text.isEmpty()) {
            String plainText = text.replaceAll("[^0-9]", "");

            while (plainText.length() < 3) {
                plainText = "0" + plainText;
            }

            StringBuilder builder = new StringBuilder(plainText);
            builder.insert(plainText.length() - 2, ".");

            Double newValue = Double.parseDouble(builder.toString());
            amount.set(newValue);
            textField.setText(formato.format(newValue));
        }
    }

    public void deleteText(TextField textField, int start, int end, NumberFormat formato) {
        StringBuilder builder = new StringBuilder(textField.getText());
        builder.delete(start, end);
        formatText(textField, builder.toString(), formato);
        textField.selectRange(start, start);
    }
    // ------------------------------------------------------------------------------------
    
    public boolean validarTextField(TextField textField) {
        if (textField.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validarComboBox(ComboBox<String> combo) {
        if (combo.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
}
