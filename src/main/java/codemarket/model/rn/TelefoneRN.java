/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTelefone;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static javafx.scene.paint.Color.*;

/**
 *
 * @author Iuri Pereira
 */
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
        }
        if (texto.length() >= 9) {
            event.consume(); // Impede que mais de 2 caracteres sejam inseridos
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
