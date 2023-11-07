/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTelefone;
import java.util.List;

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
}
