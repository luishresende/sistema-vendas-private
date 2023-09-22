package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEstoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EstoqueDAOImpl implements EstoqueDAO {

    EntityManager manager;

    public EstoqueDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEstoque estoque) {
        manager.getTransaction().begin();
        manager.persist(estoque);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEstoque estoque) {
        manager.getTransaction().begin();
        manager.merge(estoque);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEstoque estoque) {
        manager.getTransaction().begin();
        manager.remove(estoque);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEstoque> listarTodos() {
        String jpql = "SELECT e FROM TbEstoque e";
        Query query = manager.createQuery(jpql);
        List<TbEstoque> estoqueList = query.getResultList();
        return estoqueList;
    }

    @Override
    public TbEstoque listarUm(int id) {
        String jpql = "SELECT e FROM TbEstoque e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEstoque) obj;
    }
}
