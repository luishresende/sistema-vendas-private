/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbEntidadeHasEndereco;
import java.util.List;

/**
 *
 * @author Iuri Pereira
 */
public class EntidadeHasEnderecoRN {

    private GenericDAO<TbEntidadeHasEndereco> genericDao;

    public EntidadeHasEnderecoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbEntidadeHasEndereco end) {
        genericDao.salvar(end);
    }

    public void atualizar(TbEntidadeHasEndereco end) {
        genericDao.atualizar(end);
    }

    public void excluir(TbEntidadeHasEndereco end) {
        genericDao.excluir(end);
    }

    public List buscarTodos(String coluna) {
        List<TbEntidadeHasEndereco> Bairros = genericDao.listarTodos(TbEntidadeHasEndereco.class, coluna);
        return Bairros;
    }

    public TbEntidadeHasEndereco listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbEntidadeHasEndereco obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }

    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
