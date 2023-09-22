package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEntradaEstoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EntradaEstoqueDAOImpl implements EntradaEstoqueDAO {

    EntityManager manager;

    public EntradaEstoqueDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEntradaEstoque entradaestoque) {
        manager.getTransaction().begin();
        manager.persist(entradaestoque);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEntradaEstoque entradaestoque) {
        manager.getTransaction().begin();
        manager.merge(entradaestoque);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEntradaEstoque entradaestoque) {
        manager.getTransaction().begin();
        manager.remove(entradaestoque);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEntradaEstoque> listarTodos() {
        String jpql = "SELECT e FROM TbEntradaEstoque e";
        Query query = manager.createQuery(jpql);
        List<TbEntradaEstoque> entradaEstoqueList = query.getResultList();
        return entradaEstoqueList;
    }

    @Override
    public TbEntradaEstoque listarUm(int id) {
        String jpql = "SELECT e FROM TbEntradaEstoque e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEntradaEstoque) obj;
    }
}
