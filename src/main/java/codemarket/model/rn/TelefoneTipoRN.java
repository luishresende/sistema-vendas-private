/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.rn;

import codemarket.model.dao.GenericDAO;
import codemarket.model.vo.TbTelefoneTipo;
import java.util.List;

/**
 *
 * @author Iuri Pereira
 */
public class TelefoneTipoRN {

    private GenericDAO<TbTelefoneTipo> genericDao;

    public TelefoneTipoRN() {
        genericDao = new GenericDAO<>();
    }

    public void salvar(TbTelefoneTipo Fone) {
        genericDao.salvar(Fone);
    }

    public void atualizar(TbTelefoneTipo Fone) {
        genericDao.atualizar(Fone);
    }

    public void excluir(TbTelefoneTipo Fone) {
        genericDao.excluir(Fone);
    }

    public List buscarTodos(String coluna) {
        List<TbTelefoneTipo> Bairros = genericDao.listarTodos(TbTelefoneTipo.class, coluna);
        return Bairros;
    }

    public TbTelefoneTipo listaUm(String pesquisa, String valor, Class classe) {
        String jpql = "SELECT t FROM " + classe.getTypeName() + "t where t." + pesquisa + " = '" + valor + "'";
        TbTelefoneTipo obj = genericDao.listarUm(pesquisa, valor, classe);
        return obj;
    }

    public List pesquisar(String jpql) {
        List obj = genericDao.pesquisar(jpql);
        return obj;
    }
}
