package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbPedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PedidoDAOImpl implements PedidoDAO {

    EntityManager manager;

    public PedidoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbPedido pedido) {
        manager.getTransaction().begin();
        manager.persist(pedido);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbPedido pedido) {
        manager.getTransaction().begin();
        manager.merge(pedido);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbPedido pedido) {
        manager.getTransaction().begin();
        manager.remove(pedido);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbPedido> listarTodos() {
        String jpql = "SELECT p FROM TbPedido p";
        Query query = manager.createQuery(jpql);
        List<TbPedido> pedidoList = query.getResultList();
        return pedidoList;
    }

    @Override
    public TbPedido listarUm(int id) {
        String jpql = "SELECT p FROM TbPedido p WHERE p.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbPedido) obj;
    }
}
