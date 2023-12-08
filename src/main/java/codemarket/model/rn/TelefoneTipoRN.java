/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.vo.TbTipoTelefone;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.paint.Color.*;

/**
 *
 * @author Iuri Pereira
 */
public class TelefoneTipoRN {

    private GenericDAO<TbTipoTelefone> genericDao;

    public TelefoneTipoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbTipoTelefone Fone) {
        genericDao.salvar(Fone);
    }

    public void atualizar(TbTipoTelefone Fone) {
        genericDao.atualizar(Fone);
    }

    public void excluir(TbTipoTelefone Fone) {
        genericDao.excluir(Fone);
    }

    public List buscarTodos(String coluna) {
        List<TbTipoTelefone> Bairros = genericDao.listarTodos(TbTipoTelefone.class, coluna);
        return Bairros;
    }

    public TbTipoTelefone listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbTipoTelefone obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }

    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
    public boolean validarCampoTipoContato(ComboBox<String> tipoContato) {
        if (tipoContato.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validarCampoNomeContato(TextField nomeContato) {
        if (nomeContato.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
