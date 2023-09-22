package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbCliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDAOImpl implements ClienteDAO {

    EntityManager manager;

    public ClienteDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbCliente cliente) {
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbCliente cliente) {
        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbCliente cliente) {
        manager.getTransaction().begin();
        manager.remove(cliente);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbCliente> listarTodos() {
        String jpql = "SELECT c FROM TbCliente c";
        Query query = manager.createQuery(jpql);
        List<TbCliente> clienteList = query.getResultList();
        return clienteList;
    }

    @Override
    public TbCliente listarUm(int id) {
        String jpql = "SELECT c FROM TbCliente c WHERE c.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbCliente) obj;
    }
}
