package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEstado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EstadoDAOImpl implements EstadoDAO {

    EntityManager manager;

    public EstadoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEstado estado) {
        manager.getTransaction().begin();
        manager.persist(estado);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEstado estado) {
        manager.getTransaction().begin();
        manager.merge(estado);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEstado estado) {
        manager.getTransaction().begin();
        manager.remove(estado);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEstado> listarTodos() {
        String jpql = "SELECT e FROM TbEstado e";
        Query query = manager.createQuery(jpql);
        List<TbEstado> estadoList = query.getResultList();
        return estadoList;
    }

    @Override
    public TbEstado listarUm(int id) {
        String jpql = "SELECT e FROM TbEstado e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEstado) obj;
    }
}
