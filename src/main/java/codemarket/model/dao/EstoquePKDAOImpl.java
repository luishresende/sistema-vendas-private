package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEstoquePK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EstoquePKDAOImpl implements EstoquePKDAO {

    EntityManager manager;

    public EstoquePKDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEstoquePK estoquepk) {
        manager.getTransaction().begin();
        manager.persist(estoquepk);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEstoquePK estoquepk) {
        manager.getTransaction().begin();
        manager.merge(estoquepk);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEstoquePK estoquepk) {
        manager.getTransaction().begin();
        manager.remove(estoquepk);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEstoquePK> listarTodos() {
        String jpql = "SELECT e FROM TbEstoquePK e";
        Query query = manager.createQuery(jpql);
        List<TbEstoquePK> estoquepkList = query.getResultList();
        return estoquepkList;
    }

    @Override
    public TbEstoquePK listarUm(int id) {
        String jpql = "SELECT e FROM TbEstoquePK e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEstoquePK) obj;
    }
}
