/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTipoTelefone;
import java.util.List;

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
}
