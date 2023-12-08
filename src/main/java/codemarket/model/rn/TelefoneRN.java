
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.TbEntidadeHasTelefone;
import codemarket.model.vo.TbTelefone;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;


public class TelefoneRN {

    private GenericDAO<TbTelefone> genericDao;

    public TelefoneRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbTelefone Fone) {
        genericDao.salvar(Fone);
    }

    public void atualizar(TbTelefone Fone) {
        genericDao.atualizar(Fone);
    }

    public void excluir(TbTelefone Fone) {
        genericDao.excluir(Fone);
    }

    public List buscarTodos(String coluna) {
        List<TbTelefone> Fone = genericDao.listarTodos(TbTelefone.class, coluna);
        return Fone;
    }

    public TbTelefone listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbTelefone obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }

    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    
    public void validarDDD(KeyEvent event, TextField ddd) {
        String texto = ddd.getText();
        if (!texto.matches("[0-9]*")) {
            ddd.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 2) {
            // Formatação para "(DD)"
            ddd.setText("(" + texto + ")");
        }
        ddd.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4) {
                ddd.setText(oldValue);
            }
        });
    }
    public void handleFocusLostDDD(InputEvent event, TextField ddd) {
        String texto = ddd.getText();
        if (texto.length() != 4) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Aviso", "Campo DDD", "Preencha corretamente o campo DDD.");
        }
    }

    // Telefone
    public void validarFONE(KeyEvent event, TextField fone) {
        String texto = fone.getText();
        if (!texto.matches("[0-9]*")) {
            fone.setText(texto.replaceAll("[^0-9]", ""));
        }
        if (texto.length() == 9) {
            // Formatação para "(DD)"
            fone.setText(texto.substring(0, 1) + " " + texto.substring(1, 5) + "-" + texto.substring(5, 9));
            fone.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.length() > 11) {
                    fone.setText(oldValue);
                }
            });
        }
        
    }
    public void handleFocusLostFone(InputEvent event, TextField fone) {
        String texto = fone.getText();
        if (texto.length() != 11) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Aviso", "Campo Fone", "Preencha corretamente o campo Fone.");
        }
    }
    public boolean validarCampoDDD(TextField ddd) {
        if (ddd.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoFone(TextField fone) {
        if (fone.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
