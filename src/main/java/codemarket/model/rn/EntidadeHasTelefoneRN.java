/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidadeHasTelefone;
import java.util.List;

/**
 *
 * @author Iuri Pereira
 */
public class EntidadeHasTelefoneRN {

    private GenericDAO<TbEntidadeHasTelefone> genericDao;

    public EntidadeHasTelefoneRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntidadeHasTelefone Fone) {
        genericDao.salvar(Fone);
    }

    public void atualizar(TbEntidadeHasTelefone Fone) {
        genericDao.atualizar(Fone);
    }

    public void excluir(TbEntidadeHasTelefone Fone) {
        genericDao.excluir(Fone);
    }

    public List buscarTodos(String coluna) {
        List<TbEntidadeHasTelefone> Bairros = genericDao.listarTodos(TbEntidadeHasTelefone.class, coluna);
        return Bairros;
    }

    public TbEntidadeHasTelefone listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEntidadeHasTelefone obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }

    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
