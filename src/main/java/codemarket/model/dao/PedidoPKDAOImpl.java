package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbPedidoPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PedidoPKDAOImpl implements PedidoPKDAO {

    EntityManager manager;

    public PedidoPKDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbPedidoPK pedidopk) {
        manager.getTransaction().begin();
        manager.persist(pedidopk);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbPedidoPK pedidopk) {
        manager.getTransaction().begin();
        manager.merge(pedidopk);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbPedidoPK pedidopk) {
        manager.getTransaction().begin();
        manager.remove(pedidopk);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbPedidoPK> listarTodos() {
        String jpql = "SELECT pk FROM TbPedidoPK pk";
        Query query = manager.createQuery(jpql);
        List<TbPedidoPK> pedidopkList = query.getResultList();
        return pedidopkList;
    }

    @Override
    public TbPedidoPK listarUm(int id) {
        String jpql = "SELECT pk FROM TbPedidoPK pk WHERE pk.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbPedidoPK) obj;
    }
}
