package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbPedidoTransferencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PedidoTransferenciaDAOImpl implements PedidoTransferenciaDAO {

    EntityManager manager;

    public PedidoTransferenciaDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbPedidoTransferencia pedidotransferencia) {
        manager.getTransaction().begin();
        manager.persist(pedidotransferencia);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbPedidoTransferencia pedidotransferencia) {
        manager.getTransaction().begin();
        manager.merge(pedidotransferencia);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbPedidoTransferencia pedidotransferencia) {
        manager.getTransaction().begin();
        manager.remove(pedidotransferencia);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbPedidoTransferencia> listarTodos() {
        String jpql = "SELECT p FROM TbPedidoTransferencia p";
        Query query = manager.createQuery(jpql);
        List<TbPedidoTransferencia> pedidotransferenciaList = query.getResultList();
        return pedidotransferenciaList;
    }

    @Override
    public TbPedidoTransferencia listarUm(int id) {
        String jpql = "SELECT p FROM TbPedidoTransferencia p WHERE p.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbPedidoTransferencia) obj;
    }
}
